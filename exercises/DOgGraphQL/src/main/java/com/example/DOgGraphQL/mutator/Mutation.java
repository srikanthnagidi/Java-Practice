package com.example.DOgGraphQL.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DOgGraphQL.entity.Dog;
import com.example.DOgGraphQL.exception.BreedNotFoundException;
import com.example.DOgGraphQL.exception.DogNotFoundException;
import com.example.DOgGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog newDog (String name, String breed, String origin){
        Dog dog = new Dog(name, breed, origin);
        dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDog(Long id) throws DogNotFoundException {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog upDateDogName(Long id, String name){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        }else {
            throw new DogNotFoundException("Dog Not found", id);
        }
    }

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();

        for(Dog d:allDogs){
            if (d.getBreed().equalsIgnoreCase(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted){
            throw new BreedNotFoundException("Breed NotFound", breed);
        }
        return deleted;
    }
}

package com.example.DOgGraphQL.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DOgGraphQL.entity.Dog;
import com.example.DOgGraphQL.exception.DogNotFoundException;
import com.example.DOgGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

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
}

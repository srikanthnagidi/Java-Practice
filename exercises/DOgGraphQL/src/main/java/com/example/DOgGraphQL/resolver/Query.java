package com.example.DOgGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DOgGraphQL.entity.Dog;
import com.example.DOgGraphQL.exception.DogNotFoundException;
import com.example.DOgGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository=dogRepository;
    }
    public Iterable<Dog> findAllDogs() {return  dogRepository.findAll();}
/*    public Iterable<String> findAllBreed(){
        return dogRepository.findAllBreed();
    }
    public Iterable<String> findAllName(){
        return dogRepository.findAllName();
    }*/

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}

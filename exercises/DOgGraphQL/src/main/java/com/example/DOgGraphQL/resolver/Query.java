package com.example.DOgGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DOgGraphQL.repository.DogRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository=dogRepository;
    }
    public Iterable<String> findAllBreed(){
        return dogRepository.findAllBreed();
    }
    public Iterable<String> findAllName(){
        return dogRepository.findAllName();
    }
    public String findBreedById(Long id){
        return dogRepository.findBreedById(id);
    }
}

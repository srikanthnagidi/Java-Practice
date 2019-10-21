package com.example.DOgGraphQL.service;

import com.example.DOgGraphQL.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreeds();
    List<String> retrieveDogNames();
    String retrieveDogBreedById(Long id);
}

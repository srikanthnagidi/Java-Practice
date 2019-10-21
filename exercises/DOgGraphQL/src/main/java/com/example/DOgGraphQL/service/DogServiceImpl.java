package com.example.DOgGraphQL.service;

import com.example.DOgGraphQL.entity.Dog;
import com.example.DOgGraphQL.exception.DogNotFoundException;
import com.example.DOgGraphQL.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreeds() {
        return dogRepository.findAllBreed();
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findAllName();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        if(optionalBreed.isPresent()){
            String breed = optionalBreed.get();
            return breed;
        }else {
            throw new DogNotFoundException("not a valid id", id);
        }
    }
}

package com.example.DOgGraphQL.repository;

import com.example.DOgGraphQL.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);
}

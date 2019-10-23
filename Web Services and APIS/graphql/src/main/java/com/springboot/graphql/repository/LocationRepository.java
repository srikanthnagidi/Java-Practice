package com.springboot.graphql.repository;

import com.springboot.graphql.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}

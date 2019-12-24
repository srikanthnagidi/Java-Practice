package com.example.monodb.demo.repository;

import com.example.monodb.demo.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByFirstName(String firstName);
}

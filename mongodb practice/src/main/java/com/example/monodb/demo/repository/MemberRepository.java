package com.example.monodb.demo.repository;

import com.example.monodb.demo.entity.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
}

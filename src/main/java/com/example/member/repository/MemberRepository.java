package com.example.member.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.member.entity.Member;

import java.util.List;

@Repository
public interface MemberRepository extends MongoRepository<Member, Object> {

    Member findByMemberId(Integer memberId);

    List<Member> findByMemberType(String  memberType);
}

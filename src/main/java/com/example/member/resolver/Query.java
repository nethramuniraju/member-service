package com.example.member.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private MemberRepository memberRepository;

    public Iterable<Member> findAllMember() {

        return memberRepository.findAll();
    }

    public Member findMemberById(Integer memberId) {
        log.info("Inside Query");
        return memberRepository.findByMemberId(memberId);
    }

    public List<Member> findMemberByType(String memberType) {
        return memberRepository.findByMemberType(memberType);
    }
}

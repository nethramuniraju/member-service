package com.example.member.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.member.entity.Member;
import com.example.member.exception.CustomGraphQLException;
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
        List<Member> memberList = memberRepository.findAll();
        if (memberList.isEmpty())
            throw new CustomGraphQLException(400, "Members not found in mongo collection");
        return memberList;
    }

    public Member findMemberById(Integer memberId) {
        log.info("Inside Query");
        Member member = memberRepository.findByMemberId(memberId);
        if (member == null)
            throw new CustomGraphQLException(400, "Member not found in mongo collection for given member id");
        return member;
    }

    public List<Member> findMemberByType(String memberType) {

        List<Member> memberList = memberRepository.findByMemberType(memberType);
        if (memberList.isEmpty())
            throw new CustomGraphQLException(400, "Members not found in mongo collection for given member type");
        return memberList;
    }
}

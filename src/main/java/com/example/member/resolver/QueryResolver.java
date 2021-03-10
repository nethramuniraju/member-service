package com.example.member.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.member.entity.Member;
import com.example.member.exception.CustomGraphQLException;
import com.example.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private MemberRepository memberRepository;

    //find all members
    public Iterable<Member> findAllMember() throws CustomGraphQLException {
        List<Member> memberList = memberRepository.findAll();
        if (memberList.isEmpty())
            throw new CustomGraphQLException("Members not found in mongo collection");
        return memberList;
    }

    //find member by Id
    public Member findMemberById(Integer memberId) throws CustomGraphQLException {
        log.info("Inside Query");
        Member member = memberRepository.findByMemberId(memberId);
        if (member == null)
            throw new CustomGraphQLException("Member not found in mongo collection for given member id");
        return member;
    }

    //find member by type
    public List<Member> findMemberByType(String memberType) throws CustomGraphQLException {

        List<Member> memberList = memberRepository.findByMemberType(memberType);
        if (memberList.isEmpty())
            throw new CustomGraphQLException("Members not found in mongo collection for given member type");
        return memberList;
    }

    //find member by Id and type
    public Member findMember(Integer memberId, String memberType) {
        Member id = memberRepository.findByMemberId(memberId);
        int mId = id.getMemberId();
        String type = id.getMemberType();

        if (type.equals(memberType)) {
            return memberRepository.findByMemberId(memberId);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Member not found"
            );
        }
        //return null;
    }
}

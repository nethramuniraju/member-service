package com.example.member.resolver;

import com.example.member.entity.Claim;
import com.example.member.entity.Member;
import com.example.member.exception.CustomGraphQLException;
import com.example.member.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kotlin.ExtensionFunctionType;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {
    private MemberRepository memberRepository;

    private ClaimsUtility claimsUtility;
    
    @Autowired
    private ScalarConfig ScalarConfig;

    public String createMember(Member member, Claim claim) throws Exception {

        try {
            //creates a claim for given member
            if (null != claim) {
                claim.setMemberId(String.valueOf(member.getMemberId()));
                member.setCreatedOn(LocalDate.now());
                claimsUtility.createClaim(claim);
            }
        } catch (Exception e) {
            throw new CustomGraphQLException("Couldn't reach claims service hence claims can't be created");
        }

        memberRepository.save(member);
        return "Member is created with member id " + member.getMemberId();
    }


    public String deleteMember(int memberId) throws JsonMappingException, JsonProcessingException {
        memberRepository.deleteById(memberId);
        return "Member deleted successfully!";
    }

    public String updateMember(int memberId, String firstName, String lastName) {
        Member newObj = new Member();
        newObj.setMemberId(memberId);
        newObj.setFirstName(firstName);
        newObj.setLastName(lastName);
        memberRepository.save(newObj);
        return "Member is updated successfully";
    }
}

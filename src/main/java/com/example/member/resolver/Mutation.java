package com.example.member.resolver;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.member.claim.model.Claim;
import com.example.member.claim.utility.ClaimsUtility;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private MemberRepository memberRepository;

    private ClaimsUtility claimsUtility;


    public Member createMember(Member input, Claim claim) {

        //creates a claim for given member
        claimsUtility.createClaim(claim);

        return memberRepository.save(input);
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

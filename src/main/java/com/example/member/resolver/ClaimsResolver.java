package com.example.member.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.member.entity.Claim;
import com.example.member.entity.Member;
import com.example.member.exception.CustomGraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimsResolver implements GraphQLResolver<Member> {

    @Autowired
    private ClaimsUtility claimsUtility;

    public Claim getClaim(Member member) {
        try {

            Claim claim = claimsUtility.findClaimsForMember(String.valueOf(member.getMemberId())).join();
            if (null == claim)
                throw new CustomGraphQLException("Member doesn't have claim");
            return claim;

        } catch (Exception e) {
            throw new CustomGraphQLException("Couldn't reach claims service hence claim can't be returned");
        }
    }

}

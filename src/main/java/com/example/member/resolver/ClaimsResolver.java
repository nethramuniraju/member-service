package com.example.member.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.member.entity.Claim;
import com.example.member.resolver.ClaimsUtility;
import com.example.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimsResolver implements GraphQLResolver<Member> {

    @Autowired
    private ClaimsUtility claimsUtility;

    public Claim getClaim(Member member) {
        try {
            return claimsUtility.findClaimsForMember(String.valueOf(member.getMemberId())).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package com.example.member.service;


import com.example.member.wrapper.ResponseTemplateWrapper;
import com.example.member.entity.Claim;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.time.LocalDate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SequenceGeneratorService service;
    @Autowired
    private RestTemplate restTemplate;

    //Create Member 
    public Member saveMember(Member member) {
        log.info("Inside saveMember of MemberService");
        member.setMemberId(service.getSequenceNumber(member.SEQUENCE_NAME));
        member.setCreatedOn(LocalDate.now());

        return memberRepository.save(member);
    }

    //Find Member for given Member Id
    public Member findMemberById(Integer memberId) {
        log.info("Inside findMemberById of MemberService");
        return memberRepository.findByMemberId(memberId);
    }
    
    //Get claim for given Member Id
    public ResponseTemplateWrapper getClaimByMemberId(Integer memberId) throws URISyntaxException {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateWrapper wrapper = new ResponseTemplateWrapper();
        Member member = memberRepository.findByMemberId(memberId);
        String url ="http://CLAIM-SERVICE/v1/claim/"+member.getMemberId();
        URI myURI = new URI(url);
        log.info("url---------"+url);

        Claim claim =restTemplate.getForObject(myURI,Claim.class);

        wrapper.setClaim(claim);
        wrapper.setMember(member);

        return  wrapper;
    }
}

package com.example.member.service;


import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SequenceGeneratorService service;

    public Member saveMember(Member member) {
        log.info("Inside saveMember of MemberService");
        member.setMemberId(service.getSequenceNumber(member.SEQUENCE_NAME));

        return memberRepository.save(member);
    }

    public Member findMemberById(Integer memberId) {
        log.info("Inside findMemberById of MemberService");
        return memberRepository.findByMemberId(memberId);
    }
}

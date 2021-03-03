package com.example.member.controller;


import com.example.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.member.entity.Member;
import com.example.member.service.MemberService;

@RestController
@RequestMapping("/members")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/create")
    public Member saveMember(@RequestBody Member member) {
        log.info("Inside saveMember method of MemberController");
        return  memberService.saveMember(member);
    }

    @GetMapping("/{id}")
    public Member findMemberById(@PathVariable("id") Integer memberId) {
        log.info("Inside findMemberById method of MemberController");
        return memberService.findMemberById(memberId);
    }

    @GetMapping("/")
    public Iterable<Member> findAllMember() {
        return memberRepository.findAll();
    }

}

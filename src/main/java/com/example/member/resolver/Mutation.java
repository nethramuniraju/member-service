package com.example.member.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;


@Component
public class Mutation implements GraphQLMutationResolver {
	private MemberRepository memberRepository;

	@Autowired
	public Mutation(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member createMember(String memberLOBCode, String  memberFullName) {
		Member member = new Member();
		memberRepository.save(member);

		return member;

	}

	
}

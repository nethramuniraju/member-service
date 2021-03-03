package com.example.member.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;

import java.util.List;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver {
	private MemberRepository memberRepository;

	@Autowired
	public Query(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
		
	}

	public Iterable<Member> findAllMember() {
		return memberRepository.findAll();
	}

	public Member findMemberById(Integer memberId) {
		log.info("Inside Query");
		Member member = memberRepository.findByMemberId(memberId);
		return member;
	}

	public List<Member> findMemberByType(String memberType) {
		return memberRepository.findByMemberType(memberType);
	}

}

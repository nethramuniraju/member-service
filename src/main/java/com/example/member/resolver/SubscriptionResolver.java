package com.example.member.resolver;


import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;


@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    MemberRepository memberRepository;

    public Publisher<List<Member>> findAllMemberSubscription() {

        return Flux.interval(Duration.ofSeconds(10))
                .map(num -> memberRepository.findAll());
    }
}

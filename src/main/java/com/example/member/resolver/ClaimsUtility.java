package com.example.member.resolver;

import com.example.member.entity.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Component
public class ClaimsUtility {

    private final String GET_URL = "http://localhost:8090/v1/claim/%s";
    private final String POST_URL = "http://localhost:8090/v1/claim";
    @Autowired
    private RestTemplate restTemplate;

    @Async
    @Retryable(value = {IOException.class, ResourceAccessException.class,RuntimeException.class},
            maxAttempts = 3, backoff = @Backoff(delay = 100))
    public CompletableFuture<Claim> findClaimsForMember(String memberId) throws InterruptedException {

        System.out.println("claim time : " + System.currentTimeMillis() + " on thread : " + Thread.currentThread().getId());
        String url = String.format(GET_URL, memberId);
        ResponseEntity<Claim> results = restTemplate.getForEntity(url, Claim.class);
        return CompletableFuture.completedFuture(results.getBody());
    }

    public void createClaim(Claim claim) {
        HttpEntity<Claim> request = new HttpEntity<>(claim);

        ResponseEntity<Claim> response = restTemplate
                .exchange(POST_URL, HttpMethod.POST, request, Claim.class);
        System.out.println(response.getBody());
    }
}

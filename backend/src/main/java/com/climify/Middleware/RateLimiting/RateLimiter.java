package com.climify.Middleware.RateLimiting;

import com.climify.Middleware.RateLimiting.Interfaces.IRateLimiter;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.time.Duration;

@Component
public class RateLimiter implements IRateLimiter {
    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();

    public Bucket getBucket(String user) {
        return buckets.computeIfAbsent(user, k -> Bucket
                .builder()
                .addLimit(Bandwidth.classic(5, Refill.intervally(5, Duration.ofSeconds(60))))
                .build());
    }
}

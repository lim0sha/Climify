package com.climify.Middleware.RateLimiting.Interfaces;

import io.github.bucket4j.Bucket;

public interface IRateLimiter {
    Bucket getBucket(String user);
}

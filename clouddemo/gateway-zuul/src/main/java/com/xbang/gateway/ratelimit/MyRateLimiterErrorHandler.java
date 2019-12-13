package com.xbang.gateway.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyRateLimiterErrorHandler implements RateLimiterErrorHandler {

    @Override
    public void handleSaveError(String key, Exception e) {
        log.info("key:{} e:{}",key,e.getMessage());
    }

    @Override
    public void handleFetchError(String key, Exception e) {
        log.info("key:{} e:{}",key,e.getMessage());
    }

    @Override
    public void handleError(String msg, Exception e) {
        log.info("msg:{} e:{}",msg,e.getMessage());
    }
}

package com.exmple.consumerdemo.service.face;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PROVIDER-DEMO")
public interface TestService {
    @GetMapping("/test/port")
    String test();
}

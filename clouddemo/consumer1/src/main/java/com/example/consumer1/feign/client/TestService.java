package com.example.consumer1.feign.client;

import com.example.commons.vo.result.BaseResult;
import com.example.consumer1.feign.fallback.TestServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER-DEMO",path = "test",fallbackFactory = TestServiceFallbackFactory.class)
public interface TestService {
    @RequestMapping("port")
    BaseResult<String> port(@RequestParam("sleep") long sleep);
}

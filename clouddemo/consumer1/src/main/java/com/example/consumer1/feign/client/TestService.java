package com.example.consumer1.feign.client;

import com.example.commons.vo.result.BaseResult;
import com.example.consumer1.feign.fallbackfactory.TestFeignClientFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER-DEMO",path = "test",/*fallback = TestServiceFallBack.class*/fallbackFactory = TestFeignClientFallBackFactory.class)
public interface TestService {
    @RequestMapping("port")
    BaseResult<String> port(@RequestParam("sleep") long sleep);
}

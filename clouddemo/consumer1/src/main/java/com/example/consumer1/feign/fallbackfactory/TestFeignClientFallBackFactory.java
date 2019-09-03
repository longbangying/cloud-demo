package com.example.consumer1.feign.fallbackfactory;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.ResultEnum;
import com.example.consumer1.feign.client.TestService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestFeignClientFallBackFactory implements FallbackFactory<TestService> {

    @Override
    public TestService create(Throwable throwable) {
        return new TestService() {
            @Override
            public BaseResult<String> port(long sleep) {
                log.error("进入FallBackFactory回退方法 {}:{}",sleep,throwable.getMessage());
                return BaseResult.getResult(ResultEnum.RESULT_SERVICE_UNAVAILABLE,null);
            }
        };
    }
}

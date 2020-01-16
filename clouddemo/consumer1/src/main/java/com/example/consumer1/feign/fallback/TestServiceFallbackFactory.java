package com.example.consumer1.feign.fallback;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.ResultEnum;
import com.example.consumer1.feign.client.TestService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class  TestServiceFallbackFactory implements FallbackFactory<TestService> {

    @Override
    public TestService create(Throwable throwable) {
        return new TestService(){
            @Override
            public BaseResult<String> port(long sleep) {
                log.error("sleep:{}",sleep);
                log.error("error:{}",throwable.getCause());
                return BaseResult.getResult(ResultEnum.RESULT_SERVICE_UNAVAILABLE,"");
            }
        };
    }
}


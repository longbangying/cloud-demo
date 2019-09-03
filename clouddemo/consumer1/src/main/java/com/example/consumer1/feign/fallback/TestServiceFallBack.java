package com.example.consumer1.feign.fallback;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.ResultEnum;
import com.example.consumer1.feign.client.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestServiceFallBack implements TestService {
    /**
     * feign 设置回退方法的方式
     * @param sleep
     * @return
     */
    @Override
    public BaseResult<String> port(long sleep) {
        log.info("feign 进入回退方法........{}",sleep);
        return BaseResult.getResult(ResultEnum.RESULT_SERVICE_UNAVAILABLE,null);
    }



}

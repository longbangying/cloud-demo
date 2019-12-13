package com.example.commons.vo.result;

public enum  ResultEnum {

    RESULT_SUCCESS("SUCCESS","操作成功"),
    RESULT_FAIL("FAIL","操作失败"),
    RESULT_EXCEPTION("EXCEPTION","系统异常"),

    RESULT_ACCESS_LIMIT("ACCESS_LIMIT","访问频率受限,请稍后再试"),
    RESULT_SERVICE_UNAVAILABLE("SERVICE_UNAVAILABLE","服务不可用"), //服务不可用
    ;

    private String resultCode;

    private String resultMsg;

    ResultEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }


    public String getResultMsg() {
        return resultMsg;
    }

}

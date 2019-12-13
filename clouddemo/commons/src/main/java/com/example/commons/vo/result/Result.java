package com.example.commons.vo.result;

public class Result {

    private String resultCode;

    private String resultMsg;

    public Result() {
        this.resultCode = ResultEnum.RESULT_EXCEPTION.getResultCode();
        this.resultMsg = ResultEnum.RESULT_EXCEPTION.getResultMsg();
    }

    public Result(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Result(ResultEnum resultEnum) {
        this(resultEnum.getResultCode(),resultEnum.getResultMsg());
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

package com.example.commons.vo.result;

public class Result {

    private String result_code;

    private String result_msg;

    public Result(String result_code, String result_msg) {
        this.result_code = result_code;
        this.result_msg = result_msg;
    }

    public Result(ResultEnum resultEnum) {
        this(resultEnum.getResult_code(),resultEnum.getResult_msg());
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }
}

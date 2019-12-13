package com.example.commons.vo.result;

public class BaseResult<T> extends Result{

    private T data;

    public BaseResult() {
       super();
       data = null;
    }

    public BaseResult(ResultEnum resultEnum, T data) {
        super(resultEnum);
        this.data = data;
    }

    public static <T> BaseResult<T> getResult(ResultEnum resultEnum,T data){
        return new BaseResult(resultEnum,data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

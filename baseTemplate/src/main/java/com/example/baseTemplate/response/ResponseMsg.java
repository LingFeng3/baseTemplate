package com.example.baseTemplate.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ResponseMsg<T> implements Serializable {

    private static final String DEFAULT = ResponseCode.SUCCESS;


    private String code;
    private String message;
    private T data;


    public ResponseMsg(String code) {
        this.code = code;
    }

    public ResponseMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseMsg<T> error(String message, T data) {
        ResponseMsg<T> responseMsg = new ResponseMsg<T>(DEFAULT, message);
        responseMsg.data = data;
        return responseMsg;
    }

    public static <T> ResponseMsg<T> success(T data) {
        ResponseMsg<T> responseMsg = new ResponseMsg<T>(DEFAULT, "成功");
        responseMsg.data = data;
        return responseMsg;
    }
}
package com.example.baseTemplate.exception;

import com.example.baseTemplate.response.ResponseCode;
import com.example.baseTemplate.response.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionHandler {

    private static final ResponseMsg<Boolean> EXCEPTION_FAILURE = new ResponseMsg<>(ResponseCode.FAILURE);

    /**
     * 拦截Exception异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseMsg<Boolean> exceptionHandler(Exception e) {

        ResponseMsg<Boolean> responseMsg = EXCEPTION_FAILURE;
        // 添加错误信息resMsg
        responseMsg.setMessage(responseMsg.getCode());

        log.info(responseMsg.getMessage());
        log.error("Exception：\ncode={}\nmessage={}", responseMsg.getCode(), e.getMessage(), e);

        return responseMsg;
    }

    /**
     * 处理参数校验异常（如 @NotNull、@NotBlank 等）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMsg<Boolean> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String defaultMessage = error.getDefaultMessage();
            if (defaultMessage != null) {
                errorMessage.append(defaultMessage).append("; ");
            }
        });

        log.error("参数校验失败: {}", errorMessage);

        ResponseMsg<Boolean> responseMsg = new ResponseMsg<>(ResponseCode.FAILURE);
        responseMsg.setMessage(errorMessage.toString());
        return responseMsg;
    }

    /**
     * 拦截自定义RuntimeApiException异常
     */
    @ExceptionHandler(RuntimeApiException.class)
    public ResponseMsg<Boolean> exceptionHandler(RuntimeApiException e) {
        String code = e.getCode();
        // 获取错误信息resMsg
        String msg = e.getMessage();

        log.error("RuntimeAppException：\ncode={}\nmessage={}", code, msg);
        ResponseMsg<Boolean> responseMsg = new ResponseMsg<>(code);
        // 添加错误信息
        responseMsg.setMessage(msg);

        return responseMsg;
    }

}
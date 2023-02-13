package personal.bobi.chatgpt.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import personal.bobi.chatgpt.entity.Result;
import personal.bobi.chatgpt.util.ResultUtil;

@RestControllerAdvice
public class ExceptionHandlerProcessor {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(Exception e){
        return ResultUtil.error(400408, e.getMessage());
    }

}

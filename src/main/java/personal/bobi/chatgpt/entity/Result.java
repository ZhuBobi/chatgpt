package personal.bobi.chatgpt.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {

    private final String code;

    private final String message;

    private final T data;

    public Result(){
        this("000000","success",null);
    }
    public Result(String code){
        this(code,"success",null);
    }

    public Result(T data){
        this("000000","success",data);
    }

    public Result(String code, String message){
        this(code,message,null);
    }

    public Result(String code, String message, T data){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}

package personal.bobi.chatgpt;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatGPTApplication {

    public static void main(String[] args){
        if (ArrayUtil.isEmpty(args) || StrUtil.isEmpty(args[0])) {
            throw new RuntimeException("请增加chatGPT的api-key");
        }
        System.setProperty("api_key", args[0]);
        if (args.length > 1) {
            System.setProperty("password", args[1]);
        }
        SpringApplication.run(ChatGPTApplication.class, args);
    }

}

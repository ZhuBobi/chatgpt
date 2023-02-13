package personal.bobi.chatgpt.service;

import org.springframework.stereotype.Service;
import personal.bobi.chatgpt.entity.ChatGPTChoiceDto;
import personal.bobi.chatgpt.entity.ChatGPTImageDataDto;
import personal.bobi.chatgpt.entity.ChatGPTImageResponse;
import personal.bobi.chatgpt.entity.ChatGPTTalkResponse;
import personal.bobi.chatgpt.util.ChatGptHeaderUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    public String example(){
        return "1、与ChatGPT进行对话接口：url:port/chatgpt/talk?q=你的问题&t=0.3" +
                "<br>" +
                "----参数说明:p(String):是你的问题" +
                "<br>" +
                "--------------t(float):是chatGPT的感性程度或创造程度，[0.0, 1.0]" +
                "<br>" +
                "<br>" +
                "2、让ChatGPT根据你给出的关键字作图，url:port/chatgpt/draw?q=你的问题&n=2&s=M" +
                "<br>" +
                "----参数说明:p(String):是你的描述" +
                "<br>" +
                "--------------n(int):是作图数量，[1, 10]" +
                "<br>" +
                "--------------s(String):是图片大小，值为[S,M,L] 对应大小是：[256x256,512x512,1024x1024]" +
                "<br>" +
                "<br>" +
                "<br>" +
                "<br>" + "**PS**：如果在启动时设置了密码，在每次请求后面追加p=xxx,例如：url:port/chatgpt/talk?q=你的问题&t=0.3&p=你的密码"
                ;
    }


    public String talkTo(String txt, Float temperature){
        ChatGPTTalkResponse response = ChatGptHeaderUtil.talkToGPT(txt, temperature);
        StringBuilder stringBuilder = new StringBuilder();
        response.getChoices().forEach(s -> {
            String text = s.getText();
            text = text.replaceAll("\\[", "");
            text = text.replaceAll("]", "");
            text = text.replaceAll("\n\n", "<br>");
            stringBuilder.append(text)
                    .append("\r\n");});
        return stringBuilder.toString();
    }


    public List<String> drawImage(String txt, int count, String size){
        ChatGPTImageResponse response = ChatGptHeaderUtil.drawImage(txt, count, size);
        return response.getData().stream().map(s -> s.getUrl().replaceAll("\\\\n", "<br>")).collect(Collectors.toList());
    }
}

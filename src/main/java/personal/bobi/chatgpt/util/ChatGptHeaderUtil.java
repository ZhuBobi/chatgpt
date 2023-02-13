package personal.bobi.chatgpt.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import personal.bobi.chatgpt.entity.ChatGPTImageResponse;
import personal.bobi.chatgpt.entity.ChatGPTTalkResponse;
import personal.bobi.chatgpt.enums.ChatGPTImageSizeEnum;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ChatGptHeaderUtil {

    private static final String DIALOG_URL = "https://api.openai.com/v1/completions";
    private static final String IMAGE_URL = "https://api.openai.com/v1/images/generations";

    private static final String API_KEY = "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";

    private static Map<String, String> getChatGptHeader(){
        Map<String, String> headers = new HashMap<>(2);
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + System.getProperty("api_key"));
        return headers;
    }

    public static ChatGPTTalkResponse talkToGPT(String txt, Float temperature){
        String requestBody = "{\n" +
                "  \"model\": \"text-davinci-003\",\n" +
                "  \"prompt\": \"" + txt + "\",\n" +
                "  \"max_tokens\": 1000,\n" +
                "  \"temperature\": " + temperature + "\n" +
                "}";
        Map<String, String> headers = getChatGptHeader();
        HttpRequest post = HttpUtil.createPost(DIALOG_URL);
        post.addHeaders(headers);
        try (HttpResponse execute = post.body(requestBody).execute()) {
            String body = execute.body();
            log.info("与chatGPT对话，对话入参：【{}】，响应：【{}】", requestBody, body);
            return JSONUtil.toBean(body, ChatGPTTalkResponse.class);
        }
    }

    public static ChatGPTImageResponse drawImage(String desc, int count, String size){
        checkCount(count);

        ChatGPTImageSizeEnum imageSize = ChatGPTImageSizeEnum.getImageSize(size);
        String requestBody = "{\n" +
                "  \"prompt\": \"" + desc + "\",\n" +
                "  \"n\": " + count + ",\n" +
                "  \"size\": \"" + imageSize.getSize() + "\"\n" +
                "}";
        Map<String, String> headers = getChatGptHeader();
        HttpRequest post = HttpUtil.createPost(IMAGE_URL);
        post.addHeaders(headers);
        try (HttpResponse execute = post.body(requestBody).execute()) {
            String body = execute.body();
            log.info("请chatGPT作图，作图入参：【{}】，响应：【{}】", requestBody, body);
            return JSONUtil.toBean(body, ChatGPTImageResponse.class);
        }
    }

    private static void checkCount(int count){
        if (count < 1 || count > 10) {
            throw new RuntimeException("数量数值出错,请保持在[1,10]之间");
        }
    }


    public static void main(String[] args){
        String sre = "\\n\\n1. 具备良好的语言表达能力：主播要具备良好的语言表达能力，能够清晰、流畅地表达自己的想法，把自己的思想和情感传达给观众。\\n\\n2. 具备良好的表演能力：主播要具备良好的表演能力，能够与观众互动，把节目演绎得生动有趣，吸引观众的兴趣。\\n\\n3. 具备良好的社交能力：主播要具备良好的社交能力，能够与观众建立良好的关系，把节目演绎得更加有趣，吸引更多的观众。\\n\\n4. 具备良好的监督能力：主播要具备良好的监督能力，能够把控节目的进度，把握节目的节奏，使节目更加精彩。\\n\\n5. 具备良好的创新能力：主播要具备良好的创新能力，能够不断推出新的节目，丰富节目内容，吸引更多的观众。";
        System.out.println(sre.replaceAll("\\\\n", "<br>"));
    }
}

package personal.bobi.chatgpt.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChatGPTImageResponse {

    private Long created;

    private List<ChatGPTImageDataDto> data;
}

package personal.bobi.chatgpt.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChatGPTTalkResponse {

    private String id;

    private String object;

    private Long created;

    private String model;

    private List<ChatGPTChoiceDto> choices;

    private ChatGPTUsageDto usage;
}

package personal.bobi.chatgpt.entity;

import lombok.Data;

@Data
public class ChatGPTChoiceDto {

    private Integer index;

    private Integer logprobs;

    private String finish_reason;

    private String text;

}

package personal.bobi.chatgpt.enums;

import java.util.Arrays;

public enum ChatGPTImageSizeEnum {
    S_256("S","256x256"),
    S_512("M","512x512"),
    S_1024("L","1024x1024"),;


    private final String code;
    private final String size;


    private ChatGPTImageSizeEnum(String code, String size){
        this.code = code;
        this.size = size;
    }

    public String getCode(){
        return code;
    }

    public String getSize(){
        return size;
    }

    public static ChatGPTImageSizeEnum getImageSize(String co){
        return Arrays.stream(values()).filter(s->s.code.equals(co)).findAny().orElse(ChatGPTImageSizeEnum.S_256);
    }

}

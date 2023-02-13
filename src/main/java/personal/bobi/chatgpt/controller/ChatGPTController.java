package personal.bobi.chatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.bobi.chatgpt.entity.Result;
import personal.bobi.chatgpt.service.ChatGptService;
import personal.bobi.chatgpt.util.ResultUtil;

import java.util.List;

@RestController
@RequestMapping("/chatgpt")
public class ChatGPTController {

    @Autowired
    ChatGptService chatGptService;

    @GetMapping(value = "/example", produces = "text/html;charset=utf-8")
    public String example(){
        return chatGptService.example();
    }

    @GetMapping(value = "/talk", produces = "text/html;charset=utf-8")
    public String talk(String q, Float t){
        return chatGptService.talkTo(q, t);
    }

    @GetMapping("/draw")
    public List<String> draw(String q, int c, String s){
        return chatGptService.drawImage(q, c, s);
    }
}

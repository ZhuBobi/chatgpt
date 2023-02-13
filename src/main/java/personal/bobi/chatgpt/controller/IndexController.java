package personal.bobi.chatgpt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public void index(HttpServletResponse response){
        try {
            response.sendRedirect("/chatgpt/example");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

package personal.bobi.chatgpt.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class RequestHandlerAdapter extends WebMvcConfigurationSupport {


    @Override
    public void addInterceptors(InterceptorRegistry interceptor){
        interceptor.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }
}

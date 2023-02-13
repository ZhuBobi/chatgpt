package personal.bobi.chatgpt.handler;

import cn.hutool.core.net.URLDecoder;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Component
public class RequestInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if (!request.getRequestURI().startsWith("/chatgpt")) {
            return true;
        }
        if(request.getRequestURI().startsWith("/chatgpt/example")){
            return true;
        }
        String password1 = System.getProperty("password");
        if (StrUtil.isEmpty(password1)) {
            return true;
        }
        String queryString = request.getQueryString();
        queryString = URLDecoder.decode(queryString, StandardCharsets.UTF_8);
        String[] splits = queryString.split("&");

        for (String split : splits) {
            if (split.startsWith("p")) {
                String[] password = split.split("=");
                return password1.equals(password[1]);
            }
        }
        throw new Exception("密码确实或错误！");
    }
}

package wangy.mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setCharacterEncoding("utf-8");
        if (request.getSession().getAttribute("user")!=null) {
            return true;
        }else {
            String url = "/login";
            response.sendRedirect(url);
            return false;
        }
    }


}

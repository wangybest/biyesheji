package wangy.mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import wangy.mall.utils.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setCharacterEncoding("utf-8");
        if (request.getSession().getAttribute("admin")!=null) {
            return true;
        }else {
            String url = "/houtai";
            response.sendRedirect(url);
            return false;
        }

    }
}

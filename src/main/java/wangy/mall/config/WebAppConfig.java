package wangy.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wangy.mall.interceptor.AdminInterceptor;
import wangy.mall.interceptor.UserInterceptor;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin_category_list","/admin_order_list","/admin_product_list","/admin_user_list");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/userinfo", "/bought", "/cart");
    }
}

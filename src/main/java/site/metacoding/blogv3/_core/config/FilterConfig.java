package site.metacoding.blogv3._core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import site.metacoding.blogv3._core.filter.TrashFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<TrashFilter> trashFilter() {
        FilterRegistrationBean<TrashFilter> bean = new FilterRegistrationBean<>(new TrashFilter());
        bean.addUrlPatterns("/reply/*");
        bean.setOrder(0); // 낮은 번호부터 실행됨.Ø
        return bean;
    }

}

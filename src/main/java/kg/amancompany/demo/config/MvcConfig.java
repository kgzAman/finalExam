package kg.amancompany.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("photo/")
    private String pathToPhotoThemePhotos;

    @Value("users/")
    private String pathToUsersPhotos;

    @Value("news/")
    private String pathToNewsPhotos;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:upload/photo/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/img/logo/**")
                .addResourceLocations("file:src/main/resources/static/img/");
    }
}

package by.bsuir.coursework.appconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("C:\\Univer\\FKP\\6sem\\RIS\\coursework\\src\\main\\resources\\css")
    private String uploadCss;
    @Value("C:\\Univer\\FKP\\6sem\\RIS\\coursework\\src\\main\\resources\\js")
    private String uploadJs;
    @Value("C:\\Univer\\FKP\\6sem\\RIS\\coursework\\src\\main\\resources\\img")
    private String uploadImg;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("file:" + uploadCss + "/");
        registry.addResourceHandler("/js/**").addResourceLocations("file:" + uploadJs + "/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + uploadImg + "/");
    }
}
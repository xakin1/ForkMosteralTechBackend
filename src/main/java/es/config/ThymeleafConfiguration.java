package es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafConfiguration {

  @Bean
  @Description("Thymeleaf template resolver serving HTML 5 emails")
  public ClassLoaderTemplateResolver emailTemplateResolver() {
    ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
    emailTemplateResolver.setPrefix("mails/");
    emailTemplateResolver.setSuffix(".html");
    emailTemplateResolver.setTemplateMode("HTML");
    emailTemplateResolver.setCharacterEncoding("UTF-8");
    emailTemplateResolver.setOrder(1);
    emailTemplateResolver.setCheckExistence(true);
    return emailTemplateResolver;
  }
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

import java.util.Collections;
import java.util.Set;

@SpringBootApplication
public class SpringBootNgCliApplication {

  @Bean
  @Profile("ng-serve")
  public ITemplateResolver devServerViewResolver() {
    UrlTemplateResolver resolver = new UrlTemplateResolver() {
      @Override
      protected String computeResourceName(TemplateProcessingParameters templateProcessingParameters) {
        return "http://localhost:4200/";
      }
    };
    Set<String> patterns = Collections.singleton("angular-app-index");
    resolver.setResolvablePatterns(patterns);
    resolver.setNonCacheablePatterns(patterns);
    return resolver;
  }

  @Controller
  static class AppController {
    @GetMapping("/**/{:[^\\.]*}")
    public String clientRoute() {
      return "forward:/";
    }

    @GetMapping("/")
    public String index(Model model) {
      model.addAttribute("message", "Greetings from Spring!");
      return "index";
    }
  }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNgCliApplication.class, args);
	}
}

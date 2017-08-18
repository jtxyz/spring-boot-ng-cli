package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringBootNgCliApplication {

  @Controller
  static class AppController {
    @GetMapping("/")
    public String index(Model model) {
      return "index";
    }
  }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNgCliApplication.class, args);
	}
}

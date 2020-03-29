package com.zlzc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zlzc.common.utils.Result;

@SpringBootApplication
@RestController
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@GetMapping("/hello/{name}")
	public Result helloworld(@PathVariable(name = "name") String name) {
		System.out.println("========> test" + name);
		return Result.ok(name);
	}
}

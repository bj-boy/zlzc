package com.zlzc.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfigAdapter implements WebMvcConfigurer {

	/**
	 * spring.http.encoding.force = true
	 * yaml文件中添加上面配置解决中文乱码
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String os = System.getProperty("os.name");
		//@formatter:off
		if (os.toLowerCase().startsWith("win")) { // 如果是Windows系统
			registry
			.addResourceHandler("/zlzc_file/**")
			.addResourceLocations("file:F:/zlzc-up/");
		} else {// linux和mac系统
			registry
			.addResourceHandler("/zlzc_file/**")
			.addResourceLocations("file:/uploadBaseDir/productPic/");
		}
		//@formatter:on

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}

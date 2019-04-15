package com.graduate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.graduate.filter.CustomDefineInteceptor;

/**
 * 
 * @Discription:   
 * @Author: JiangChunLin  
 * @ClassName: CustomDefineMvcConfig  
 * @Date: 2019年3月12日 下午4:30:52  
 * @Version: 1.0.0 Graduate
 */
@Configuration
public class CustomDefineMvcConfig implements WebMvcConfigurer{
	/**
	 * 
	 *  @Description: 注册拦截器
	 *  @Author: JiangChunLin
	 *  @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomDefineInteceptor())
									.addPathPatterns("/*")
									.excludePathPatterns("/")
									.excludePathPatterns("/login");
		WebMvcConfigurer.super.addInterceptors(registry);
		
	}
	

}

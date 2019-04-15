package com.graduate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Discription: 程序启动类
 * @Author: JiangChunLin  
 * @ClassName: GraduateAppApplication  
 * @Date: 2019年4月15日 下午8:58:07  
 * @Version: 1.0.0 Graduate
 */
@SpringBootApplication
public class GraduateAppApplication {
	private static Logger logger=LoggerFactory.getLogger(GraduateAppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GraduateAppApplication.class, args);
		logger.info("Application Start Is Successful...");
	}
	
}


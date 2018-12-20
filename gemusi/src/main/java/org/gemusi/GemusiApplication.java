package org.gemusi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.gemusi.**.dao")
public class GemusiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemusiApplication.class, args);
	}
}

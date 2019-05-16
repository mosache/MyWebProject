package com.yd.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yd.web.mappers")
public class MybatisConfig {
}

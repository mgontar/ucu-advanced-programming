package com.transport.config;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.transport.constants.AppRunProfile;

@Profile(AppRunProfile.DEV)
@Configuration
public class DevConfig {

    @Bean
    public SparkConf sparkConf(){
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("transport");
        sparkConf.setMaster("local[*]");
        return sparkConf;
    }
}

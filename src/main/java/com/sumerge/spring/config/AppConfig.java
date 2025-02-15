package com.sumerge.spring.config;

import com.sumerge.spring.CourseRecommender;
import com.sumerge.spring.CourseRecommenderImpl1;
import com.sumerge.spring.CourseRecommenderImpl2;
import com.sumerge.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    //@Primary
    public CourseRecommender courseRecommenderImpl1() {
        return new CourseRecommenderImpl1();
    }

    @Bean
    @Primary
    public CourseRecommender courseRecommenderImpl2() {
        return new CourseRecommenderImpl2();
    }

    @Bean
    public CourseService courseService(CourseRecommender courseRecommender) {
        return new CourseService(courseRecommender);
    }

    // By Variable Name --> Uncomment when used --> courseRecommenderImpl1
//    @Bean
//    public CourseService courseService( CourseRecommender courseRecommenderImpl2) {
//        return new CourseService(courseRecommenderImpl2);
//    }
}
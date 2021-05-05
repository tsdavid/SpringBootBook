package com.dk.springboot.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Annotation - SpringBootApplication
 * : 스프링 부트의 자동 설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정.
 *   해당 annotation 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}

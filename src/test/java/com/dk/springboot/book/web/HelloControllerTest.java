package com.dk.springboot.book.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 1 RunWith(SpringRunner.class)
 * - 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다.
 * - SpringRunner 실행자를 선택함으로서, Spring-Boot Test와 JUnit사이에 연결자 역할 수행
 *
 * 2 : WebMvcTest(controllers = HelloController.class)
 * - 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션 이다.
 * - 선언시 @Controller, @ControllerAdvice등 사용가능
 * - 단, @Service, @Component, @Repository 등 사용 불가
 * - 여기서는 컨트롤러만 사용하기 때문에 선언
 */
@RunWith(SpringRunner.class)    // 1
@WebMvcTest(controllers = HelloController.class)    // 2
public class HelloControllerTest {

    /**
     * 3 : Autowired
     *  - 스프링이 관리하는 빈(bean)을 주입 받는다.
     *
     *  4 : private MockMvc mvc
     *   - 웹 API를 테스트 할 때 사용,  스프링 MVVC 테스트의 시작점,
     *  - 해당 클래스를 통해 HTTP Het, POST등에 대한 API 테스트 가능.
     */
    @Autowired  // 3
    private MockMvc mvc;    // 4

    @Test
    public void hello_will_be_returned() throws Exception {

        String hello = "hello";

        /**
         * 5 : mvc.perfom(get())
         * - MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
         * - 체이닝이 지원되어 6번 7번과 같이 다양한 검증 기능 선언
         * 
         * 6 : .andExpect(status().isOk())
         * - mvc.perform의 결과를 검증,  HTTP Header의 Status를 검증
         * - HTTP status가 200 == Ok
         * 
         * 7 : .andExpect(content).string(hello))
         * - mvc.perform의 결과 검증,  응답 본문의 내용 검증
         * - Controller에서 "hello"를 리턴하기 떄문에 이 값이 맞는지 검증
         */
        mvc.perform(get("/hello"))   // 5
                .andExpect(status().isOk()) // 6
                .andExpect(content().string(hello)); // 7

    }


}

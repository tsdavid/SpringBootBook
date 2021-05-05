package com.dk.springboot.book.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_fun_test() {

        //given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        /**
         * 1 : assertThat
         * - assertj 라는 테스트 검증 라이브러리의 검증 메소드
         * - 검증하고 싶은 대상을 메소드 인자로 받는다.
         * - 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용가능
         *
         * 2 : isEqualTo
         * - assertj의 동등 비교 메소드, 값을 비교해 같으면 true
         */
        // then
        assertThat(dto.getName()).isEqualTo(name);  // 1 ,2
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}

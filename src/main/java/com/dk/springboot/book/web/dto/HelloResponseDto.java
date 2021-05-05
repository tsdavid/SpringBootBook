package com.dk.springboot.book.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * lombok
 * 1 : @Getter
 * - 선언된 모든 field의 get 메소드를 생성
 * 
 * 2 : RequiredArgsConstructor
 *  - 선언된 모든 final 필드가 포함된 생성자를 생성
 *  - 단, final 이 없는 필드는 생성장에 포함 불가
 */

@Getter // 1
@RequiredArgsConstructor // 2
public class HelloResponseDto {

    private final String name;

    private final int amount;


}

package com.dk.springboot.book.web.dto.items;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsUpdateRequestDto {

    private String product_title;
    private String contributor;
    private String content;
    private String price;

    @Builder
    public ItemsUpdateRequestDto(String product_title, String contributor, String content, String price) {
        this.product_title = product_title;
        this.contributor = contributor;
        this.content = content;
        this.price = price;
    }
}

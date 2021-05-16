package com.dk.springboot.book.web.dto.items;

import com.dk.springboot.book.domain.items.Items;
import lombok.Getter;

@Getter
public class ItemsResponseDto {

    private Long id;
    private String product_title;
    private String bar_code;
    private String contributor;
    private String content;
    private String price;

    public ItemsResponseDto(Items entity) {

        this.id = entity.getId();
        this.product_title = entity.getProduct_title();
        this.bar_code = entity.getBar_code();
        this.contributor = entity.getContributor();
        this.content = entity.getContent();
        this.price = entity.getPrice();

    }
}


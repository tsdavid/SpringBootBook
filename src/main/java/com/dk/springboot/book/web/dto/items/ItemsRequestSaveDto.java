package com.dk.springboot.book.web.dto.items;

import com.dk.springboot.book.domain.items.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsRequestSaveDto {

    private String product_title;
    private String bar_code;
    private String contributor;
    private String content;
    private String price;

    @Builder
    public ItemsRequestSaveDto(String product_title, String bar_code, String contributor, String content, String price) {

        this.product_title = product_title;
        this.bar_code = bar_code;
        this.contributor = contributor;
        this.content = content;
        this.price = price;
    }

    public Items toEntity() {

        return Items.builder()
                .product_title(product_title)
                .bar_code(bar_code)
                .contributor(contributor)
                .content(content)
                .price(price)
                .build();
    }

    @Override
    public String toString() {
        return "ItemsRequestSaveDto{" +
                "product_title='" + product_title + '\'' +
                ", bar_code='" + bar_code + '\'' +
                ", contributor='" + contributor + '\'' +
                ", content='" + content + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

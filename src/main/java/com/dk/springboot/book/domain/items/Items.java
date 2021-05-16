package com.dk.springboot.book.domain.items;


import com.dk.springboot.book.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String product_title;

    @Column(nullable = false)
    private String bar_code;

    @Column(nullable = false)
    private String contributor;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String price;

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", product_title='" + product_title + '\'' +
                ", bar_code='" + bar_code + '\'' +
                ", contributor='" + contributor + '\'' +
                ", content='" + content + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Builder
    public Items(String product_title, String bar_code, String contributor, String content, String price) {

        this.product_title = product_title;
        this.bar_code = bar_code;
        this.contributor = contributor;
        this.content = content;
        this.price = price;
    }

    public void update(String product_title, String contributor, String content, String price) {
        this.product_title = product_title;
        this.contributor = contributor;
        this.content = content;
        this.price = price;
    }
}

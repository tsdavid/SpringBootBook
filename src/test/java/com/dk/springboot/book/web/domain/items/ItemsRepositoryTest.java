package com.dk.springboot.book.web.domain.items;

import com.dk.springboot.book.domain.items.Items;
import com.dk.springboot.book.domain.items.ItemsRepository;
import com.dk.springboot.book.domain.posts.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemsRepositoryTest {

    @Autowired
    ItemsRepository itemsRepository;


    @After
    public void cleanup() {
//        this.itemsRepository.deleteAll();

        List<Items> list = this.itemsRepository.findAll();
        for(int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }



    @Test
    public void InsertItems() {
        String title = "sample";
        String barcode = "EM189521";
        String contributor = "a_contributor";
        String content = "content";
        String price = "19000";


        this.itemsRepository.save(Items.builder()
                .product_title(title)
                .bar_code(barcode)
                .contributor(contributor)
                .content(content)
                .price(price)
                .build()
        );
        List<Items> itemsList = this.itemsRepository.findAll();

        Items items = itemsList.get(0);
        assertThat(items.getProduct_title()).isEqualTo(title);
    }

    @Test
    public void BaseTimeEntity_Register() {

        String title = "sample";
        String barcode = "EM189521";
        String contributor = "a_contributor";
        String content = "content";
        String price = "19000";

        // given
        LocalDateTime now = LocalDateTime.of(2021,5,7,6,32,0);
        itemsRepository.save(Items.builder()
                .product_title(title)
                .bar_code(barcode)
                .contributor(contributor)
                .content(content)
                .price(price)
                .build()
        );

        // when
        List<Items> postsList = itemsRepository.findAll();

        // then
        Items posts = postsList.get(0);

//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" +
//                "createDate = " + posts.getCreatedDate() + " , modifiedDate=" + posts.getModifiedDate());
//
//
//        assertThat(posts.getCreatedDate()).isAfter(now);
//        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}

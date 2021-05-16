package com.dk.springboot.book.web;

import com.dk.springboot.book.domain.items.Items;
import com.dk.springboot.book.domain.items.ItemsRepository;
import com.dk.springboot.book.domain.posts.Posts;
import com.dk.springboot.book.web.dto.items.ItemsRequestSaveDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void tearDonw() throws Exception {

//        itemsRepository.deleteAll();
    }

    @Test
    public void Post_Items() throws Exception {

        // given
        String title = "sample";
        String barcode = "EM189521";
        String contributor = "a_contributor";
        String content = "content";
        String price = "19000";


        ItemsRequestSaveDto requestSaveDto = ItemsRequestSaveDto.builder()
                .product_title(title)
                .bar_code(barcode)
                .contributor(contributor)
                .content(content)
                .price(price).build();
        String url = "http://localhost:" + port + "/api/v1/items";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestSaveDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Items> all = itemsRepository.findAll();
        assertThat(all.get(0).getProduct_title()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        System.out.println(all.get(0).toString());

    }
}

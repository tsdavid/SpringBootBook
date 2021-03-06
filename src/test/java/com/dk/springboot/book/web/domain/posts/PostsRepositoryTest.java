package com.dk.springboot.book.web.domain.posts;

import com.dk.springboot.book.domain.posts.Posts;
import com.dk.springboot.book.domain.posts.PostsRepository;
import javafx.geometry.Pos;
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
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // 1
    public void cleanup() {

//        postsRepository.deleteAll();
    }

    @Test
    public void ReadPosts() {

        // given
        String title = "Test-Post";
        String content = "Test-Content";

        postsRepository.save(Posts.builder()  // 2
                .title(title)
                .content(content)
                .author("david@gmail.com")
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();  // 2

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }


    @Test
    public void BaseTimeEntity_Register() {

        // given
        LocalDateTime now = LocalDateTime.of(2021,5,7,6,32,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" +
                "createDate = " + posts.getCreatedDate() + " , modifiedDate=" + posts.getModifiedDate());


        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}


/**
 * 1 : After
 *  - Junit?????? ?????? ???????????? ?????? ????????? ???????????? ???????????? ??????
 *  - ????????? ????????? ?????? ???????????? ???????????? ???????????? ????????? ????????? ???????????? ??????
 *  - ?????? ???????????? ????????? ???????????? ???????????? db??? h2??? ???????????? ????????? ???????????? ?????? ??????
 *
 *  2 : postsRepository.save
 *  - ????????? posts??? insert/update ????????? ???????????????.
 *  - id ?????? ?????????, update, ????????? insert ????????? ??????
 *
 *  3 : postsRepository.findAll
 *  - ????????? posts??? ?????? ?????? ???????????? ??????????????? ????????? ?????????.
 */
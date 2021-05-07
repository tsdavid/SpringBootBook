package com.dk.springboot.book.web.domain.posts;

import com.dk.springboot.book.domain.posts.Posts;
import com.dk.springboot.book.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // 1
    public void cleanup() {
        postsRepository.deleteAll();
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
}
/**
 * 1 : After
 *  - Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
 *  - 보통은 배포전 전체 테스트를 수행할때 테스트간 데이터 침범을 막기위해 사용
 *  - 여러 테스트가 동시에 수행되면 테스트용 db인 h2에 데이터가 그대로 남아있어 실패 가능
 *
 *  2 : postsRepository.save
 *  - 테이블 posts에 insert/update 쿼리를 실행합니다.
 *  - id 값이 있다면, update, 없다면 insert 쿼리가 실행
 *
 *  3 : postsRepository.findAll
 *  - 테이블 posts에 있는 모든 데이터를 조회해오는 메소드 입니다.
 */
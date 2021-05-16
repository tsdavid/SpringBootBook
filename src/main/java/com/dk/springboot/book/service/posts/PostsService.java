package com.dk.springboot.book.service.posts;

import com.dk.springboot.book.domain.posts.Posts;
import com.dk.springboot.book.domain.posts.PostsRepository;
import com.dk.springboot.book.web.dto.posts.PostsListResponseDto;
import com.dk.springboot.book.web.dto.posts.PostsResponseDto;
import com.dk.springboot.book.web.dto.posts.PostsSaveRequestDto;
import com.dk.springboot.book.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return this.postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
        /**
         * postsRepository.delete
         * - JpaRepository에서 이미 delete 메소드를 지원
         * - deleteById 메소드를 이용하면 id로 삭제 가능
         */
    }


    /**
     * readOnly
     *  - 트랜잭션 범위는 유지, 조회 기능만 남겨ㅑ둬 조회 속도 개선
     *  - 등록, 수정, 삭제 기능이 저녛 없는 서비스 메소드에서 사용
     */


    @Transactional
    public List<PostsListResponseDto> findAllDesc() {

        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) // ==> .map(posts -> new PostsListResponseDt(posts))
                .collect(Collectors.toList());
    }

    public PostsResponseDto findById(Long id) {

        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );

        return new PostsResponseDto(entity);
    }
}

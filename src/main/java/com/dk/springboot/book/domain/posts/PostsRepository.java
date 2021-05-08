package com.dk.springboot.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  // 1
    List<Posts> findAllDesc();
}

/**
 * 1 : Query
 * - SpringDataJpa에서 제공하지 않는 메소드는 Query문으로 대체 가능
 * - 가독성이 좋아 선택해서 사용 가능
 * 
 */

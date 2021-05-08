package com.dk.springboot.book.web;


import com.dk.springboot.book.service.posts.PostsService;
import com.dk.springboot.book.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;


    @GetMapping("/")
    public String index(Model model) {  // 1
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";

//    @GetMapping("/")
//    public String index() {
//        return "index";
        /**
         * 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때,
         * 앞의 경로와
         * 뒤의 파일 확장자는 자동으로 지정된다.
         *
         * 앞의 경로 : src/main/resources/templates
         * 뒤의 파일 확장자 :  .mustache
         *
         * 즉 여기선 "index"을 반환하므로
         *
         * src/main/resources/templates/index.mustache로 전환되어
         * View-Resolver 가 처리
         */

    }


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,
                              Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

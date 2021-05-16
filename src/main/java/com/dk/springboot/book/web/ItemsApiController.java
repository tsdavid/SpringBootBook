package com.dk.springboot.book.web;

import com.dk.springboot.book.service.posts.ItemsService;
import com.dk.springboot.book.web.dto.items.ItemsRequestSaveDto;
import com.dk.springboot.book.web.dto.items.ItemsResponseDto;
import com.dk.springboot.book.web.dto.items.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @PostMapping("/api/v1/items")
    public Long save(@RequestBody ItemsRequestSaveDto itemsRequestSaveDto) {

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   PostsApiController Items_save   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(itemsRequestSaveDto.toString());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<===>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


        return itemsService.save(itemsRequestSaveDto);
    }

    @PutMapping("/api/v1/items/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody ItemsUpdateRequestDto requestDto) {
        return itemsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/items/{id}")
    public ItemsResponseDto findById(@PathVariable Long id){
        return itemsService.findById(id);
    }

}

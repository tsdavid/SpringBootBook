package com.dk.springboot.book.service.posts;

import com.dk.springboot.book.domain.items.Items;
import com.dk.springboot.book.domain.items.ItemsRepository;
import com.dk.springboot.book.web.dto.items.ItemsRequestSaveDto;
import com.dk.springboot.book.web.dto.items.ItemsResponseDto;
import com.dk.springboot.book.web.dto.items.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Transactional
    public Long save(ItemsRequestSaveDto itemsRequestSaveDto) {

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   ItemsService save   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(itemsRequestSaveDto.toString());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<===>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return this.itemsRepository.save(itemsRequestSaveDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ItemsUpdateRequestDto requestDto) {
        Items items = itemsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );
        items.update(requestDto.getProduct_title(), requestDto.getContributor(),
                    requestDto.getContent(), requestDto.getPrice());

        return id;
    }

    public ItemsResponseDto findById (Long id) {

        Items entity = itemsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No Text. id = " + id)
        );
        return new ItemsResponseDto(entity);
    }
}

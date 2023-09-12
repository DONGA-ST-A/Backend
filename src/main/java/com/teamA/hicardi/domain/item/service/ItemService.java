package com.teamA.hicardi.domain.item.service;

import com.teamA.hicardi.domain.item.dto.response.ItemGetAllResponseDto;
import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Page<ItemGetAllResponseDto> getAllItems(Pageable pageable) {
        Page<Item> items = itemRepository.findAll(pageable);
        Page<ItemGetAllResponseDto> response = items.map(i -> ItemGetAllResponseDto.from(i));
        return response;
    }
}

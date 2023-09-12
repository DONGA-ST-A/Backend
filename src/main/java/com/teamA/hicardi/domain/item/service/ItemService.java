package com.teamA.hicardi.domain.item.service;

import java.util.List;

import com.teamA.hicardi.domain.item.dto.response.ItemGetAllResponseDto;
import com.teamA.hicardi.domain.item.dto.response.ItemGetResponseDto;
import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.entity.ItemImage;
import com.teamA.hicardi.domain.item.repository.ItemImageRepository;
import com.teamA.hicardi.domain.item.repository.ItemRepository;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;

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
	private final ItemImageRepository itemImageRepository;

    public Page<ItemGetAllResponseDto> getAllItems(Pageable pageable) {
        Page<Item> items = itemRepository.findAll(pageable);
        Page<ItemGetAllResponseDto> response = items.map(i -> ItemGetAllResponseDto.from(i));
        return response;
    }

	public ItemGetResponseDto getItem(Long itemId) {
		Item item = itemRepository.findById(itemId)
			.orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));

		List<ItemImage> itemImages = itemImageRepository.findItemImagesByItemId(itemId);
		List<String> images = itemImages.stream()
			.map(ItemImage::getImage)
			.toList();

		return ItemGetResponseDto.from(item, images);
	}
}

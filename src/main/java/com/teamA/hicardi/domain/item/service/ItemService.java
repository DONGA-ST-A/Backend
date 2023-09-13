package com.teamA.hicardi.domain.item.service;

import com.teamA.hicardi.domain.item.dto.response.ItemGetResponseDto;
import com.teamA.hicardi.domain.item.dto.response.ItemsGetResponseDto;
import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.entity.ItemImage;
import com.teamA.hicardi.domain.item.entity.ItemTag;
import com.teamA.hicardi.domain.item.repository.ItemImageRepository;
import com.teamA.hicardi.domain.item.repository.ItemRepository;
import com.teamA.hicardi.domain.item.repository.ItemTagRepository;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
	private final ItemImageRepository itemImageRepository;
	private final ItemTagRepository itemTagRepository;

    public Page<ItemsGetResponseDto> getAllItems(Pageable pageable) {
        Page<Item> items = itemRepository.findAll(pageable);
        Page<ItemsGetResponseDto> response = items.map(
				i -> ItemsGetResponseDto.from(i, itemTagRepository.findAllByItem(i)));
        return response;
    }

	public ItemGetResponseDto getItem(Long itemId) {
		Item item = itemRepository.findById(itemId)
			.orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));

		List<ItemImage> itemImages = itemImageRepository.findByItemId(itemId);
		List<ItemTag> itemTags = itemTagRepository.findAllByItem(item);
		List<String> images = itemImages.stream()
			.map(ItemImage::getImage)
			.toList();

		return ItemGetResponseDto.from(item, images, itemTags);
	}
}

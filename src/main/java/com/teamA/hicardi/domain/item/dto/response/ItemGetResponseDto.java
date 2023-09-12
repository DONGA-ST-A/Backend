package com.teamA.hicardi.domain.item.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.teamA.hicardi.domain.item.entity.Item;

public record ItemGetResponseDto(Long id, String name, String subname, List<String> tags,
								 String previewImage, Integer price, Integer stock, String status, List<String> images) {

	public static ItemGetResponseDto from(Item item, List<String> itemImages){
		List<String> tags = new ArrayList<>();
		item.getTags().forEach(tag -> tags.add(tag.getDesc()));
		return new ItemGetResponseDto(
			item.getId(),
			item.getName(),
			item.getSubname(),
			tags,
			item.getPreviewImage(),
			item.getPrice(),
			item.getStock(),
			item.getStatus().getDesc(),
			itemImages);
	}
}

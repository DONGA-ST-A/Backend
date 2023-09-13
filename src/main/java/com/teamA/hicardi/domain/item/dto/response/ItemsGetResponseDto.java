package com.teamA.hicardi.domain.item.dto.response;

import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.entity.ItemTag;

import java.util.ArrayList;
import java.util.List;

public record ItemsGetResponseDto(Long id, String name, String subname, List<String> tags,
                                  String previewImage, Integer price, Integer stock, String status) {

    public static ItemsGetResponseDto from(Item item, List<ItemTag> itemTags) {
        List<String> tags = new ArrayList<>();
        itemTags.stream().forEach(i -> tags.add(i.getTag().getDesc()));
        return new ItemsGetResponseDto(item.getId(), item.getName(), item.getSubname(),
                tags, item.getPreviewImage(), item.getPrice(), item.getStock(), item.getStatus().getDesc());
    }
}

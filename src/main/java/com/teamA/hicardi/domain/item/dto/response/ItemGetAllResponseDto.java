package com.teamA.hicardi.domain.item.dto.response;

import com.teamA.hicardi.domain.item.entity.Item;
import org.springframework.format.annotation.NumberFormat;

import java.util.ArrayList;
import java.util.List;

public record ItemGetAllResponseDto(Long id, String name, String subname, List<String> tags,
                                    String previewImage, Integer price, Integer stock, String status) {

    public static ItemGetAllResponseDto from(Item item) {
        List<String> tags = new ArrayList<>();
        item.getTags().forEach(tag -> tags.add(tag.getDesc()));
        return new ItemGetAllResponseDto(item.getId(), item.getName(), item.getSubname(),
                tags, item.getPreviewImage(), item.getPrice(), item.getStock(), item.getStatus().getDesc());
    }
}

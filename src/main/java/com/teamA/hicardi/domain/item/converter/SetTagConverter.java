package com.teamA.hicardi.domain.item.converter;

import com.teamA.hicardi.domain.item.entity.Tag;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.EnumSet;

@Slf4j
@Converter
public class SetTagConverter implements AttributeConverter<EnumSet<Tag>, String> {

    // DB에서 사용할 Type으로 Entity Type을 변환하는 로직
    @Override
    public String convertToDatabaseColumn(EnumSet<Tag> attribute) {
        StringBuilder sb = new StringBuilder();
        attribute.stream().forEach(e -> sb.append(e.name()+","));
        String result = sb.toString();
        if(result.charAt(result.length() - 1) == ',') result = result.substring(0, result.length() - 1);
        return result;
    }

    // Entity에서 사용할 Type으로 DB Type을 변환하는 로직
    @Override
    public EnumSet<Tag> convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData == "" || dbData.contains(".")) return EnumSet.noneOf(Tag.class);
        EnumSet<Tag> attribute = EnumSet.noneOf(Tag.class);
        String[] dbDataArray = StringUtils.trimAllWhitespace(dbData).toUpperCase().split(",");
        Arrays.stream(dbDataArray).forEach(e -> attribute.add(Tag.valueOf(e)));
        return attribute;
    }
}
package com.example.issuetrackerrest.converter;

import com.example.issuetrackerrest.entity.typeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TypeEnumConverter implements Converter<String, typeEnum> {
    @Override
    public typeEnum convert(String s) {
        return typeEnum.valueOf(s.toUpperCase());
    }
}
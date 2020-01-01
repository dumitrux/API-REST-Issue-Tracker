package com.example.issuetrackerrest.converter;

import com.example.issuetrackerrest.entity.statusEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusEnumConverter implements Converter<String, statusEnum> {

    @Override
    public statusEnum convert(String s) {
        return statusEnum.valueOf(s.toUpperCase());
    }
}
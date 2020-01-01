package com.example.issuetrackerrest.converter;

import com.example.issuetrackerrest.entity.priorityEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PriorityEnumConverter implements Converter<String, priorityEnum> {
    @Override
    public priorityEnum convert(String s) {
        return priorityEnum.valueOf(s.toUpperCase());
    }
}

package com.facimath.facimath.mapper;

import com.facimath.facimath.dto.TestCreateDto;
import com.facimath.facimath.dto.TestDto;
import com.facimath.facimath.entity.Test;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {
    public Test toEntity(TestDto dto){
        Test entity = new Test();
        entity.setId(dto.getId());
        entity.setTest(dto.getText());

        return entity;
    }

    public Test toEntity(TestCreateDto dto){
        Test entity = new Test();
        entity.setTest(dto.getText());

        return entity;
    }

    public TestDto toDto(Test entity){
        return new TestDto(entity.getId(), entity.getText());
    }
}

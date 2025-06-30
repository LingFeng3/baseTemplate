package com.baseTemplate.model.vo;

import com.baseTemplate.base.dto.PageBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestVO extends PageBaseDTO {
    private String id;

    private String name;
}

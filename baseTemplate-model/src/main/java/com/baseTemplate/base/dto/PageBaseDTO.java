package com.baseTemplate.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("分页实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PageBaseDTO {

    /** 页数，默认1 */
    @ApiModelProperty("页数，默认1")
    private Integer pageNum;
    public Integer getPageNum() {
        if (null == pageNum) {
            return 1;
        }
        return pageNum;
    }

    /** 一页大小，默认10 */
    @ApiModelProperty("一页大小，默认10")
    private Integer pageSize;
    public Integer getPageSize() {
        if (null == pageSize) {
            return 10;
        }
        return pageSize;
    }
}
package com.example.baseTemplate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("m_test")
public class TestTable {

    @TableId(type = IdType.AUTO)
    private String id;

    private String name;

    private String password;

    private String delFlag;
}

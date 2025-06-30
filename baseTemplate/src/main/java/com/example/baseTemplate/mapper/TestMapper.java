package com.example.baseTemplate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baseTemplate.model.dto.TestDTO;
import com.example.baseTemplate.entity.TestTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<TestTable> {

    List<TestDTO> selectListByPage(TestDTO dto);

}

package com.example.baseTemplate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baseTemplate.model.dto.TestDTO;
import com.example.baseTemplate.entity.TestTable;
import com.example.baseTemplate.mapper.TestMapper;
import com.example.baseTemplate.service.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestMapper testMapper;

    public TestServiceImpl(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public List<TestTable> selectList() {
        LambdaQueryWrapper<TestTable> queryWrapper = Wrappers.lambdaQuery();
        return testMapper.selectList(queryWrapper);
    }

    @Override
    public List<TestDTO> selectList(TestDTO dto) {
        return testMapper.selectListByPage(dto);
    }
}

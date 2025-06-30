package com.example.baseTemplate.service;

import com.baseTemplate.model.dto.TestDTO;
import com.example.baseTemplate.entity.TestTable;

import java.util.List;

public interface TestService {

    List<TestTable> selectList();

    List<TestDTO> selectList(TestDTO dto);
}

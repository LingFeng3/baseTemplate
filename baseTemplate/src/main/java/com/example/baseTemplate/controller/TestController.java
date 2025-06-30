package com.example.baseTemplate.controller;

import com.baseTemplate.model.dto.TestDTO;
import com.baseTemplate.model.vo.TestVO;
import com.example.baseTemplate.assember.TestConvert;
import com.example.baseTemplate.entity.TestTable;
import com.example.baseTemplate.response.ResponseMsg;
import com.example.baseTemplate.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final TestService testService;
    private final TestConvert testConvert;

    public TestController(
            TestService testService,
            TestConvert testConvert
    ){
        this.testService = testService;
        this.testConvert = testConvert;
    }

    @PostMapping("/selectList")
    public ResponseMsg<PageInfo<TestDTO>> selectList(@RequestBody TestVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        // 调用Service层查询数据
        List<TestTable> list = testService.selectList();
        // 通过convert转换成DTO返回数据
        List<TestDTO> dtOs = testConvert.toDTOs(list);
        return ResponseMsg.success(PageInfo.of(dtOs));
    }
}

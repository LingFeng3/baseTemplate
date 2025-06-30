package com.example.baseTemplate.assember;

import com.baseTemplate.model.dto.TestDTO;
import com.baseTemplate.model.vo.TestVO;
import com.example.baseTemplate.entity.TestTable;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TestConvert {

    TestVO toVO(TestDTO dto);

    TestTable toTable(TestDTO dto);

    List<TestDTO> toDTOs(List<TestTable> tables);
}

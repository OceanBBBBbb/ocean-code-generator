package com.ocean.apply.app.test.service.mapper;

import com.ocean.common.mapper.EntityMapper;
import com.ocean.apply.app.test.domain.OceanGenTest;
import com.ocean.apply.app.test.service.dto.OceanGenTestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author ocean-genetator
* @date 2019-11-20
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OceanGenTestMapper extends EntityMapper<OceanGenTestDTO, OceanGenTest> {

}
package com.ocean.apply.test.service.impl;

import com.ocean.apply.test.domain.OceanGenTest;
import com.ocean.common.utils.ValidationUtil;
import com.ocean.apply.test.repository.OceanGenTestRepository;
import com.ocean.apply.test.service.OceanGenTestService;
import com.ocean.apply.test.service.dto.OceanGenTestDTO;
import com.ocean.apply.test.service.dto.OceanGenTestQueryCriteria;
import com.ocean.apply.test.service.mapper.OceanGenTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ocean.common.utils.PageUtil;
import com.ocean.common.utils.QueryHelp;

/**
* @author ocean-genetator
* @date 2019-11-20
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OceanGenTestServiceImpl implements OceanGenTestService {

    @Autowired
    private OceanGenTestRepository oceanGenTestRepository;

    @Autowired
    private OceanGenTestMapper oceanGenTestMapper;

    @Override
    public Object queryAll(OceanGenTestQueryCriteria criteria, Pageable pageable){
        Page<OceanGenTest> page = oceanGenTestRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(oceanGenTestMapper::toDto));
    }

    @Override
    public Object queryAll(OceanGenTestQueryCriteria criteria){
        return oceanGenTestMapper.toDto(oceanGenTestRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public OceanGenTestDTO findById(Long id) {
        Optional<OceanGenTest> oceanGenTest = oceanGenTestRepository.findById(id);
        ValidationUtil.isNull(oceanGenTest,"OceanGenTest","id",id);
        return oceanGenTestMapper.toDto(oceanGenTest.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OceanGenTestDTO create(OceanGenTest resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return oceanGenTestMapper.toDto(oceanGenTestRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OceanGenTest resources) {
        Optional<OceanGenTest> optionalOceanGenTest = oceanGenTestRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalOceanGenTest,"OceanGenTest","id",resources.getId());
        OceanGenTest oceanGenTest = optionalOceanGenTest.get();
        oceanGenTest.copy(resources);
        oceanGenTestRepository.save(oceanGenTest);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        oceanGenTestRepository.deleteById(id);
    }
}
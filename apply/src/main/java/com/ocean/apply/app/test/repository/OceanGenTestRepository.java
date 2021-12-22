package com.ocean.apply.app.test.repository;

import com.ocean.apply.app.test.domain.OceanGenTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ocean-genetator
 * @date 2019-11-20
 */
public interface OceanGenTestRepository extends JpaRepository<OceanGenTest, Long>, JpaSpecificationExecutor {
}
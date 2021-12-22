package com.ocean.generator.repository;

import com.ocean.generator.domain.GenConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ocean Bin
 * @date 2019-01-14
 */
public interface GenConfigRepository extends JpaRepository<GenConfig, Long> {
}

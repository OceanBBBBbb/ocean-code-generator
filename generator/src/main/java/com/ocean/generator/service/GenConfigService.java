package com.ocean.generator.service;

import com.ocean.generator.domain.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author Ocean Bin
 * @date 2019-01-14
 */
@CacheConfig(cacheNames = "genConfig")
public interface GenConfigService {

    /**
     * find
     *
     * @return
     */
    @Cacheable(key = "'1'")
    GenConfig find();

    /**
     * update
     *
     * @param genConfig
     * @return
     */
    @CacheEvict(allEntries = true)
    GenConfig update(GenConfig genConfig);
}

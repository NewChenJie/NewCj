package com.cj.mapper.oasqlserver;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AtestMapper {
    void insert(@Param("name") String s);
}

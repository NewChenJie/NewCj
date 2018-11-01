package com.cj.mapper.oapg;

import com.cj.domain.oapg.Dorm;
import com.cj.domain.oapg.DormExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormMapper {
    int countByExample(DormExample example);

    int deleteByExample(DormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dorm record);

    int insertSelective(Dorm record);

    List<Dorm> selectByExample(DormExample example);

    Dorm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByExample(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByPrimaryKeySelective(Dorm record);

    int updateByPrimaryKey(Dorm record);
}
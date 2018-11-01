package com.cj.service;

import com.cj.domain.oapg.Dorm;
import com.cj.mapper.oapg.DormMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DormServiceImpl implements DormService {
    @Autowired
    DormMapper dormMapper;

    @Override
    public int insertBatch() {
        Dorm build = Dorm.builder().dormclass(1).userid(1).class2id(1).num(1).states(0).build();
        Dorm build1 = Dorm.builder().dormclass(2).userid(2).class2id(2).num(2).states(0).build();
        Dorm build2 = Dorm.builder().dormclass(3).userid(3).class2id(3).num(3).states(0).build();
        ArrayList<Dorm> list = Lists.newArrayList(build, build1, build2);
        for (Dorm dorm : list) {
            dormMapper.insertSelective(dorm);
//            if (dorm.getDormclass()==2){
//                throw new RuntimeException();
//            }
        }
        return 0 ;
    }
}

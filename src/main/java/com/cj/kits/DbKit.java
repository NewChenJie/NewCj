package com.cj.kits;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class DbKit {
    /**
           * 批量提交数据
           * @param sqlSessionFactory
           * @param mybatisSQLId SQL语句在Mapper XML文件中的ID
           * @param commitCountEveryTime 每次提交的记录数
           * @pa list 要提交的数据列表
           */
      private static  <T> void batchCommit(SqlSessionFactory sqlSessionFactory, String mybatisSQLId, int commitCountEveryTime, List<T> list) {
                 SqlSession session = null;
                 try {
                         session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
                         int commitCount = (int) Math.ceil(list.size() / (double) commitCountEveryTime);
                         List<T> tempList = new ArrayList<T>(commitCountEveryTime);
                         int start, stop;
                         Long startTime = System.currentTimeMillis();
                         for (int i = 0; i < commitCount; i++) {
                                 tempList.clear();
                                 start = i * commitCountEveryTime;
                                 stop = Math.min(i * commitCountEveryTime + commitCountEveryTime - 1, list.size() - 1);
                                 for (int j = start; j <= stop; j++) {
                                         tempList.add(list.get(j));
                                     }
                                 session.insert(mybatisSQLId, tempList);
                                 session.commit();
                                 session.clearCache();
                             }
                         Long endTime = System.currentTimeMillis();
                         log.debug("batchCommit耗时：" + (endTime - startTime) + "毫秒");
                     } catch (Exception e) {
                         log.error("batchCommit error!", e);
                         e.printStackTrace();
                         session.rollback();
                     } finally {
                         if (session != null) {
                                 session.close();
                             }
                   }
             }
}

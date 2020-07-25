package com.simonhu.web.logrecord.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface LogMapper {
    void insertLog(Map map);
    
}

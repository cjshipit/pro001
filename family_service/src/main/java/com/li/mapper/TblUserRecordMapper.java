package com.li.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.bean.TblUserRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: Li
 * @Version: 1.0
 * @Creat:2022-02-21
 */
@Component
public interface TblUserRecordMapper extends BaseMapper<TblUserRecord> {
    public TblUserRecord login(@Param("username") String username, @Param("password") String password);
}

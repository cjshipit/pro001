package com.li.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.bean.TblCompany;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author lian
 * @since 2022-02-16
 */
@Component
public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    public List<TblCompany> selectCompany();

}

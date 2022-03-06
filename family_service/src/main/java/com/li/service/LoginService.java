package com.li.service;

import com.li.bean.TblUserRecord;
import com.li.mapper.TblUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: Li
 * @Version: 1.0
 * @Creat:2022-02-18
 */
@Service
public class LoginService {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username, String password){
        return tblUserRecordMapper.login(username,password);
    }

}

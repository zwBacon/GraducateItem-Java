package com.zw.graducate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.graducate.entity.UserInfo;
import com.zw.graducate.mapper.UserInfoMapper;
import com.zw.graducate.service.UserInfoService;
import com.zw.graducate.util.AESUtil;
import com.zw.graducate.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangWei
 * @version 1.0
 * Create by 2023/12/3 13:22
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectUserNameAndPasswordByName(String username) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.select("USERNAME", "PASSWORD").eq("USERNAME", username);
        return userInfoMapper.selectOne(wrapper);
    }

    @Override
    public UserInfo selectUserInfoByName(String username) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("USERNAME", username);
        return userInfoMapper.selectOne(wrapper);
    }

    @Override
    public UserInfo selectUserTitle(String username) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.select("HEADIMG").eq("USERNAME", username);
        return userInfoMapper.selectOne(wrapper);
    }

    @Override
    public int selectUserNameExists(String username) {
        return userInfoMapper.selectUserNameExists(username);
    }

    @Override
    public List<String> selectUserPhoneAll() {
        return userInfoMapper.selectUserPhoneAll();
    }

    @Override
    public int userReister(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public String userPwdByPhone(String phone) {
        return userInfoMapper.userPwdByPhone(AESUtil.encrpt(phone));
    }


    @Override
    public void updatePasswordByPhone(String phone, String newPassWord) {
        String encrptPhone = AESUtil.encrpt(phone);
        String encrptPwd = RSAUtil.encryptData(newPassWord, RSAUtil.generatePublicKey());
        userInfoMapper.updatePasswordByPhone(encrptPhone, encrptPwd);
    }

    @Override
    public String userNameByPhone(String phone) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.select("USERNAME").eq("PHONE", AESUtil.encrpt(phone));
        return userInfoMapper.selectOne(wrapper).getUserName();
    }


}

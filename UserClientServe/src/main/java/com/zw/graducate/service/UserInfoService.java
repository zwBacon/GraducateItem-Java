package com.zw.graducate.service;

import com.zw.graducate.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    //    根据用户名查询登录
    public UserInfo selectUserNameAndPasswordByName(String username);

    //    根据用户名查询信息
    public UserInfo selectUserInfoByName(String username);

    //    根据用户名查询头像
    public UserInfo selectUserTitle(String username);

    //    查询用户名是否存在
    public int selectUserNameExists(String username);

    //    查询手机号是否存在
    public List<String> selectUserPhoneAll();

    //    注册用户
    public int userReister(UserInfo userInfo);

    //    根据手机号查询密码
    public String userPwdByPhone(String phone);

    //    根据手机号查询用户名
    public String userNameByPhone(String phone);

    //    更新用户密码
    public void updatePasswordByPhone(String phone, String newPassWord);


}

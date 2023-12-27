package com.zw.graducate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.graducate.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author ZhangWei
 * @version 1.0
 * Create by 2023/12/3 13:20
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {


    @Select("select count(username) from all_internet_users where USERNAME = #{username}")
    public int selectUserNameExists(String username);

    @Select("SELECT AES_DECRYPT(UNHEX(PHONE),\"2311d32f6fbf5fb09w01e733b67958dd\") as phone\n" +
            "FROM all_internet_users")
    public List<String> selectUserPhoneAll();

    @Select("SELECT PASSWORD\n" +
            "FROM all_internet_users\n" +
            "WHERE PHONE = #{phone}")
    public String userPwdByPhone(String phone);

    @Update("UPdate all_internet_users\n" +
            "set PASSWORD = #{newPassWord}\n" +
            "where PHONE = #{phone}")
    public void updatePasswordByPhone(String phone, String newPassWord);


}

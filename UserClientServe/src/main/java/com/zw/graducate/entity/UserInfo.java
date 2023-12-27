package com.zw.graducate.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangWei
 * @version 1.0
 * Create by 2023/12/3 13:20
 */
@Data
@TableName("all_internet_users")
public class UserInfo {

    @TableField(value = "USERID")
    private String userID;

    @TableField(value = "USERNAME")
    private String userName;

    @TableField(value = "PASSWORD")
    private String password;

    @TableField(value = "IDENTITY")
    private String identity;

    @TableField(value = "ISDELETE")
    private char isdelete;

    @TableField(value = "HEADIMG")
    private byte[] headimg;

    @TableField(value = "PHONE")
    private String phone;

    @TableField(value = "EMAIL")
    private String email;

    @TableField(value = "INTRODUCE")
    private String introduce;

    @TableField(value = "CREATETIME")
    private LocalDateTime createTime;

    @TableField(value = "SEX")
    private char sex;

    @TableField(value = "AGE")
    private Integer age;


}

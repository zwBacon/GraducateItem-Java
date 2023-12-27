package com.zw.graducate.service;

import com.zw.graducate.entity.OfficalAccount;
import com.zw.graducate.entity.SubscribedAccount;

import java.util.List;

public interface OfficalAccountService {

//    查询所有公众号列表
    public List<OfficalAccount> selectAllListAccount();

//    查询用户已关注列表
    public List<SubscribedAccount> selectSubscriedAccount(String username);

//    根据公众号名查公众号信息
    public OfficalAccount selectOneOfficalAccountByAccountName(String accountName);

}

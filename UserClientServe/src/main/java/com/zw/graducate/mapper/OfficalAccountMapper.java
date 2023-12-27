package com.zw.graducate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.graducate.entity.OfficalAccount;
import com.zw.graducate.entity.SubscribedAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OfficalAccountMapper extends BaseMapper<OfficalAccount> {

//    查询已关注的名单
    @Select("select * from offical_account_subsribe where SUBSCRIBED_USERNAME = #{username} and IS_SUBSCRIBED != '0'")
    public List<SubscribedAccount> selectSubscriedAccount(String username);

}

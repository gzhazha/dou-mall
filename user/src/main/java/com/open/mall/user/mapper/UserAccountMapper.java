package com.open.mall.user.mapper;

import com.open.mall.user.domain.po.UserAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【user_account(用户账户信息（等级、积分、余额）)】的数据库操作Mapper
* @createDate 2025-08-25 09:58:48
* @Entity com.open.mall.user.domain.po.UserAccount
*/
@Repository
public interface UserAccountMapper extends BaseMapper<UserAccount> {

}





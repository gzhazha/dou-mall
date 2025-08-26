package com.open.mall.user.mapper;

import com.open.mall.user.domain.po.UserSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author guang
* @description 针对表【user_setting(用户偏好设置表)】的数据库操作Mapper
* @createDate 2025-08-25 09:58:48
* @Entity com.open.mall.user.domain.po.UserSetting
*/
@Repository
public interface UserSettingMapper extends BaseMapper<UserSetting> {

}





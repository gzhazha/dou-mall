package com.dou.mall.user.controller;

import com.dou.mall.common.base.vo.ResponseEntity;
import com.dou.mall.user.service.UserService;
import com.dou.mall.user.vo.UserInfoVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author zhoug
 * @date 2025/2/19 09:43
 */


@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Resource
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoVo> findUserInfo(@PathVariable Long userId) {
        return ResponseEntity.success(userService.findUserInfoByUserId(userId));
    }
}

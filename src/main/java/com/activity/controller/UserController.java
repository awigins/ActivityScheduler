package com.activity.controller;

import com.activity.service.user.AccountService;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.activity.common.result.Result;
import com.activity.common.result.ResultEnum;
import com.activity.common.result.ResultUtils;
import com.activity.entity.user.Account;
import com.activity.entity.user.User;
import com.activity.service.user.UserService;


// Controller：
// 职责：
// 1) 页面导航
// 2) 数据验证：合法性、匹配性检查
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AccountService accountService;

    @GetMapping("/")
    public Result hello() {
        return ResultUtils.success("访问成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody Account account){
        // 1.数据合法性检查
        // 检查是否填入有效账户
        if( StringUtils.isBlank(account.getPhone()) && StringUtils.isBlank(account.getEmail()) ){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入账户手机号或邮箱");
        }
        // 检查是否输入有效密码
        if(StringUtils.isBlank(account.getPassword())){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入密码");
        }

        // 2.数据验证
        // 尝试获取账户信息
        Account fetchedAccount = accountService.getAccount(account);
        // 检查账户是否已存在
        if( ObjectUtils.isNotEmpty(fetchedAccount) ){
            return ResultUtils.error(ResultEnum.ALREADY_EXIST_DATA, "账户已存在");
        }

        // 3.创建账户
        account = accountService.createAndGetAccount(account);
        if( ObjectUtils.isEmpty(account) ){
            return ResultUtils.error(ResultEnum.SERVER_INTERNAL_ERROR, "创建账户失败");
        }

        // 4.创建用户
        User user = userService.createAndGetUser(account);
        if( ObjectUtils.isEmpty(user) ){
            return ResultUtils.error(ResultEnum.SERVER_INTERNAL_ERROR, "创建用户失败");
        }
        return ResultUtils.success(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody Account account){
        // 1.数据合法性检查
        // 检查是否填入有效账户
        if( StringUtils.isBlank(account.getPhone()) && StringUtils.isBlank(account.getEmail()) ){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入账户关联的手机号或邮箱");
        }
        // 检查是否填入有效密码
        if(ObjectUtils.isEmpty(account.getPassword())){
            return ResultUtils.error(ResultEnum.MISSING_REQUIRED_FIELD, "请填入账户密码");
        }

        // 2.账户信息
        // 尝试获取账户信息
        Account fetchedAccount = accountService.getAccount(account);
        // 检查账户是否存在
        if( ObjectUtils.isEmpty(fetchedAccount) ){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "账户不存在");
        }

        // 3.数据验证
        // 匹配密码
        if( !account.getPassword().equals(fetchedAccount.getPassword()) ){
            return ResultUtils.error(ResultEnum.MISMATCHED_DATA, "密码错误");
        }

        // 4.用户信息
        // 尝试获取用户信息
        User user = userService.getUserByAccount(fetchedAccount);
        // 不存在的用户信息
        if(ObjectUtils.isEmpty(user)){
            return ResultUtils.error(ResultEnum.NOT_EXIST_DATA, "用户不存在");
        }
        // 成功，返回
        return ResultUtils.success(user);
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody User user){
        Account account = accountService.getAccount(user.getAccount());
        return ResultUtils.success("该功能未开放");
    }

}

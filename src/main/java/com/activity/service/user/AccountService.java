package com.activity.service.user;

import com.activity.entity.user.Account;
import com.activity.mapper.user.AccountMapper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("AccountService")
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    // 1.只读
    // 获取账户信息
    @Transactional(readOnly = true)
    public Account getAccount(Account account){
        // 尝试使用账户ID匹配
        if(ObjectUtils.isNotEmpty(account.getId())){
            return accountMapper.selectById(account.getId());
        }
        // 尝试使用手机号匹配
        else if(StringUtils.isNotBlank(account.getPhone())){
            return accountMapper.selectByPhone(account.getPhone());
        }
        // 尝试使用邮箱匹配
        else if(StringUtils.isNotBlank(account.getEmail())){
            return accountMapper.selectByEmail(account.getEmail());
        }
        return null;
    }

    // 2.读写
    // 创建账户信息
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Account createAndGetAccount(Account account){
        // 尝试新增记录
        if( accountMapper.insert(account).equals(1) ){
            return account;
        }
        return null;
    }
    // 修改密码
    @Transactional
    public Boolean changePassword(Account account, String newPassword){
        if( accountMapper.updatePasswordById(account.getId(), newPassword).equals(1) ){
            return true;
        }
        return false;
    }
    // 绑定邮箱
    @Transactional
    public Boolean bindPhone(Account account, String phone){
        return 0;
    }
    // 绑定手机
    @Transactional
    public Boolean bindEmail(Account account, String email){
        return 0;
    }

}

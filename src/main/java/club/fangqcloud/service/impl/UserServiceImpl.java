package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.UserMapper;
import club.fangqcloud.pojo.User;
import club.fangqcloud.service.UserService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public JSON selectProfile(Integer userId) {
        JSONObject user = new JSONObject();
        user.put("username",userMapper.selectByUserId(userId).getUsername());
        user.put("userPermission",userMapper.selectByUserId(userId).getUserPermission());
        user.put("productPermission", userMapper.selectByUserId(userId).getProductPermission());
        user.put("purchasePermission", userMapper.selectByUserId(userId).getPurchasePermission());
        user.put("sellPermission", userMapper.selectByUserId(userId).getSellPermission());
        user.put("supplierPermission", userMapper.selectByUserId(userId).getSupplierPermission());
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> selectDynatic(User user) {
        return userMapper.selectDynatic(user);
    }

    @Override
    public Boolean insertDynatic(User user) {
        if(userMapper.insertDynatic(user) > 0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean updateDynamic(User user) {
        if(userMapper.updateDynamic(user) > 0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean deleteByUserId(Integer userId) {
        if(userMapper.deleteByUserId(userId)>0) {
            return true;
        }

        return false;
    }
}

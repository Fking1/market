package club.fangqcloud.service;

import club.fangqcloud.pojo.Supplier;
import club.fangqcloud.pojo.User;
import net.sf.json.JSON;

import java.util.List;

public interface UserService {
    User selectByUserId(Integer userId);

    JSON selectProfile(Integer userId);

    User selectByUsername(String username);

    List<User> selectDynatic(User user);

    Boolean insertDynatic(User user);

    Boolean updateDynamic(User user);

    Boolean deleteByUserId(Integer userId);

}

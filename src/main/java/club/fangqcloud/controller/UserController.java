package club.fangqcloud.controller;

import club.fangqcloud.pojo.User;
import club.fangqcloud.service.UserService;
import club.fangqcloud.utils.JwtUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("register.do")
    @ResponseBody
    public JSON register(User user) {
        JSONObject jsonObject = new JSONObject();

        String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)); //使用bcrypt加密
        user.setPassword(password);

        if(userService.insertDynatic(user)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "注册成功");
            return jsonObject;

        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "注册失败");
        return jsonObject;
    }



    @RequestMapping("login.do")
    @ResponseBody
    public JSON login(User user, HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();

        User u = userService.selectByUsername(user.getUsername());
        if(u == null) {
            jsonObject.put("status", -1);
            jsonObject.put("msg", "用户不存在");
            return jsonObject;
        }

        Boolean isPassword = BCrypt.checkpw(user.getPassword(), u.getPassword());
        if(!isPassword) {
            jsonObject.put("status", -1);
            jsonObject.put("msg", "密码错误");
            return jsonObject;
        }

        String token = JwtUtil.createJWT(300000, u); //调用工具类生成token
        jsonObject.put("status", 0);
        jsonObject.put("msg", "登录成功");
        jsonObject.put("userId", u.getUserId());
        jsonObject.put("token", token);
        return jsonObject;
    }


    @RequestMapping("profile.do")
    @ResponseBody
    public JSON profile(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        System.out.println("header:"+request.getHeader("authorization"));
        if(request.getHeader("authorization").split(" ")[1] == null) {
            jsonObject.put("status", -1);
            jsonObject.put("msg", "获取信息失败");
            return jsonObject;
        }

        String raw = request.getHeader("authorization").split(" ")[1];
        Claims claims = JwtUtil.parseJWT(raw);
        Integer userId = (Integer)claims.get("userId");
        jsonObject.put("status", 0);
        jsonObject.put("msg", "获取信息成功");
        jsonObject.put("profile", userService.selectProfile(userId));

        return jsonObject;
    }

    @RequestMapping("logout.do")
    @ResponseBody
    public JSON logout() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "成功注销");
        return jsonObject;
    }


    @RequestMapping("users.do")
    @ResponseBody
    public JSON users(Integer page, Integer page_size) {
        PageHelper.startPage(page, page_size);
        User user = new User();
        List<User> users = userService.selectDynatic(user);
        PageInfo info = new  PageInfo(users);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }

    @RequestMapping("modifyUser.do")
    @ResponseBody
    public JSON modifyUser(User user) {
        JSONObject jsonObject = new JSONObject();
        if(userService.updateDynamic(user)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "update success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "update fail");
        return jsonObject;
    }

    @RequestMapping("deleteUser.do")
    @ResponseBody
    public JSON deleteUser(Integer userId) {
        JSONObject jsonObject = new JSONObject();
        if(userService.deleteByUserId(userId)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "delete success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "delete fail");
        return jsonObject;
    }

    @RequestMapping("getUserByName.do")
    @ResponseBody
    public JSON getUserByName(Integer page, Integer page_size, String username) {
        PageHelper.startPage(page, page_size);
        User user = userService.selectByUsername(username);
        List<User> users = new ArrayList<>();
        users.add(user);
        PageInfo info = new  PageInfo(users);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }

}

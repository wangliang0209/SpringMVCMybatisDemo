package com.wl.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wl.authorization.annotation.Authorization;
import com.wl.base.common.Constants;
import com.wl.entity.ModelBean;
import com.wl.user.entity.User;
import com.wl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户信息控制类
 *
 * @author wangliang
 */
@Controller
@RequestMapping("/api/user")
public class ApiUserController {

    //produces = {"application/json;charset=UTF-8"}
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @Authorization
    @ResponseBody
    public ModelBean getUserByUid(@RequestParam(value = "uid") String uid) {

        if (uid == null || "".equals(uid)) {
            return new ModelBean(Constants.STATUS_ERROR, "uid 不能为空");
        } else {
            int id = Integer.parseInt(uid);
            User user = userService.getUserById(id);
            if (user != null) {
                return new ModelBean(user);
            } else {
                return new ModelBean(Constants.STATUS_ERROR, "user not exist.");
            }
        }
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Authorization
    @ResponseBody
    public ModelBean getUserList() {
        List<User> users = userService.getUsers();

        JSONObject data = new JSONObject();
        data.put("list", JSONArray.parse(JSON.toJSONString(users)));

        return new ModelBean(data);
    }


}

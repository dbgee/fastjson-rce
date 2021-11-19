package com.kk.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kk.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    User user1=new User(1001,"刘备",20);
    User user2=new User(1002,"关羽",18);
    User user3=new User(1003,"张飞",16);

    @RequestMapping("/list")
    @ResponseBody
    public JSONObject list(){
        JSONObject result=new JSONObject();

        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        result.put("msg","success");
        result.put("code",200);
        result.put("data",userList);

        return result;
    }

    @RequestMapping("/list2")
    @ResponseBody
    public String list2(){
        // 对象转字符
        String userdata=JSON.toJSONString(user2);
        return userdata;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody String data){
        String userdata=data.replace("\r\n","");
        logger.info(userdata);

        //字符转对象
        JSONObject user= JSON.parseObject(userdata);
        JSONObject result=new JSONObject();
        result.put("msg","success");
        result.put("code","200");
        result.put("data",user);

        return result;
    }

    @RequestMapping("/load")
    @ResponseBody
    public JSONObject loadURL(@RequestParam(value = "url",required = false,defaultValue = "http://localhost:8080/") String url){
        logger.info("url={}",url);
        String data="";
        try {
            data=HttpRequest.get(url).execute().body();
        }catch (Exception e){
            logger.error("ssl handshake error:{}",e);
            data="can't load target data:ssl version error";
        }

        JSONObject result=new JSONObject();
        result.put("code",200);
        result.put("url",url);
        result.put("data",data);
        return result;
    }

}

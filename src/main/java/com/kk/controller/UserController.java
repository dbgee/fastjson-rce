package com.kk.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kk.dao.UserDao;
import com.kk.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDao userDao;

    @RequestMapping("/addUser")
    @ResponseBody
    public JSONObject addUser(@RequestBody User user){
        logger.info("user:{}",user);
        user.setId(user.getId());
        userDao.save(user);

        JSONObject result=new JSONObject();
        result.put("msg","success");
        result.put("code","200");
        result.put("data",user);

        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public JSONObject findAll(){
        List<User> users= (List<User>) userDao.findAll();

        JSONObject result=new JSONObject();
        result.put("msg","success");
        result.put("code","200");
        result.put("data",users);

        return result;
    }

    @RequestMapping("/list2")
    @ResponseBody
    public String list2(){
        // 对象转字符
        String userdata=JSON.toJSONString(null);
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

    @RequestMapping("/findUserById")
    @ResponseBody
    public JSONObject findUserById(Long id){
        User user=userDao.findUserById(id);

        JSONObject result=new JSONObject();
        result.put("msg","success");
        result.put("code","200");
        result.put("data",user);

        return result;
    }

    @RequestMapping("/findUserByName")
    @ResponseBody
    public JSONObject findUserByName(String name){
        List<User> users=userDao.findUserByName(name);

        JSONObject result=new JSONObject();
        result.put("msg","success");
        result.put("code","200");
        result.put("data",users);

        return result;
    }

    @RequestMapping("/findUserByAge")
    @ResponseBody
    public JSONObject findUserByAge(int age){
        List<User> users=userDao.findUserByAge(age);

        JSONObject result=new JSONObject();
        result.put("msg","success");
        result.put("code","200");
        result.put("data",users);

        return result;
    }

}

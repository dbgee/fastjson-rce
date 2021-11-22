package com.kk.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.annotation.Native;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    //这里的注解一定要添加
    private Long id;
    private String name;
    private int age;

    public void setId(Long id) {
        this.id = id;
    }

//    @Id   这里的注解一定要去掉，只保留成员变量上的注解即可
    public Long getId() {
        return id;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

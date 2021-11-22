package com.kk.dao;

import com.kk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface UserDao extends CrudRepository<User,Long> {
public interface UserDao extends JpaRepository<User,Long> {

    User findUserById(Long id);

    List<User> findUserByName(String name);

    List<User> findUserByAge(int age);
}

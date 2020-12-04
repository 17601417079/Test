package com.sy.service;

import com.sy.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date: 2020/12/2 16:51
 * @Version 1.0
 */
public interface UserService {

    User findById(int id)throws Exception;
    List<User> findAll() throws Exception;
    Page<User> findPage(Example example,Pageable pageable) throws Exception;
    Page<User> findByUsernameContains(String username, Pageable pageable);
}

package com.sy.service;

import com.sy.model.User;
import com.sy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date: 2020/12/2 16:53
 * @Version 1.0
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository dao;

    @Override
    public User findById(int id) throws Exception {
        return dao.findById(id).get();
    }

    @Override
    public List<User> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public Page<User> findPage(Example example, Pageable pageable) throws Exception {
        return dao.findAll(example, pageable);
    }

    @Override
    public Page<User> findByUsernameContains(String username, Pageable pageable) {
        System.out.println(1/0);
        return dao.getByUsernameContains(username, pageable);
    }
}

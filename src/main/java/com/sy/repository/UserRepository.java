package com.sy.repository;

import com.sy.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author Administrator
 * @Date: 2020/12/2 16:51
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    Page<User> getByUsernameContains(String username, Pageable pageable);
}

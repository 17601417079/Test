package com.sy.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @Date: 2020/12/2 16:50
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;


}

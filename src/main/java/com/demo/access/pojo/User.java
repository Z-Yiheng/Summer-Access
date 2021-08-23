package com.demo.access.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


/**
 * @author 张以恒
 * @create 2021/8/6-15:46
 **/
@Entity
@Table(name = "user")


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String othername;
    private String username;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String qq;
    private String wechat;
    private String logo;
}
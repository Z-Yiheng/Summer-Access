package com.demo.access.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.Date;

/**
 * @author 张以恒
 * @create 2021/8/6-15:24
 **/

@Entity
@Table(name = "my_blog")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String first_picture;
    @Temporal(TemporalType.TIMESTAMP)
    private Date publish_time;
    private String title;
    private Integer views;
    private String brief_content;
    private String detail_content;
    private boolean published;

}
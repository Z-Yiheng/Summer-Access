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
@Table(name = "myBlog")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String firstPicture;
    private String briefContent;
    private String detailContent;
    private Integer views;
    private boolean published;
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishTime;

}
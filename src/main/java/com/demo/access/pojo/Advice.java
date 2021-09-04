package com.demo.access.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 张以恒
 * @create 2021/9/3-11:08
 **/
@Entity
@Table(name = "advice")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Advice {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String way;
    private String number;
    private String advice;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
}
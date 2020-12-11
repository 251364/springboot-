package com.atguigu.springboot.entity;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tt_user") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@Data
public class User2 {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer userId;
    private String username;
    private String password;
    private String nickName;
    private Date birthday;
    private BigDecimal uIndex;  //排序号
    private Integer departmentId;
}

package com.atguigu.springboot.entity;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "t_user") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@Data
public class User {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer userId;

    @Column(name = "user_name",length = 50) //这是和数据表对应的一个列
    private String username;
    @Column //省略默认列名就是属性名
    private String password;
    private String nickName;
    private Date birthday;
    private BigDecimal uIndex;  //排序号
    //一对多映射
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department; //部门实体

}

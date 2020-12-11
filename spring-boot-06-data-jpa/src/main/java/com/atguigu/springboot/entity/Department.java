package com.atguigu.springboot.entity;

import java.util.Date;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "t_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;    //部门id
    private String deptName;   //部门名称
    private Date createDate;   //创建时间
}
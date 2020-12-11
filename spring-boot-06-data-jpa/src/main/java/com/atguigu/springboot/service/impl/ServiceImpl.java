package com.atguigu.springboot.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atguigu.springboot.entity.QDepartment;
import com.atguigu.springboot.entity.QUser;
import com.atguigu.springboot.entity.QUser2;
import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.entity.UserDTO;
import com.atguigu.springboot.entity.UserDeptDTO;
import com.atguigu.springboot.repository.UserRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class ServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
 
    //以下展示使用原生的dsl/
 
    /**
     * 根据用户名和密码查找（假定只能找出一条）
     *
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password) {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .where(
                        user.username.eq(username),
                        user.password.eq(password)
                )
                .fetchOne();
    }
 
    /**
     * 查询所有的实体,根据uIndex字段排序
     *
     * @return
     */
    public List<User> findAll() {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .orderBy(
                        user.uIndex.asc()
                )
                .fetch();
    }
 
    /**
     *分页查询所有的实体,根据uIndex字段排序
     *
     * @return
     */
    public QueryResults<User> findAllPage(Pageable pageable) {
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .orderBy(
                        user.uIndex.asc()
                )
                .offset(pageable.getOffset())   //起始页
                .limit(pageable.getPageSize())  //每页大小
                .fetchResults();    //获取结果，该结果封装了实体集合、分页的信息，需要这些信息直接从该对象里面拿取即可
    }
 
    /**
     * 根据起始日期与终止日期查询
     * @param start
     * @param end
     * @return
     */
    public List<User> findByBirthdayBetween(Date start, Date end){
        QUser user = QUser.user;
        return jpaQueryFactory
                .selectFrom(user)
                .where(
                        user.birthday.between(start, end)
                )
                .fetch();
    }
 
    /**
     * 部分字段映射查询
     * 投影为UserRes,lambda方式(灵活，类型可以在lambda中修改)
     *
     * @return
     */
    public List<UserDTO> findAllUserDto(Pageable pageable) {
        QUser user = QUser.user;
        List<UserDTO> dtoList = jpaQueryFactory
                .select(
                        user.username,
                        user.userId,
                        user.nickName,
                        user.birthday
                )
                .from(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .stream()
                .map(tuple -> UserDTO.builder()
                        .username(tuple.get(user.username))
                        .nickname(tuple.get(user.nickName))
                        .userId(tuple.get(user.userId).toString())
                        .birthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(user.birthday)))
                        .build()
                )
                .collect(Collectors.toList());
 
        return dtoList;
    }
 
    /**
     * 部分字段映射查询
     * 投影为UserRes，自带的Projections方式,不够灵活，不能转换类型，但是可以使用as转换名字
     *
     * @return
     */
    /*public List<UserDTO> findAllDto2() {
        QUser user = QUser.user;
        List<UserDTO> dtoList = jpaQueryFactory
                .select(
                        Projections.bean(
                                UserDTO.class,
                                user.username,
                                user.userId,
                                user.nickName,
                                user.birthday
                        )
                )
                .from(user)
                .fetch();
        return dtoList;
    }*/
 
    //以下展示使用与SpringDataJPA整合的dsl/
 
    /**
     * 根据昵称与用户名查询，并且根据uIndex排序
     *
     * @param nickName
     * @return
     */
    public List<User> findByNicknameAndUsername(String nickName, String username) {
        QUser user = QUser.user;
        List<User> users = (List<User>) userRepository.findAll(
                user.nickName.eq(nickName).and(user.username.eq(username)),
                user.uIndex.asc()   //排序参数
        );
        return users;
    }
 
    /**
     * 统计名字像likeName的记录数量
     *
     * @return
     */
    public long countByNickNameLike(String likeName) {
        QUser user = QUser.user;
        return userRepository.count(
                user.nickName.like("%" + likeName + "%")
        );
    }
 
    //展示dsl动态查询
 
    /**
     * 所有条件动态分页查询
     *
     * @param username
     * @param password
     * @param nickName
     * @param birthday
     * @param uIndex
     * @return
     */
    public Page<User> findByUserProperties(Pageable pageable, String username, String password, String nickName, Date birthday, BigDecimal uIndex) {
        QUser user = QUser.user;
        //初始化组装条件(类似where 1=1)Predicate接口主要用来判断一个参数是否符合要求
        Predicate predicate = user.isNotNull().or(user.isNull());
 
        //执行动态条件拼装
        predicate = username == null ? predicate : ExpressionUtils.and(predicate,user.username.eq(username));
        predicate = password == null ? predicate : ExpressionUtils.and(predicate,user.password.eq(password));
        predicate = nickName == null ? predicate : ExpressionUtils.and(predicate,user.nickName.eq(username));
        predicate = birthday == null ? predicate : ExpressionUtils.and(predicate,user.birthday.eq(birthday));
        predicate = uIndex ==   null ? predicate : ExpressionUtils.and(predicate,user.uIndex.eq(uIndex));
 
        Page<User> page = userRepository.findAll(predicate, pageable);
        return page;
    }
 
    /**
     * 动态条件排序、分组查询
     * @param username
     * @param password
     * @param nickName
     * @param birthday
     * @param uIndex
     * @return
     */
    public List<User> findByUserPropertiesGroupByUIndex(String username, String password, String nickName, Date birthday, BigDecimal uIndex) {
 
        QUser user = QUser.user;
        //初始化组装条件(类似where 1=1)Predicate接口主要用来判断一个参数是否符合要求
        Predicate predicate = user.isNotNull().or(user.isNull());
        //执行动态条件拼装
        predicate = username == null ? predicate : ExpressionUtils.and(predicate, user.username.eq(username));
        predicate = password == null ? predicate : ExpressionUtils.and(predicate, user.password.eq(password));
        predicate = nickName == null ? predicate : ExpressionUtils.and(predicate, user.nickName.eq(username));
        predicate = birthday == null ? predicate : ExpressionUtils.and(predicate, user.birthday.eq(birthday));
        predicate = uIndex == null ? predicate : ExpressionUtils.and(predicate, user.uIndex.eq(uIndex));
        //执行拼装好的条件并根据userId排序，根据uIndex分组
        List<User> list = jpaQueryFactory
                .selectFrom(user)
                .where(predicate)               //执行条件
                .orderBy(user.userId.asc())     //执行排序
                .groupBy(user.uIndex)           //执行分组
                .having(user.uIndex.longValue().max().gt(7))//uIndex最大值小于7
                .fetch();
 
        //封装成Page返回
        return list;
    }
    
    /**
     * 根据部门的id查询用户的基本信息+用户所属部门信息，并且使用UserDeptDTO进行封装返回给前端展示
     * @param departmentId
     * @return
     */
    public List<UserDeptDTO> findByDepatmentIdDTO(int departmentId) {
        QUser user = QUser.user;
        QDepartment department = QDepartment.department;
        //直接返回
        return jpaQueryFactory
                //投影只去部分字段
                .select(
                        user.username,
                        user.nickName,
                        user.birthday,
                        department.deptName,
                        department.createDate
 
                )
                .from(user)
                //联合查询
                .join(user.department, department)//leftjoin的第一个参数是用户所关联的部门，第二个参数可以当做该user.department别名来使用
                .where(department.deptId.eq(departmentId))
                .fetch()
                //lambda开始
                .stream()
                .map(tuple ->
                        //需要做类型转换，所以使用map函数非常适合
                        UserDeptDTO.builder()
                                .username(tuple.get(user.username))
                                .nickname(tuple.get(user.nickName))
                                .birthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(user.birthday)))
                                .deptName(tuple.get(department.deptName))
                                .deptBirth(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(department.createDate)))
                                .build()
                )
                .collect(Collectors.toList());
    }
    
    
    /**
     * 根据部门的id查询用户的基本信息+用户所属部门信息，并且使用UserDeptDTO进行封装返回给前端展示
     *
     * @param departmentId
     * @return
     */
    public List<UserDeptDTO> findByDepatmentIdDTO2(int departmentId) {
        QUser2 user = QUser2.user2;
        QDepartment department = QDepartment.department;
        //直接返回
        return jpaQueryFactory
                //投影只去部分字段
                .select(
                        user.username,
                        user.nickName,
                        user.birthday,
                        department.deptName,
                        department.createDate
 
                )
                .from(user, department)
                //联合查询
                .where(
                        user.departmentId.eq(department.deptId).and(department.deptId.eq(departmentId))
                )
                .fetch()
                //lambda开始
                .stream()
                .map(tuple ->
                        //需要做类型转换，所以使用map函数非常适合
                        UserDeptDTO.builder()
                                .username(tuple.get(user.username))
                                .nickname(tuple.get(user.nickName))
                                .birthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(user.birthday)))
                                .deptName(tuple.get(department.deptName))
                                .deptBirth(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tuple.get(department.createDate)))
                                .build()
                )
                .collect(Collectors.toList());
    }  
    
}
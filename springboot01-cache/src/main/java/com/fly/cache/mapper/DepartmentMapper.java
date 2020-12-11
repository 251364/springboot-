package com.fly.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.fly.cache.bean.Department;

/*@Repository*/
@Mapper
public interface DepartmentMapper {

	@Select("SELECT * FROM department WHERE id=#{id}")
   public 	Department getDeptById(Integer id);

}

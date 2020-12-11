package io.rong.mapper;

import org.springframework.stereotype.Repository;

import io.rong.bean.MessageInf;


//@Mapper或者@MapperScan将接口扫描装配到容器中

@Repository
public interface MsgMapper {

	public int insertMsg(MessageInf msg);


}

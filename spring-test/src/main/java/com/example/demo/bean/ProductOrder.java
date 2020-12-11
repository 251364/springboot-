package com.example.demo.bean;



import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
//成品出库订单
@Data
@NoArgsConstructor
public class ProductOrder {
	  
	    private Long orderId;//订单id
	    private String orderNo;//订单编号
	    private String saleOrderNo;//销售订单编号
	    private Long customerId;//客户id
	    private String customerNo;//客户编号
	    private String customerName;//客户名称
	    private String pickDepartmentNo;//领料部门编号
	    private String pickDepartmentName;//领料部门名称
	    private Long orderType;//订单类型
	    private String productName;//成品信息
	    private Long applyPersonId;//制单人id
	    private String applyPersonName;//制单人姓名
	    private Date completeTime;//完成日期
	    private Integer state;//状态
	    private Integer count;//导出次数
	    private Date completeTimeStart;//开始时间
	    private Date completeTimeEnd;//结束时间
	    private Date createTime;//订单创建时间
	    private List<?>   productOutStorages;//批次信息
	    
}

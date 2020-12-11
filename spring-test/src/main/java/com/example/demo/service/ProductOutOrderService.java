package com.example.demo.service;


import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.ProductMergeOutVo;
import com.example.demo.bean.ProductOutDemand;
import com.example.demo.bean.ProductOutOrder;
import com.example.demo.response.Page;
import com.example.demo.response.R;

import java.util.List;

/**
 
成品出库订单接口
 
 */
public interface ProductOutOrderService {

   
     //分页 查询成品出库订单   
    Page selectPage(long currentPage, long pageSize, ProductOutOrder productOutOrder);
   //根据id查询成品出库订单，type 0--订单审核编辑，1--出库操作编辑
    ProductOutOrder getProductOutOrderById(Long id,int type);
    //新增成品出库订单
    R insertProductOutOrder(ProductOutOrder productOutOrder);
    // 修改成品出库订单   
    R updateProductOutOrder(ProductOutOrder productOutOrder);  
     // 删除成品出库订单   
    R deleteProductOutOrder(Long id);
    //通过订单id获取推荐批次信息
    ProductOutOrder getRecommendBatchById(Long id);
 //   出库操作前验证
    R checkBeforeOut(ProductOutOrder productOutOrder);
//  通过订单id作废
    R toVoid(Long id);
    //出库操作 成品出库订单type 0--保存，1--提交
    R operateOut(ProductOutOrder productOutOrder,int type);
  //合并出库成品出库订单
   R getMergeOutInfo(ProductMergeOutVo mergeOutVo);
  //合并出库保存 
    R saveMergeOut(ProductMergeOutVo mergeOutVo);
   // 分配出库单
    Page allotOutOrder(long currentPage, long pageSize,ProductMergeOutVo mergeOutVo);    
     // 复核后处理 id 成品出库订单id,auditResult 复核结果    
    R operatesign(Long id,Integer auditResult, Integer auditStateDel, Integer auditStateEdit);
    // 根据id查询成品出库需求单
       List<ProductOutDemand> getProductOutDemandById(Long id);
     //导出Excel或pdf productOutOrder 成品出库订单,response   响应   
    void deriveExcelOrPdf(HttpServletResponse response, ProductOutOrder productOutOrder, String type);
}

package com.example.demo.mapper;


import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.ProductMergeOutVo;
import com.example.demo.bean.ProductOutDemand;
import com.example.demo.bean.ProductOutOrder;
import com.example.demo.bean.ProductOutPackage;
import com.example.demo.bean.ProductOutStorage;


import java.util.List;

/**
 : 成品出库订单mapper
 * 
 */
public interface ProductOutOrderMapper {

     //分页查询成品出库订单
    List<ProductOutOrder> selectPage(@Param("currentPage") long currentPage, @Param("pageSize") long pageSize, @Param("productOutOrder") ProductOutOrder productOutOrder);
     //根据id查询成品出库订单
    ProductOutOrder getProductOutOrderById(Long id);
    //根据id查询成品出库单和需求(编辑出库操作) 
    ProductOutOrder getProductOutDemandInfoById(Long outOrderId);
    //通过订单id获取推荐批次信息
    ProductOutOrder getRecommendBatchById(Long id);
    //查询出库订单list
    List<ProductOutOrder> selectList(@Param("productOutOrder") ProductOutOrder productOutOrder);
     //根据出库订单id获取List
    List<ProductOutOrder> getListByOderIds(@Param("outOrderIds") List<Long> outOrderIds);
     // 新增成品出库订单  
    void insertProductOutOrder(ProductOutOrder productOutOrder);
     //修改成品出库订单
    void updateProductOutOrder(ProductOutOrder productOutOrder);
      //删除成品出库订单
    void  deleteProductOutOrder(Long id);   
     // 成品出库订单总记录数
    int listCount(@Param("productOutOrder") ProductOutOrder productOutOrder);
   
    
    //新增成品出库需求单
    void insertProductOutDemand(ProductOutDemand productOutDemand);
    //更改成品出库需求单
    void updateProductOutDemand(ProductOutDemand productOutDemand);
    //删除品出库需求单指定批次信息
    void deleteProductOutDemandBatch(Long demandId);
    //根据需求单id指定批次id集合
    List<Long> getStorageIdsByDemandId(Long demandId);
   //根据出库订单id查询需求单list
    List<ProductOutDemand> getDemandListByOrderId(Long outOrderId); 
    
    
    //新增成品出库批次信息
    void insertProductOutStorage(ProductOutStorage productOutStorage);
   //更改成品出库批次信息    
    void updateProductOutStorage(ProductOutStorage productOutStorage);
    //根据出库订单id查询批次list
    List<ProductOutStorage> getStorageListByOrderId(Long outOrderId);
   
    
    
    // 新增成品出库包装信息
    void insertProductOutPackage(ProductOutPackage productOutPackage);
   // 更改成品出库包装信息
    void updateProductOutPackage(ProductOutPackage productOutPackage);
    //根据出库订单id查询包装list
    List<ProductOutPackage> getPackageListByOrderId(Long outOrderId);
  //  根据出库订单id清空包装占用信息
    void emptyPackageInfo(Long outOrderId);
    // 根据出库订单id添加包装占用信息
    void addPackageOccupyInfo(@Param("occupyNo") String occupyNo,@Param("occupyInfo") String occupyInfo,@Param("outOrderId") Long outOrderId);
    
    
    
   //获取分配出库单页面
    List<ProductOutOrder> getAllotPage(@Param("currentPage") long currentPage, @Param("pageSize") long pageSize,@Param("mergeOutVo") ProductMergeOutVo mergeOutVo);
   //获取分配出库单总记录数
    int getAllotCount(@Param("mergeOutVo") ProductMergeOutVo mergeOutVo);
   
 
  
    
}

package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ProductMergeOutVo;
import com.example.demo.bean.ProductOutOrder;
import com.example.demo.response.R;
import com.example.demo.service.ProductOutOrderService;

import lombok.AllArgsConstructor;


/**
  成品出库订单控制层
 
 */

@RestController
@AllArgsConstructor
@RequestMapping("/productOutOrder")

public class ProductOutOrderController {

    private final ProductOutOrderService productOutOrderService;

    /**
     * 分页查询 + 条件搜索
     *
     * @param currentPage  当前页
     * @param pageSize     分页大小
     * @param productOutOrder 成品出库订单
     * @return R
     */
 
    @PostMapping("/{currentPage}/{pageSize}")
    public R getListByPage(@PathVariable("currentPage") long currentPage,
                           @PathVariable("pageSize") long pageSize,
                           @RequestBody ProductOutOrder productOutOrder) {
      
            return R.ok().data(productOutOrderService.selectPage(currentPage, pageSize, productOutOrder));
       
        
    }
    /**
     * 出库操作前验证
     *
     * @param productOutOrder 成品出库订单
     * @return R
     */

    @PostMapping("/checkBeforeOut")
    public R checkBeforeOut(@RequestBody ProductOutOrder productOutOrder) {
       
            return R.ok().data(productOutOrderService.checkBeforeOut(productOutOrder));
       
    }
    /**
     * 出库操作保存
     *
     * @param productOutOrder 成品出库订单
     * @param type 0--保存，1--提交
     * @return R
     */

    @PostMapping("/operateOut/{type}")
    public R checkBeforeOut(@RequestBody ProductOutOrder productOutOrder,@PathVariable int type) {
        
            return R.ok().data(productOutOrderService.operateOut(productOutOrder,type));
      
    }
    /**
     * 合并出库推荐批次
     *
     * @param mergeOutVo 合并出库订单
     * @return R
     */
 
    @PostMapping("/getMergeOutInfo")
    public R getMergeOutInfo(@RequestBody ProductMergeOutVo mergeOutVo) {
        
            return productOutOrderService.getMergeOutInfo(mergeOutVo);
    }
    /**
     * 合并出库查询
     *
     * @param mergeOutVo 合并出库订单
     * @return R
     */

    @PostMapping("/getAllotPage/{currentPage}/{pageSize}")
    public R allotOutOrder(@PathVariable("currentPage") long currentPage,
                           @PathVariable("pageSize") long pageSize,
                           @RequestBody ProductMergeOutVo mergeOutVo) {

            return R.ok().data(productOutOrderService.allotOutOrder(currentPage,pageSize,mergeOutVo));
   
    }
    /**
     * 合并出库保存
     *
     * @param mergeOutVo 合并出库订单
     * @return R
     */
 
    @PostMapping("/saveMergeOut")
    public R saveMergeOut(@RequestBody ProductMergeOutVo mergeOutVo) {
    
            return productOutOrderService.saveMergeOut(mergeOutVo);
    
    }
    /**
     * 通过id查询成品出库
     *
     * @param id 成品出库订单Id
     * @param type 0--订单审核编辑，1--出库操作编辑
     * @return R
     */
  
    @GetMapping("/{id}/{type}")
    public R getById(@PathVariable Long id,@PathVariable int type) {
        
            return R.ok().data(productOutOrderService.getProductOutOrderById(id,type));
       
    }
    /**
     * 通过id查询成品出库需求单
     *
     * @param id 成品出库订单Id
     * @return R
     */
 
    @GetMapping("/getDemandInfoById/{id}")
    public R getDemandInfoById(@PathVariable String id) {
        
            return R.ok().data(productOutOrderService.getProductOutDemandById(Long.parseLong(id)));
       
    }
    /**
     * 通过订单id获取推荐批次信息
     *
     * @param id 成品出库订单Id
     * @return R
     */
    
    @GetMapping("/getRecommendBatch/{id}")
    public R getRecommendBatch(@PathVariable Long id) {
        
            return R.ok().data(productOutOrderService.getRecommendBatchById(id));
     
    }
    /**
     * 新增成品出库订单
     *
     * @param productOutOrder 实体
     * @return R
     */
 
    @PostMapping
    public R save(@RequestBody ProductOutOrder productOutOrder) {
   
            return productOutOrderService.insertProductOutOrder(productOutOrder);

      
    }

    /**
     * 修改成品出库订单
     *
     * @param productOutOrder 实体
     * @return R
     */

    @PutMapping
    public R updateByIds(@RequestBody ProductOutOrder productOutOrder) {
     
            return  productOutOrderService.updateProductOutOrder(productOutOrder);
      
    }
    /**
     * 删除成品出库订单
     *
     * @param id 条件
     * @return R
     */
 
    @DeleteMapping("/{id}")
    public R deleteByIds(@PathVariable Long id) {
   
            return productOutOrderService.deleteProductOutOrder(id);
      
    }
    /**
     * 作废成品出库订单
     *
     * @param id 条件
     * @return R
     */

    @PostMapping("/{id}")
    public R toVoid(@PathVariable Long id) {
     
            return productOutOrderService.toVoid(id);
      
    }
    /**
     * 成品出库订单模块导出Excel或Pdf，客户端下载
     *
     * @param productOutOrder 条件
     * @param response     响应
     */
    @PostMapping("/deriveExcelOrPdf/{type}")
    public void deriveExcelOrPdf(HttpServletResponse response,
                                 @PathVariable String type,
                                 @RequestBody ProductOutOrder productOutOrder) {
       
            productOutOrderService.deriveExcelOrPdf(response, productOutOrder, type);
       
    }
}

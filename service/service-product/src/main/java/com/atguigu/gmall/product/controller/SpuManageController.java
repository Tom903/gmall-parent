package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.product.service.ManageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/product")
public class SpuManageController {
    @Autowired
    private ManageService manageService;

    // 根据查询条件封装控制器
    // springMVC 的时候，有个叫对象属性传值 如果页面提交过来的参数与实体类的参数一致，
    // 则可以使用实体类来接收数据
    // http://api.gmall.com/admin/product/1/10?category3Id=61
    // @RequestBody 作用 将前台传递过来的json{"category3Id":"61"}  字符串变为java 对象。
    //http://api.gmall.com/admin/product/ {page}/{limit}?category3Id=61
    @GetMapping("{page}/{limit}")//分页查询
    public Result getSpuList(@PathVariable Long page,
                             @PathVariable Long limit,
                             SpuInfo spuInfo) {
        Page<SpuInfo> SpuInfoPage = new Page<>(page, limit);
        IPage spuInfoIPageList = manageService.getSpuInfoPage(SpuInfoPage, spuInfo);
        return Result.ok(spuInfoIPageList);
    }

    //http://api.gmall.com/admin/product/baseSaleAttrList
    @GetMapping("baseSaleAttrList")//获取销售属性
    public Result baseSaleAttrList() {
        // 查询所有的销售属性集合
        List<BaseSaleAttr> list = manageService.getBaseAttrList();
        return Result.ok(list);
    }


    //http://api.gmall.com/admin/product/saveSpuInfo
    @PostMapping("saveSpuInfo")//添加spu
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo) {
        manageService.saveSpuInfo(spuInfo);
        return Result.ok();
    }
}



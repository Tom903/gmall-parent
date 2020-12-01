package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.product.service.ManageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "商品基础 属性接口")
@RequestMapping("admin/product")
//@CrossOrigin
public class BaseManageController {
    @Autowired
    private ManageService manageService;

    //查询所有的一级分类信息http://api.gmall.com/admin/product/getCategory1
    @GetMapping("/getCategory1")
    public Result getCategory1() {
        List<BaseCategory1> baseCategory1List =manageService.finAll();
        return Result.ok(baseCategory1List);
    }

    //根据一级分类Id 查询二级分类数据http://api.gmall.com/admin/product/getCategory2/{category1Id}
    @GetMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable Long category1Id) {
        return Result.ok(manageService.getCategory2(category1Id));
    }

    //根据二级分类Id 查询三级分类数据http://api.gmall.com/admin/product/getCategory3/{category2Id}
    @GetMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable Long category2Id) {
        return Result.ok(manageService.getCategory3(category2Id));
    }

    //根据分类Id 获取平台属性数据http://api.gmall.com/admin/product/attrInfoList/{category1Id}/{category2Id}/{category3Id}
    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable Long category1Id,
                               @PathVariable Long category2Id,
                               @PathVariable Long category3Id) {
        return Result.ok(manageService.getAttrInfoList(category1Id, category2Id, category3Id));
    }
    //新增http://api.gmall.com/admin/product/saveAttrInfo
    @PostMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo saveAttrInfo) {
        //  调用服务层方法
        manageService.saveAttrInfo(saveAttrInfo);
        //  返回
        return Result.ok();
    }

    //根据id查询数据http://api.gmall.com/admin/product/getAttrValueList/{attrId}
    @GetMapping("getAttrValueList/{attrId}")//修改修改
    public Result getAttrValueList(@PathVariable Long attrId) {
        List<BaseAttrValue> baseAttrValueList= manageService.getAttrValueList(attrId);
        return Result.ok(baseAttrValueList);
    }
}

package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.TrademarkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "品牌名称")
@RestController
@RequestMapping("/admin/product/baseTrademark")
public class BaseTrademarkController {

    @Autowired
    private TrademarkService trademarkService;

    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit) {
        Page<BaseTrademark> Page = new Page<>(page, limit);
        IPage<BaseTrademark> list = trademarkService.selectpage(Page);
        return Result.ok(list);
    }

    //http://api.gmall.com/admin/product/baseTrademark/save
    @PostMapping("save")//添加
    public Result save(@RequestBody BaseTrademark baseTrademark) {
        trademarkService.save(baseTrademark);
        return Result.ok();
    }

    //http://api.gmall.com/admin/product/baseTrademark/update
    @PutMapping("update")//修改
    public Result update(@RequestBody BaseTrademark baseTrademark) {
        trademarkService.updateById(baseTrademark);
        return Result.ok();
    }
    //http://api.gmall.com/admin/product/baseTrademark/remove/{id}
    @DeleteMapping("remove/{id}")//根据id删除
    public Result remove(@PathVariable Long id) {
        trademarkService.removeById(id);
        return Result.ok();
    }

    //http://api.gmall.com/admin/product/baseTrademark/get/{id}
    @GetMapping("get/{id}")//根据id查询
    public Result getByIdT(@PathVariable Long id) {
        BaseTrademark byId = trademarkService.getById(id);
        return Result.ok(byId);
    }
    //http://api.gmall.com/admin/product/baseTrademark/getTrademarkList
    @GetMapping("getTrademarkList")
    public Result getTrademarkList() {
        List<BaseTrademark> list = trademarkService.getTrademarklist();
        return Result.ok(list);
    }
}

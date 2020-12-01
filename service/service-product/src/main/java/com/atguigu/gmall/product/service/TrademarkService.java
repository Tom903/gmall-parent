package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TrademarkService extends IService<BaseTrademark> {
    IPage<BaseTrademark> selectpage(Page<BaseTrademark> page);

    List<BaseTrademark> getTrademarklist();
}

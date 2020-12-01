package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.mapper.BaseTrademarkMapper;
import com.atguigu.gmall.product.service.TrademarkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrademarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark> implements TrademarkService {
    @Autowired
    private BaseTrademarkMapper baseTrademarkMapper;
    @Override
    public IPage<BaseTrademark> selectpage(Page<BaseTrademark> page) {
        QueryWrapper<BaseTrademark> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<BaseTrademark> page1 = baseTrademarkMapper.selectPage(page, wrapper);
        return page1;
    }

    @Override
    public List<BaseTrademark> getTrademarklist() {
        QueryWrapper<BaseTrademark> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<BaseTrademark> list = baseTrademarkMapper.selectList(wrapper);
        return list;
    }
}

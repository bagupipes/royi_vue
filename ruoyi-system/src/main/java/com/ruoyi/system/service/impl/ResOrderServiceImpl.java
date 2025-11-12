package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ResOrderMapper;
import com.ruoyi.system.domain.ResOrder;
import com.ruoyi.system.service.IResOrderService;

/**
 * 预约主订单Service业务层处理
 * 
 * @author bagu
 * @date 2025-10-27
 */
@Service
public class ResOrderServiceImpl implements IResOrderService 
{
    @Autowired
    private ResOrderMapper resOrderMapper;

    /**
     * 查询预约主订单
     * 
     * @param id 预约主订单主键
     * @return 预约主订单
     */
    @Override
    public ResOrder selectResOrderById(Long id)
    {
        return resOrderMapper.selectResOrderById(id);
    }

    /**
     * 查询预约主订单列表
     * 
     * @param resOrder 预约主订单
     * @return 预约主订单
     */
    @Override
    public List<ResOrder> selectResOrderList(ResOrder resOrder)
    {
        return resOrderMapper.selectResOrderList(resOrder);
    }

    /**
     * 新增预约主订单
     * 
     * @param resOrder 预约主订单
     * @return 结果
     */
    @Override
    public int insertResOrder(ResOrder resOrder)
    {
        resOrder.setCreateTime(DateUtils.getNowDate());
        return resOrderMapper.insertResOrder(resOrder);
    }

    /**
     * 修改预约主订单
     * 
     * @param resOrder 预约主订单
     * @return 结果
     */
    @Override
    public int updateResOrder(ResOrder resOrder)
    {
        resOrder.setUpdateTime(DateUtils.getNowDate());
        return resOrderMapper.updateResOrder(resOrder);
    }

    /**
     * 批量删除预约主订单
     * 
     * @param ids 需要删除的预约主订单主键
     * @return 结果
     */
    @Override
    public int deleteResOrderByIds(Long[] ids)
    {
        return resOrderMapper.deleteResOrderByIds(ids);
    }

    /**
     * 删除预约主订单信息
     * 
     * @param id 预约主订单主键
     * @return 结果
     */
    @Override
    public int deleteResOrderById(Long id)
    {
        return resOrderMapper.deleteResOrderById(id);
    }
}

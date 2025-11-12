package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ResOrder;

/**
 * 预约主订单Mapper接口
 * 
 * @author bagu
 * @date 2025-10-27
 */
public interface ResOrderMapper 
{
    /**
     * 查询预约主订单
     * 
     * @param id 预约主订单主键
     * @return 预约主订单
     */
    public ResOrder selectResOrderById(Long id);

    /**
     * 查询预约主订单列表
     * 
     * @param resOrder 预约主订单
     * @return 预约主订单集合
     */
    public List<ResOrder> selectResOrderList(ResOrder resOrder);

    /**
     * 新增预约主订单
     * 
     * @param resOrder 预约主订单
     * @return 结果
     */
    public int insertResOrder(ResOrder resOrder);

    /**
     * 修改预约主订单
     * 
     * @param resOrder 预约主订单
     * @return 结果
     */
    public int updateResOrder(ResOrder resOrder);

    /**
     * 删除预约主订单
     * 
     * @param id 预约主订单主键
     * @return 结果
     */
    public int deleteResOrderById(Long id);

    /**
     * 批量删除预约主订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteResOrderByIds(Long[] ids);
}

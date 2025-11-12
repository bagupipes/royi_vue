package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExhibitMapper;
import com.ruoyi.system.domain.Exhibit;
import com.ruoyi.system.service.IExhibitService;

/**
 * 展品Service业务层处理
 * 
 * @author bagu
 * @date 2025-11-01
 */
@Service
public class ExhibitServiceImpl implements IExhibitService 
{
    @Autowired
    private ExhibitMapper exhibitMapper;

    /**
     * 查询展品
     * 
     * @param id 展品主键
     * @return 展品
     */
    @Override
    public Exhibit selectExhibitById(Long id)
    {
        return exhibitMapper.selectExhibitById(id);
    }

    /**
     * 查询展品列表
     * 
     * @param exhibit 展品
     * @return 展品
     */
    @Override
    public List<Exhibit> selectExhibitList(Exhibit exhibit)
    {
        return exhibitMapper.selectExhibitList(exhibit);
    }

    /**
     * 新增展品
     * 
     * @param exhibit 展品
     * @return 结果
     */
    @Override
    public int insertExhibit(Exhibit exhibit)
    {
        exhibit.setCreateTime(DateUtils.getNowDate());
        return exhibitMapper.insertExhibit(exhibit);
    }

    /**
     * 修改展品
     * 
     * @param exhibit 展品
     * @return 结果
     */
    @Override
    public int updateExhibit(Exhibit exhibit)
    {
        exhibit.setUpdateTime(DateUtils.getNowDate());
        return exhibitMapper.updateExhibit(exhibit);
    }

    /**
     * 批量删除展品
     * 
     * @param ids 需要删除的展品主键
     * @return 结果
     */
    @Override
    public int deleteExhibitByIds(Long[] ids)
    {
        return exhibitMapper.deleteExhibitByIds(ids);
    }

    /**
     * 删除展品信息
     * 
     * @param id 展品主键
     * @return 结果
     */
    @Override
    public int deleteExhibitById(Long id)
    {
        return exhibitMapper.deleteExhibitById(id);
    }
}

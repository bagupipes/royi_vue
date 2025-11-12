package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Exhibit;

/**
 * 展品Mapper接口
 * 
 * @author bagu
 * @date 2025-11-01
 */
public interface ExhibitMapper 
{
    /**
     * 查询展品
     * 
     * @param id 展品主键
     * @return 展品
     */
    public Exhibit selectExhibitById(Long id);

    /**
     * 查询展品列表
     * 
     * @param exhibit 展品
     * @return 展品集合
     */
    public List<Exhibit> selectExhibitList(Exhibit exhibit);

    /**
     * 新增展品
     * 
     * @param exhibit 展品
     * @return 结果
     */
    public int insertExhibit(Exhibit exhibit);

    /**
     * 修改展品
     * 
     * @param exhibit 展品
     * @return 结果
     */
    public int updateExhibit(Exhibit exhibit);

    /**
     * 删除展品
     * 
     * @param id 展品主键
     * @return 结果
     */
    public int deleteExhibitById(Long id);

    /**
     * 批量删除展品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExhibitByIds(Long[] ids);
}

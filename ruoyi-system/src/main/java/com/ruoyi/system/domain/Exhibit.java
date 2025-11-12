package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 展品对象 muse_exhibit
 * 
 * @author bagu
 * @date 2025-11-01
 */
public class Exhibit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 展品ID */
    private Long id;

    /** 博物馆ID */
    @Excel(name = "博物馆ID")
    private Long museumId;

    /** 展品名称 */
    @Excel(name = "展品名称")
    private String name;

    /** 分类 */
    @Excel(name = "分类")
    private String category;

    /** 详细描述 */
    @Excel(name = "详细描述")
    private String description;

    /** 展品图片 */
    @Excel(name = "展品图片")
    private String imageUrl;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 展品位置 */
    @Excel(name = "展品位置")
    private String position;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setMuseumId(Long museumId) 
    {
        this.museumId = museumId;
    }

    public Long getMuseumId() 
    {
        return museumId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("museumId", getMuseumId())
            .append("name", getName())
            .append("category", getCategory())
            .append("description", getDescription())
            .append("imageUrl", getImageUrl())
            .append("status", getStatus())
            .append("position", getPosition())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}

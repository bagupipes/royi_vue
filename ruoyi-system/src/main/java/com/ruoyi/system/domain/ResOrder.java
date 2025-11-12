package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约主订单对象 res_order
 * 
 * @author bagu
 * @date 2025-10-27
 */
public class ResOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 内部ID */
    private Long id;

    /** 外部展示预约ID（如202510270001） */
    @Excel(name = "外部展示预约ID", readConverterExp = "如=202510270001")
    private String orderNo;

    /** 总参观人数 */
    @Excel(name = "总参观人数")
    private Long totalVisitors;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String contactName;

    /** 时间段 */
    @Excel(name = "时间段")
    private Long timeSlot;

    /** 身份证 */
    @Excel(name = "身份证")
    private String contactIdcard;

    /** 参观日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "参观日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date visitDate;

    /** 状态:0-待确认,1-已确认,2-已取消 */
    @Excel(name = "状态:0-待确认,1-已确认,2-已取消")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }

    public void setTotalVisitors(Long totalVisitors) 
    {
        this.totalVisitors = totalVisitors;
    }

    public Long getTotalVisitors() 
    {
        return totalVisitors;
    }

    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public String getContactName() 
    {
        return contactName;
    }

    public void setTimeSlot(Long timeSlot) 
    {
        this.timeSlot = timeSlot;
    }

    public Long getTimeSlot() 
    {
        return timeSlot;
    }

    public void setContactIdcard(String contactIdcard) 
    {
        this.contactIdcard = contactIdcard;
    }

    public String getContactIdcard() 
    {
        return contactIdcard;
    }

    public void setVisitDate(Date visitDate) 
    {
        this.visitDate = visitDate;
    }

    public Date getVisitDate() 
    {
        return visitDate;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNo", getOrderNo())
            .append("totalVisitors", getTotalVisitors())
            .append("contactName", getContactName())
            .append("timeSlot", getTimeSlot())
            .append("contactIdcard", getContactIdcard())
            .append("visitDate", getVisitDate())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

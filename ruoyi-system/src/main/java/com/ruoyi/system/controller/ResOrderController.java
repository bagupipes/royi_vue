package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ResOrder;
import com.ruoyi.system.service.IResOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约主订单Controller
 * 
 * @author bagu
 * @date 2025-10-27
 */
@RestController
@RequestMapping("/system/order")
public class ResOrderController extends BaseController
{
    @Autowired
    private IResOrderService resOrderService;

    /**
     * 查询预约主订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(ResOrder resOrder)
    {
        startPage();
        List<ResOrder> list = resOrderService.selectResOrderList(resOrder);
        return getDataTable(list);
    }

    /**
     * 导出预约主订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "预约主订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ResOrder resOrder)
    {
        List<ResOrder> list = resOrderService.selectResOrderList(resOrder);
        ExcelUtil<ResOrder> util = new ExcelUtil<ResOrder>(ResOrder.class);
        util.exportExcel(response, list, "预约主订单数据");
    }

    /**
     * 获取预约主订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(resOrderService.selectResOrderById(id));
    }

    /**
     * 新增预约主订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "预约主订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ResOrder resOrder)
    {
        return toAjax(resOrderService.insertResOrder(resOrder));
    }

    /**
     * 修改预约主订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "预约主订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ResOrder resOrder)
    {
        return toAjax(resOrderService.updateResOrder(resOrder));
    }

    /**
     * 删除预约主订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "预约主订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(resOrderService.deleteResOrderByIds(ids));
    }
}

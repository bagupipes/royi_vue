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
import com.ruoyi.system.domain.Exhibit;
import com.ruoyi.system.service.IExhibitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 展品Controller
 * 
 * @author bagu
 * @date 2025-11-01
 */
@RestController
@RequestMapping("/system/exhibit")
public class ExhibitController extends BaseController
{
    @Autowired
    private IExhibitService exhibitService;

    /**
     * 查询展品列表
     */
    @PreAuthorize("@ss.hasPermi('system:exhibit:list')")
    @GetMapping("/list")
    public TableDataInfo list(Exhibit exhibit)
    {
        startPage();
        List<Exhibit> list = exhibitService.selectExhibitList(exhibit);
        return getDataTable(list);
    }

    /**
     * 导出展品列表
     */
    @PreAuthorize("@ss.hasPermi('system:exhibit:export')")
    @Log(title = "展品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Exhibit exhibit)
    {
        List<Exhibit> list = exhibitService.selectExhibitList(exhibit);
        ExcelUtil<Exhibit> util = new ExcelUtil<Exhibit>(Exhibit.class);
        util.exportExcel(response, list, "展品数据");
    }

    /**
     * 获取展品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:exhibit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(exhibitService.selectExhibitById(id));
    }

    /**
     * 新增展品
     */
    @PreAuthorize("@ss.hasPermi('system:exhibit:add')")
    @Log(title = "展品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Exhibit exhibit)
    {
        return toAjax(exhibitService.insertExhibit(exhibit));
    }

    /**
     * 修改展品
     */
    @PreAuthorize("@ss.hasPermi('system:exhibit:edit')")
    @Log(title = "展品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Exhibit exhibit)
    {
        return toAjax(exhibitService.updateExhibit(exhibit));
    }

    /**
     * 删除展品
     */
    @PreAuthorize("@ss.hasPermi('system:exhibit:remove')")
    @Log(title = "展品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(exhibitService.deleteExhibitByIds(ids));
    }
}

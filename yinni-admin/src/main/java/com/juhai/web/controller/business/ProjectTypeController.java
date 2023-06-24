package com.juhai.web.controller.business;

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
import com.juhai.common.annotation.Log;
import com.juhai.common.core.controller.BaseController;
import com.juhai.common.core.domain.AjaxResult;
import com.juhai.common.enums.BusinessType;
import com.juhai.business.domain.ProjectType;
import com.juhai.business.service.IProjectTypeService;
import com.juhai.common.utils.poi.ExcelUtil;
import com.juhai.common.core.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author zhaotiezhu
 * @date 2023-06-24
 */
@RestController
@RequestMapping("/business/type")
public class ProjectTypeController extends BaseController
{
    @Autowired
    private IProjectTypeService projectTypeService;

    /**
     * 查询商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectType projectType)
    {
        startPage();
        List<ProjectType> list = projectTypeService.selectProjectTypeList(projectType);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:type:export')")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectType projectType)
    {
        List<ProjectType> list = projectTypeService.selectProjectTypeList(projectType);
        ExcelUtil<ProjectType> util = new ExcelUtil<ProjectType>(ProjectType.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(projectTypeService.selectProjectTypeById(id));
    }

    /**
     * 新增商品分类
     */
    @PreAuthorize("@ss.hasPermi('business:type:add')")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectType projectType)
    {
        return toAjax(projectTypeService.insertProjectType(projectType));
    }

    /**
     * 修改商品分类
     */
    @PreAuthorize("@ss.hasPermi('business:type:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectType projectType)
    {
        return toAjax(projectTypeService.updateProjectType(projectType));
    }

    /**
     * 删除商品分类
     */
    @PreAuthorize("@ss.hasPermi('business:type:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(projectTypeService.deleteProjectTypeByIds(ids));
    }
}

package com.juhai.web.controller.business;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.juhai.business.domain.ProjectType;
import com.juhai.business.service.IParamterService;
import com.juhai.business.service.IProjectTypeService;
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
import com.juhai.business.domain.Project;
import com.juhai.business.service.IProjectService;
import com.juhai.common.utils.poi.ExcelUtil;
import com.juhai.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author zhaotiezhu
 * @date 2023-05-21
 */
@RestController
@RequestMapping("/business/project")
public class ProjectController extends BaseController
{
    @Autowired
    private IProjectService projectService;

    @Autowired
    private IParamterService paramterService;

    @Autowired
    private IProjectTypeService projectTypeService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('business:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(Project project)
    {
        startPage();
        List<Project> list = projectService.selectProjectList(project);
        if (CollUtil.isNotEmpty(list)) {
            List<ProjectType> types = projectTypeService.list();
            Map<Long, String> typsMap = types.stream().collect(Collectors.toMap(ProjectType::getId, e -> e.getTypeName()));
            for (Project project1 : list) {
                project1.setTypeName(MapUtil.getStr(typsMap, project1.getTypeId(), "-"));
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('business:project:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Project project)
    {
        List<Project> list = projectService.selectProjectList(project);
        ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        Project project = projectService.selectProjectById(id);

//        Map<String, String> params = paramterService.getAllParamByMap();
//        String resourceDomain = params.get("resource_domain");
//        project.setImg(resourceDomain + project.getImg());

        return success(project);
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('business:project:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Project project)
    {
        project.setStatus(0L);
        return toAjax(projectService.insertProject(project));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('business:project:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Project project)
    {
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('business:project:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(projectService.deleteProjectByIds(ids));
    }
}

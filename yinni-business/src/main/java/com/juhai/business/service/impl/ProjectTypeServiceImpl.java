package com.juhai.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juhai.business.domain.ProjectType;
import com.juhai.business.mapper.ProjectTypeMapper;
import com.juhai.business.service.IProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类Service业务层处理
 * 
 * @author zhaotiezhu
 * @date 2023-06-24
 */
@Service
public class ProjectTypeServiceImpl extends ServiceImpl<ProjectTypeMapper, ProjectType> implements IProjectTypeService
{
    @Autowired
    private ProjectTypeMapper projectTypeMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public ProjectType selectProjectTypeById(Long id)
    {
        return projectTypeMapper.selectProjectTypeById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param projectType 商品分类
     * @return 商品分类
     */
    @Override
    public List<ProjectType> selectProjectTypeList(ProjectType projectType)
    {
        return projectTypeMapper.selectProjectTypeList(projectType);
    }

    /**
     * 新增商品分类
     * 
     * @param projectType 商品分类
     * @return 结果
     */
    @Override
    public int insertProjectType(ProjectType projectType)
    {
        return projectTypeMapper.insertProjectType(projectType);
    }

    /**
     * 修改商品分类
     * 
     * @param projectType 商品分类
     * @return 结果
     */
    @Override
    public int updateProjectType(ProjectType projectType)
    {
        return projectTypeMapper.updateProjectType(projectType);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteProjectTypeByIds(Long[] ids)
    {
        return projectTypeMapper.deleteProjectTypeByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteProjectTypeById(Long id)
    {
        return projectTypeMapper.deleteProjectTypeById(id);
    }
}

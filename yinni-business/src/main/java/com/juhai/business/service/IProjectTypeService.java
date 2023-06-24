package com.juhai.business.service;

import java.util.List;
import com.juhai.business.domain.ProjectType;

/**
 * 商品分类Service接口
 * 
 * @author zhaotiezhu
 * @date 2023-06-24
 */
public interface IProjectTypeService 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public ProjectType selectProjectTypeById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param projectType 商品分类
     * @return 商品分类集合
     */
    public List<ProjectType> selectProjectTypeList(ProjectType projectType);

    /**
     * 新增商品分类
     * 
     * @param projectType 商品分类
     * @return 结果
     */
    public int insertProjectType(ProjectType projectType);

    /**
     * 修改商品分类
     * 
     * @param projectType 商品分类
     * @return 结果
     */
    public int updateProjectType(ProjectType projectType);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键集合
     * @return 结果
     */
    public int deleteProjectTypeByIds(Long[] ids);

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteProjectTypeById(Long id);
}

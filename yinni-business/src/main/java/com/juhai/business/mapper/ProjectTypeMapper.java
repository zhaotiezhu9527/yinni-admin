package com.juhai.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juhai.business.domain.ProjectType;

import java.util.List;

/**
 * 商品分类Mapper接口
 * 
 * @author zhaotiezhu
 * @date 2023-06-24
 */
public interface ProjectTypeMapper extends BaseMapper<ProjectType>
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
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteProjectTypeById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProjectTypeByIds(Long[] ids);
}

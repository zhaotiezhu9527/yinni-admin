package com.juhai.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.juhai.common.annotation.Excel;
import com.juhai.common.core.domain.BaseEntity;

/**
 * 商品分类对象 t_project_type
 * 
 * @author zhaotiezhu
 * @date 2023-06-24
 */
@Data
@TableName(value ="t_project_type")
public class ProjectType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String typeName;

    /** 0:启用 1:停用 */
    @Excel(name = "0:启用 1:停用")
    private Long status;

    /** 排序号 */
    @Excel(name = "排序号")
    private Long sort;

    @Excel(name = "图片")
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeName", getTypeName())
            .append("status", getStatus())
            .append("sort", getSort())
            .toString();
    }
}

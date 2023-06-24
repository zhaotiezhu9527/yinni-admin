package com.juhai.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.juhai.common.annotation.Excel;
import com.juhai.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 t_project
 * 
 * @author zhaotiezhu
 * @date 2023-05-21
 */
@Data
@TableName(value ="t_project")
public class Project extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String projectName;

    /** 项目金额(万元) */
    @Excel(name = "项目金额(万元)")
    private BigDecimal projectAmount;

    /** 收益率 */
    @Excel(name = "收益率")
    private BigDecimal incomeRate;

    /** 期限(分钟) */
    @Excel(name = "期限(分钟)")
    private Long limitTime;

    /** 起投金额 */
    @Excel(name = "起投金额")
    private BigDecimal minAmount;

    /** 0:开启 1:关闭 */
    @Excel(name = "0:开启 1:关闭")
    private Long status;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 项目进度 */
    @Excel(name = "项目进度")
    private String schedule;

    /** 担保公司 */
    @Excel(name = "担保公司")
    private String guaranteeCompany;

    /** 排序号(值越大越靠前) */
    @Excel(name = "排序号(值越大越靠前)")
    private Long sort;

    /** 最后修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "最后修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String img;

    @Excel(name = "分类ID")
    private Long typeId;

    @TableField(exist = false)
    private String typeName;
}

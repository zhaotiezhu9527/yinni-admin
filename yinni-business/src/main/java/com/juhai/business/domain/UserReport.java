package com.juhai.business.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.juhai.common.annotation.Excel;
import com.juhai.common.core.domain.BaseEntity;

/**
 * 用户日报表对象 t_user_report
 * 
 * @author zhaotiezhu
 * @date 2023-05-24
 */
@Data
@TableName(value ="t_user_report")
public class UserReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 日期 */
    @Excel(name = "日期")
    private String today;

    /** 充值金额 */
    @Excel(name = "充值金额")
    private BigDecimal depositAmount;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private BigDecimal withdrawAmount;

    /** 投资金额 */
    @Excel(name = "投资金额")
    private BigDecimal investmentAmount;

    /** 收益金额 */
    @Excel(name = "收益金额")
    private BigDecimal incomeAmount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setToday(String today) 
    {
        this.today = today;
    }

    public String getToday() 
    {
        return today;
    }
    public void setDepositAmount(BigDecimal depositAmount) 
    {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositAmount() 
    {
        return depositAmount;
    }
    public void setWithdrawAmount(BigDecimal withdrawAmount) 
    {
        this.withdrawAmount = withdrawAmount;
    }

    public BigDecimal getWithdrawAmount() 
    {
        return withdrawAmount;
    }
    public void setInvestmentAmount(BigDecimal investmentAmount) 
    {
        this.investmentAmount = investmentAmount;
    }

    public BigDecimal getInvestmentAmount() 
    {
        return investmentAmount;
    }
    public void setIncomeAmount(BigDecimal incomeAmount) 
    {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getIncomeAmount() 
    {
        return incomeAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("today", getToday())
            .append("depositAmount", getDepositAmount())
            .append("withdrawAmount", getWithdrawAmount())
            .append("investmentAmount", getInvestmentAmount())
            .append("incomeAmount", getIncomeAmount())
            .toString();
    }
}

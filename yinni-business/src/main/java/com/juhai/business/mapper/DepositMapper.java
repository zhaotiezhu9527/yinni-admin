package com.juhai.business.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juhai.business.domain.Deposit;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author zhaotiezhu
 * @date 2023-05-21
 */
public interface DepositMapper extends BaseMapper<Deposit>
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Deposit selectDepositById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deposit 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Deposit> selectDepositList(Deposit deposit);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deposit 【请填写功能名称】
     * @return 结果
     */
    public int insertDeposit(Deposit deposit);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deposit 【请填写功能名称】
     * @return 结果
     */
    public int updateDeposit(Deposit deposit);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDepositById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepositByIds(Long[] ids);
}

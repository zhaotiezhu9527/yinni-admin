package com.juhai.business.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juhai.business.domain.Level;
import com.juhai.business.domain.User;

/**
 * 会员等级Mapper接口
 * 
 * @author zhaotiezhu
 * @date 2023-07-14
 */
public interface LevelMapper extends BaseMapper<Level>
{
    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    public Level selectLevelById(Long id);

    /**
     * 查询会员等级列表
     * 
     * @param level 会员等级
     * @return 会员等级集合
     */
    public List<Level> selectLevelList(Level level);

    /**
     * 新增会员等级
     * 
     * @param level 会员等级
     * @return 结果
     */
    public int insertLevel(Level level);

    /**
     * 修改会员等级
     * 
     * @param level 会员等级
     * @return 结果
     */
    public int updateLevel(Level level);

    /**
     * 删除会员等级
     * 
     * @param id 会员等级主键
     * @return 结果
     */
    public int deleteLevelById(Long id);

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLevelByIds(Long[] ids);
}

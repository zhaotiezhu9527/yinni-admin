package com.juhai.business.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juhai.business.domain.User;
import com.juhai.business.mapper.UserMapper;
import com.juhai.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juhai.business.mapper.LevelMapper;
import com.juhai.business.domain.Level;
import com.juhai.business.service.ILevelService;

/**
 * 会员等级Service业务层处理
 * 
 * @author zhaotiezhu
 * @date 2023-07-14
 */
@Service
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements ILevelService
{
    @Autowired
    private LevelMapper levelMapper;

    /**
     * 查询会员等级
     * 
     * @param id 会员等级主键
     * @return 会员等级
     */
    @Override
    public Level selectLevelById(Long id)
    {
        return levelMapper.selectLevelById(id);
    }

    /**
     * 查询会员等级列表
     * 
     * @param level 会员等级
     * @return 会员等级
     */
    @Override
    public List<Level> selectLevelList(Level level)
    {
        return levelMapper.selectLevelList(level);
    }

    /**
     * 新增会员等级
     * 
     * @param level 会员等级
     * @return 结果
     */
    @Override
    public int insertLevel(Level level)
    {
        level.setCreateTime(DateUtils.getNowDate());
        return levelMapper.insertLevel(level);
    }

    /**
     * 修改会员等级
     * 
     * @param level 会员等级
     * @return 结果
     */
    @Override
    public int updateLevel(Level level)
    {
        level.setUpdateTime(DateUtils.getNowDate());
        return levelMapper.updateLevel(level);
    }

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的会员等级主键
     * @return 结果
     */
    @Override
    public int deleteLevelByIds(Long[] ids)
    {
        return levelMapper.deleteLevelByIds(ids);
    }

    /**
     * 删除会员等级信息
     * 
     * @param id 会员等级主键
     * @return 结果
     */
    @Override
    public int deleteLevelById(Long id)
    {
        return levelMapper.deleteLevelById(id);
    }
}

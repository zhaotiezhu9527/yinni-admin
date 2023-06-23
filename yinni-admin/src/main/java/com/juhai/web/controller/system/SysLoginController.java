package com.juhai.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.juhai.business.service.IParamterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.juhai.common.constant.Constants;
import com.juhai.common.core.domain.AjaxResult;
import com.juhai.common.core.domain.entity.SysMenu;
import com.juhai.common.core.domain.entity.SysUser;
import com.juhai.common.core.domain.model.LoginBody;
import com.juhai.common.utils.SecurityUtils;
import com.juhai.framework.web.service.SysLoginService;
import com.juhai.framework.web.service.SysPermissionService;
import com.juhai.system.service.ISysMenuService;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private IParamterService paramterService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());

        Map<String, String> params = paramterService.getAllParamByMap();
        ajax.put(Constants.TOKEN, token);

        Map<String, String> other = new HashMap<>();
        other.put("resourceDomain", params.get("resource_domain"));
        ajax.put("other", other);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}

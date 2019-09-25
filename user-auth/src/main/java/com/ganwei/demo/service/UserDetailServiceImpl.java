package com.ganwei.demo.service;

import com.ganwei.demo.entity.UserWrapper;
import com.ganwei.demo.entity.MenuVo;
import com.ganwei.demo.entity.RoleVo;
import com.ganwei.demo.entity.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userService.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<RoleVo> roleVoList = roleService.getRoleByUserId(userVo.getId());
        for (RoleVo role : roleVoList) {
            //角色必须是ROLE_开头，可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
            grantedAuthorities.add(grantedAuthority);
            List<MenuVo> permissionList = permissionService.getPermissionsByRoleId(role.getId());
            for (MenuVo menu : permissionList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                grantedAuthorities.add(authority);
            }
        }
        User user = new User(userVo.getUsername(), userVo.getPassword(),
                true, true, true, true, grantedAuthorities);
        return user;

        /**
         * 扩展用户信息，放入redis中，后期根据需要
         */

       /* UserWrapper user = new UserWrapper(userVo.getUsername(), userVo.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string));

        user.setHeadImg("weixin img");
        return user;*/
    }
}

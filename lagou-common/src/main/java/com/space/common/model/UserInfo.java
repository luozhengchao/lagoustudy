package com.space.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("用户信息")
public class UserInfo implements Serializable {

    @ApiModelProperty("用户编号")
    private String userId;

    @ApiModelProperty("用户名称（即登录名）")
    private String userName;

    @ApiModelProperty("用户真实姓名")
    private String realName;

    @ApiModelProperty("公司id-顶级机构")
    private String company_id;

    @ApiModelProperty("机构ID")
    private String orgId;

    @ApiModelProperty("机构名称")
    private String orgName;

    @ApiModelProperty("用户移动电话(联系人电话)")
    private String mobileTel;

    @ApiModelProperty("是否首次登录(1-是/0-不是)")
    private String isFirstLogin;

    @ApiModelProperty("数据权限类型（0-私有权限，1-集体权限）")
    private String permissionType;

    /**
     * 权限机构<br/>
     * a、超级管理员：为空<br/>
     * b、集体权限：机构及其子机构<br/>
     * c、私有权限：只包含本身机构<br/>
     */
    @ApiModelProperty("权限机构")
    private List<String> permissionOrgIds;

    @ApiModelProperty("用户角色id集合")
    private List<String> roleIdList;

    @ApiModelProperty("角色类型集合")
    private List<String> roleTypeList;

    public static UserInfo jobUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("job");
        userInfo.setUserName("job");
        return userInfo;
    }

    public static UserInfo mockUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("sysUser");
        userInfo.setUserName("sysUser");
        return userInfo;
    }

}

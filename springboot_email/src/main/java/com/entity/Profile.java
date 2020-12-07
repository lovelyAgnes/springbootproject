package com.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Profile",description = "测试类")
//@Table(name = "table_profile")
public class Profile {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", length = 20, nullable = false, unique = true)
    private Integer id;

    @ApiModelProperty(value = "员工姓名",name = "empName")
    private String empName;
    @ApiModelProperty(value = "员工工号",name = "empNumber")
    private String empNumber;
    @ApiModelProperty(value = "兴趣爱好",name = "hobby")
    private String hobby;
    @ApiModelProperty(value = "个人简介",name = "introduce")
    private String introduce;
    @ApiModelProperty(value = "手机")
    private String mobile;
    @ApiModelProperty(value = "特长")
    private String specialty;
    @ApiModelProperty(value = "工作区域")
    private String workArea;
    @ApiModelProperty(value = "座机")
    private String telephone;

    private String createdAt;
    private String deletedAt;
    private String updatedAt;
}


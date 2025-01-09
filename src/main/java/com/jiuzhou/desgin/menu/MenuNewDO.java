package com.jiuzhou.desgin.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author 沈兴平
 * @date 2025/01/09
 */
@Data
//@TableName("sys_menu_new")
public class MenuNewDO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
//	@TableId(type = IdType.ASSIGN_ID)
	private Long menuId;

	/**
	 * 
	 */
	private Long parentId;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String sysId;

	/**
	 * 
	 */
	private String newId;

	/**
	 * 
	 */
	private String newPid;

	/**
	 * 
	 */
	private Integer newLevel;

	private Integer newXh;

}

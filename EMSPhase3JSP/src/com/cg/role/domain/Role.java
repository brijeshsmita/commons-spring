package com.cg.role.domain;

import java.io.Serializable;

public class Role implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4647245945916716753L;
	private int roleId;
	private String roleName;
	private String roleDesc;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, String roleName, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDesc=" + roleDesc + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.hashCode()==obj.hashCode();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return roleId;
	}
}//end of class

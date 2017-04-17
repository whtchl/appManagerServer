package com.cncoman.product.biz;

import java.util.List;


import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.bean.RoleInfo;


public interface IUserService {

	public UserInfo getInfo(String loginId);
	
	
	/**
	 * 根据身份证号码查找销售人员信息
	 * @param identity
	 * @return
	 */
/*	public MobileSalesInfo getMobileSalesInfo(String identity);*/
	
	public UserInfo getInfo(String loginId, int flag);
	
	public UserInfo getInfo(int id);
	
	/**
	 * 用户列表
	 * @param roleId
	 * @param companyId
	 * @param departmentId
	 * @param from
	 * @param to
	 * @param companyIds
	 * @param uid
	 * @return
	 */
	public List<UserInfo> list(int roleId, int companyId, int departmentId, int from, int to, String companyIds, int uid, UserInfo curUser);
	
	/**
	 * 用户列表
	 * @param roleId
	 * @param companyId
	 * @param departmentId
	 * @param from
	 * @param to
	 * @param companyIds
	 * @param uid
	 * @param valid
	 * @param curUser
	 * @param domain
	 * @return
	 */
	public List<UserInfo> list(int roleId, int companyId, int departmentId, int from, int to, String companyIds, int uid, String valid, UserInfo curUser, int domain);
	
	public List<UserInfo> list(int from, int to, UserInfo curUser);
	
	/**
	 * 用户列表
	 * @param roleId 角色
	 * @param companyId 公司
	 * @param departmentId 部门
	 * @return
	 */
	public List<UserInfo> list(int roleId, int companyId, int departmentId, UserInfo curUser);
	
	/**
	 * 用户列表
	 * @param companyId 公司
	 * @param departmentId 部门
	 * @return
	 */
	public List<UserInfo> salesList(int companyId, int departmentId, UserInfo curUser);
	
	public int save(UserInfo info);
	
	/**
	 * 保存销售人员信息
	 * @param info
	 * @return
	 */
/*	public boolean save(MobileSalesInfo info);*/
	
	public int updateInfo(UserInfo info, UserInfo curUser);
	public int updateMosid(RoleInfo info, UserInfo curUser);
	
	public int updateInfoForLogin(UserInfo info, UserInfo curUser);
	
	public int userCount(int roleId, int companyId, int departmentId, String companyIds, UserInfo curUser);
	
	public int userCount(int roleId, int companyId, int departmentId, String companyIds, UserInfo curUser, String valid, int domain);
	
	public List<RoleInfo> roleList(UserInfo info);
	
	/**
	 * 角色列表
	 * @param ids id序列
	 * @return
	 */
	public List<RoleInfo> roleList(String ids);
	
	/**
	 * 角色列表<br/>
	 * 兼职商务仅可见厂商收益及销量角色
	 * @return
	 */
//	public List<RoleInfo> roleList();
	
	public RoleInfo getRole(int id);
	
	public int updateRole(RoleInfo role, UserInfo curUser);
	
	public int createRole(RoleInfo role);
	
	/**
	 * 物理删除用户<br/>
	 * 除管理员外，仅能删除本公司名下账户
	 * @param id
	 * @param curUser
	 * @return
	 */
	public int deleteUser(int id, UserInfo curUser);
	
	/**
	 * 物理删除角色
	 * @param id
	 * @return
	 */
	public int deleteRole(int id);
	
	/**
	 * 物理删除用户<br/>
	 * 删除该角色下所有用户
	 * @param roleId
	 * @param curUser
	 * @return
	 */
	public int deleteUserByRoleId(int roleId, UserInfo curUser);

}

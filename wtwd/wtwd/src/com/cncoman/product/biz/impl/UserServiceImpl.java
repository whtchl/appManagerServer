package com.cncoman.product.biz.impl;

import java.util.List;


import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.biz.IUserService;
/*import com.cncoman.product.dao.MobileSalesDAO;*/
import com.cncoman.product.dao.UsersDAO;
import com.cncoman.product.bean.RoleInfo;


public class UserServiceImpl implements IUserService {

	private UsersDAO dao;
	
	
	public UserInfo getInfo(String loginId) {
	
		return dao.getInfo(loginId);
	}
	
	public UserInfo getInfo(String loginId, int flag){
		
		return dao.getInfo(loginId, flag);
	}
	
	public UserInfo getInfo(int id){
		
		return dao.getInfo(id);
	}
	
	public List<RoleInfo> roleList(String ids){
		return dao.roleList(ids);
	}
	
	public List<UserInfo> salesList(int companyId, int departmentId, UserInfo curUser){
		
		return list(0, companyId, departmentId, curUser);
	}
	
	public List<UserInfo> list(int roleId, int companyId, int departmentId, UserInfo curUser) {
		
		return list(roleId, companyId, departmentId, 0, 0, null, 1, curUser);
	}

	public List<UserInfo> list(int roleId, int companyId, int departmentId, int from, int to, String companyIds, int uid, UserInfo curUser){
		
		return list(roleId, companyId, departmentId, from, to, companyIds, uid, null, curUser, 0);
	}
	
	public List<UserInfo> list(int roleId, int companyId, int departmentId, int from, int to, String companyIds, int uid, String valid, UserInfo curUser, int domain){
		
		return dao.list(roleId, companyId, departmentId, from, to, companyIds, uid, valid, curUser, domain);
	}
	
	public List<UserInfo> list(int from, int to, UserInfo curUser){
		
		return list(0, 0, 0, from, to, null, 1, curUser);
	}

	public int save(UserInfo info) {
		
		return dao.save(info);
	}

	public int updateInfo(UserInfo info, UserInfo curUser) {
		
		return dao.updateInfo(info, curUser);
	}
	public int updateMosid(RoleInfo info, UserInfo curUser){
		return dao.updateMosid(info, curUser);
	}
	
	public int updateInfoForLogin(UserInfo info, UserInfo curUser){
		
		return dao.updateInfoForLogin(info, curUser);
	}
	
	public int userCount(int roleId, int companyId, int departmentId, String companyIds, UserInfo curUser){
		return userCount(roleId, companyId, departmentId, companyIds, curUser, null, 0);
	}
	
	public int userCount(int roleId, int companyId, int departmentId, String companyIds, UserInfo curUser, String valid, int domain){
		return dao.userCount(roleId, companyId, departmentId, companyIds, curUser, valid, domain);
	}

	public List<RoleInfo> roleList(UserInfo curUser){
		return dao.roleList(curUser);
	}
	
//	public List<RoleInfo> roleList(){
//		UserInfo user = null;
//		return roleList(user);
//	}
	
	public RoleInfo getRole(int id){
		
		return dao.getRole(id);
	}
	
	
	
/*	public boolean save(MobileSalesInfo info){
		
		//return mobileSalesDao.save(info) > 0;
		return true;
	}
	
	public MobileSalesInfo getMobileSalesInfo(String identity){
		//return mobileSalesDao.getInfo(identity);
		return null;
	}*/
	
	public int updateRole(RoleInfo role, UserInfo curUser) {
		return dao.updateRole(role, curUser);
	}

	public int deleteRole(int id){
		return dao.deleteRole(id);
	}
	
	public int createRole(RoleInfo role){
		return dao.createRole(role);
	}
	
	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}
	
	public int deleteUser(int id, UserInfo curUser){
		
		return dao.deleteUser(id, curUser);
	}
	
	public int deleteUserByRoleId(int roleId, UserInfo curUser){
		
		return dao.deleteUserByRoleId(roleId, curUser);
	}

/*	public void setMobileSalesDao(MobileSalesDAO mobileSalesDao) {
		this.mobileSalesDao = mobileSalesDao;
	}*/
}

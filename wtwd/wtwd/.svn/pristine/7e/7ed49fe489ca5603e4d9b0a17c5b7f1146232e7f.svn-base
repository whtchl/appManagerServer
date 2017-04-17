package com.cncoman.product.action;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.biz.IFunClubService;
import com.cncoman.product.action.Action;


public class FunBaseAction extends Action {

	private static final long serialVersionUID = 1L;

	protected static final Log log = LogFactory.getLog("cncoman");

	private static final int BUFFER_SIZE = 16 * 1024;
    protected String starTime;//查询开始时间
    protected String endTime;//查询结束时间
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat ymdsdf = new SimpleDateFormat("yyyy-MM-dd");



	protected boolean success;// 是否更新成功，返回successjson对象

  //  protected UserService userService;
    protected UserInfo userInfo;
	// //////////////////extjsform页面上传图片信息///////////////

	// 其它图片///////////
	protected File softFile;//缤纷乐园所上传的文件
	protected String softFileFileName;//缤纷乐园所上传文件的名称
	protected File upfile;//第一张图片
	protected String upfileFileName;
    protected File imgTable2;//第2张图片
    protected String imgTable2FileName;
    protected File imgTable3;//第3张图片
    protected String imgTable3FileName;
    protected File imgTable4;//第4张图片
    protected String imgTable4FileName;
	// 其它图片///////////
	protected String loMobile;// 手机端logo

	protected File mobileLogo;// 上传手机端的logo图片

	protected String mobileLogoFileName;// 上传手机端的logo图片的名称

	protected File pcLogo;// 上传pc端的图片
    protected IFunClubService funClubService;
	protected String pcLogoFileName;// 上传pc端的logo图片的名称

	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	public File getImgTable2() {
		return imgTable2;
	}

	public void setImgTable2(File imgTable2) {
		this.imgTable2 = imgTable2;
	}

	public String getImgTable2FileName() {
		return imgTable2FileName;
	}

	public void setImgTable2FileName(String imgTable2FileName) {
		this.imgTable2FileName = imgTable2FileName;
	}

	public File getImgTable3() {
		return imgTable3;
	}

	public void setImgTable3(File imgTable3) {
		this.imgTable3 = imgTable3;
	}

	public String getImgTable3FileName() {
		return imgTable3FileName;
	}

	public void setImgTable3FileName(String imgTable3FileName) {
		this.imgTable3FileName = imgTable3FileName;
	}

	public File getImgTable4() {
		return imgTable4;
	}

	public void setImgTable4(File imgTable4) {
		this.imgTable4 = imgTable4;
	}

	public String getImgTable4FileName() {
		return imgTable4FileName;
	}

	public void setImgTable4FileName(String imgTable4FileName) {
		this.imgTable4FileName = imgTable4FileName;
	}

	public String getLoMobile() {
		return loMobile;
	}

	public void setLoMobile(String loMobile) {
		this.loMobile = loMobile;
	}

	public File getMobileLogo() {
		return mobileLogo;
	}

	public void setMobileLogo(File mobileLogo) {
		this.mobileLogo = mobileLogo;
	}

	public String getMobileLogoFileName() {
		return mobileLogoFileName;
	}

	public void setMobileLogoFileName(String mobileLogoFileName) {
		this.mobileLogoFileName = mobileLogoFileName;
	}


	public File getPcLogo() {
		return pcLogo;
	}

	public void setPcLogo(File pcLogo) {
		this.pcLogo = pcLogo;
	}

	public String getPcLogoFileName() {
		return pcLogoFileName;
	}

	public void setPcLogoFileName(String pcLogoFileName) {
		this.pcLogoFileName = pcLogoFileName;
	}

	public File getSoftFile() {
		return softFile;
	}

	public void setSoftFile(File softFile) {
		this.softFile = softFile;
	}

	public String getSoftFileFileName() {
		return softFileFileName;
	}

	public void setSoftFileFileName(String softFileFileName) {
		this.softFileFileName = softFileFileName;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public File getUpfile() {
		return upfile;
	}

	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}

	public String getUpfileFileName() {
		return upfileFileName;
	}

	public void setUpfileFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
	}

	public void setFunClubService(IFunClubService funClubService) {
		this.funClubService = funClubService;
	}

/*	public void setUserService(UserService userService) {
		this.userService = userService;
	}*/

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStarTime() {
		return starTime;
	}

	public void setStarTime(String starTime) {
		this.starTime = starTime;
	}

	

}

package com.cncoman.product.action;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.cncoman.product.bean.CompanyInfo;
import com.cncoman.product.bean.DownLoadInfor;
import com.cncoman.product.bean.FileCategory;
import com.cncoman.product.bean.FileInformation;
import com.cncoman.product.bean.FunClubAdver;
import com.cncoman.product.bean.FunComments;
import com.cncoman.product.bean.OrzStaInfo;
import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.util.Constants;
import com.cncoman.product.util.StringUtil;


public class FunClubAction extends FunBaseAction {
	
	private static String FILE_ABS_PATH = "/usr/local/web/wtwd";

	/**
	 * 
	 * 
	 * fileInformation,category,
	 */
	private File[] upsfile;
	private String[] upsfileFileName;
	private String[] upsfileContentType;
	private String[] imagesName;
	public List<FileInformation> fileList;// 文件集合

	public List<FileCategory> cateList;// 类型集合

	private List<CompanyInfo> companyList;// 公司详情

	public CompanyInfo companyInfo;// 公司详情

	public FileInformation fileInformation;// 文件BEAN

	private DownLoadInfor downLoadInfor;// 下载详情

	private List<DownLoadInfor> dlInfoList;// 下载说情列表

	public FileCategory fileCategory;// 类型BEAN

	public FunClubAdver funclubAdver;// 缤纷乐园广告

	public List<FunClubAdver> adverList;// 缤纷乐园广告列表

	private static final long serialVersionUID = 1L;

	private int pagesize = 10;// 分页大小

	private int page = 1;// 第几页

	private int pageCount;// 总页数;
	
	private int id;
	
	private int cid;
	
	private int comid;
	
	private List<FunComments>	funCommentslist;

	private OrzStaInfo orzStaInfo;
	
	private List<OrzStaInfo> orzStaList;
//	private String pt = "E:/wap.3gaga.com/WebRoot/";

	private String pt = "/usr/local/web/wtwd/";

	// 添加类型
	public String addCategory() throws Exception {
		if (fileCategory == null) {
			return "Fail";
		}
		// /图片上传
		String localPath = ServletActionContext.getServletContext()
				.getRealPath("/images/funclub/");
		String elsePath = pt + "images/funclub";
		upfileFileName = new Random().nextInt(100000)
				+ getExtention(upfileFileName);
		File file = new File(localPath, upfileFileName);
		File file1 = new File(elsePath, upfileFileName);
		try {
			FileUtils.copyFile(upfile, file);
			FileUtils.copyFile(upfile, file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileCategory.setTIcon("/images/funclub/" + upfileFileName);
		int ok = funClubService.addCategory(fileCategory);
		if (ok > 0) {
			return "SUCEESS";
		} else {
			this.addActionError("没有添加成功！！");
			return "Fail";
		}
	}

	// 文件类型管理
	public String Manage_() {
		int listid = 0;
		if (fileCategory == null)
			cateList = funClubService.getCateList();
		for (FileCategory fc : cateList) {
			fc.setListId(listid++);//序号
		    fc.setFileCount(funClubService.getCountFile(fc.getIntId()));
			fc.setDownCount(funClubService.getDownCount(fc.getIntId()));
		}
		return "categoryList";
	}

	// 更新类型显示顺序
	public String updateShowId() {
		fileCategory = new FileCategory();
		String cateId = ServletActionContext.getRequest().getParameter(
				"webIDList");
		String showid = ServletActionContext.getRequest().getParameter(
				"webshowid");
		String[] mstrs = cateId.split(",");
		String[] showIds = showid.split(",");
		for (int i = 0; i < mstrs.length; i++) {
			fileCategory.setIntId(Integer.parseInt(mstrs[i]));
			fileCategory.setShowId(Integer.parseInt(showIds[i]));
			funClubService.updateShowId(fileCategory);
		}
		return "success";
	}

	////增加游戏及软件。跳转到增加文件页面
	public String addFileInfo() {
		// int postion = Integer.parseInt(ServletActionContext.getRequest()
		// .getParameter("position"));
		String postionStr = ServletActionContext.getRequest().getParameter("position");
		int postion;
		if (postionStr == null)
			postion = 1;
		else
			postion = Integer.parseInt(postionStr);
		////// 跳转到增加文件页面///////
		if (fileInformation == null) {
			cateList = funClubService.getPositionById(postion);
			companyList = funClubService.getCompanyList(0);
			return "Fail";
		}
		///// 当有新增内容时，增加游戏或软件文件/////
		try {
			int a = 0;
			String icoarray = "";
			if (upsfileFileName != null) {
				a = upsfileFileName.length;
			}
			for (int i = 0; i < a; i++) {
				if (!StringUtil.isNull(upsfileFileName[i])) {
					String file_path = ServletActionContext.getServletContext()
							.getRealPath("/images/funclub/fileimages/");
					String newUpsfileFileName = Calendar.getInstance().getTime().getTime() + "file" + i
							+ getExtention(upsfileFileName[i]);
					String elsePath = pt + "images/funclub/fileimages";
					File file = new File(file_path, newUpsfileFileName);
					File file1 = new File(elsePath, newUpsfileFileName);
					FileUtils.copyFile(upsfile[i], file);
					FileUtils.copyFile(upsfile[i], file1);
					newUpsfileFileName = "/images/funclub/fileimages/" + newUpsfileFileName;
					icoarray += newUpsfileFileName + ",";
				}
			}
			if (!StringUtil.isNull(icoarray)) {
				fileInformation.setFileImage(icoarray.substring(0, icoarray.length() - 1));
			}
			// if (upfile != null) {
			// String file_path = ServletActionContext.getServletContext()
			// .getRealPath("/images/funclub/fileimages/");
			// upfileFileName = Calendar.getInstance().getTime().getTime()
			// + "file" + getExtention(upfileFileName);
			// fileInformation.setFileImage("/images/funclub/fileimages/"
			// + upfileFileName);
			// String elsePath = pt + "images/funclub/fileimages";
			// File file = new File(file_path, upfileFileName);
			// File file1 = new File(elsePath, upfileFileName);
			// try {
			// FileUtils.copyFile(upfile, file);
			// FileUtils.copyFile(upfile, file1);
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			// }
			if (softFile != null) {
				softFileFileName = Calendar.getInstance().getTime().getTime() + getExtention(softFileFileName);
				String elsePath = pt + "file";
				fileInformation.setFileContent("/file/" + softFileFileName);
				File file = new File(elsePath, softFileFileName);

				long fsize = 0;
				fsize = softFile.length();// (long) 1024;
				fileInformation.setFileSize(fsize + "");
				try {
					FileUtils.copyFile(softFile, file);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			if (pcLogo != null) {
				String path_logo = ServletActionContext.getServletContext().getRealPath("/images/funclub/");
				pcLogoFileName = Calendar.getInstance().getTime().getTime() + "logo" + getExtention(pcLogoFileName);
				String elsePath = pt + "images/funclub";
				File fileLogo = new File(path_logo, pcLogoFileName);
				File fileLogo1 = new File(elsePath, pcLogoFileName);
				fileInformation.setFileIcon("/images/funclub/" + pcLogoFileName);
				try {
					FileUtils.copyFile(pcLogo, fileLogo);
					FileUtils.copyFile(pcLogo, fileLogo1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			UserInfo userInfo = (UserInfo)ServletActionContext.getRequest().getSession().getAttribute("SESSION_USER");
			String loginId = userInfo.getLoginId();
			fileInformation.setUserid(loginId);
			if (funClubService.addFile(fileInformation) == 0)
				return "Fail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (fileInformation.getEssentail() == 0) { // 游戏或者软件
			if (postion == 1)
				return "soft";
			else
				return "game";
		} else /// 装机必备
			return "essential";
	}



	// 调转 soft game
	public void softGameredirect() {
		String type = ServletActionContext.getRequest().getParameter("type");	
		if (type == null) {// 如果不是上下页按扭，就执行分类
			String cateId = ServletActionContext.getRequest().getParameter(
					"cateId");
			int position = 0;
			position = Integer.parseInt(ServletActionContext.getRequest().getParameter("position"));
			try {
				if (position == 1) {
					ServletActionContext.getResponse().sendRedirect(
							"/SoftFileManger?cateId=" + Integer.parseInt(cateId));
				} else {
					ServletActionContext.getResponse().sendRedirect(
							"/GameFileManger?cateId=" + Integer.parseInt(cateId));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (type.equals("preview")) {
				page = page - 1;
			} else
				page = page + 1;

			String cateId = ServletActionContext.getRequest().getParameter(
					"cateId");
			int position =0;
			position = Integer.parseInt(ServletActionContext.getRequest().getParameter("position"));
			try {
				if(Integer.parseInt(cateId)>0){
					if (position == 1) {//软件
						ServletActionContext.getResponse().sendRedirect(
								"/SoftFileManger?cateId="+Integer.parseInt(cateId)+"&page=" + page);
					}else{//游戏软件
						ServletActionContext.getResponse().sendRedirect(
								"/GameFileManger?&cateId="+Integer.parseInt(cateId)+"&page=" + page);
					}
				}else{
					if (position == 1) {
						ServletActionContext.getResponse().sendRedirect(
								"/SoftFileManger?page=" + page);
					}else{
						ServletActionContext.getResponse().sendRedirect(
								"/GameFileManger?page=" + page);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 装机必备
	public String essentail() {
		fileList = funClubService.getFileByEssentail(0);
		int listid = 0;
		File file;
		for (FileInformation ff : fileList) {
			ff.setListId(listid++);
			/*file = new File(FILE_ABS_PATH + ff.getFileContent());			
			ff.setFileSize((file.length() / (long)1024 / (long)1024) + "MB");
			file = null;*/
		}
		cateList = funClubService.getCateList();
		return "success";
	}
	
	public String getfuncommentsList() {
			funCommentslist = funClubService.getfuncommentsList(cid);
		/*int listid = 0;
		File file;
		for (FileInformation ff : fileList) {
			ff.setListId(listid++);
			file = new File(FILE_ABS_PATH + ff.getFileContent());			
			ff.setFileSize((file.length() / (long)1024 / (long)1024) + "MB");
			file = null;
		}
		cateList = funClubService.getCateList();*/
		return "success";
	}
	public String funcommentsdel() {
		funClubService.getfuncommentsdel(comid);
		/*int listid = 0;
		File file;
		for (FileInformation ff : fileList) {
			ff.setListId(listid++);
			file = new File(FILE_ABS_PATH + ff.getFileContent());			
			ff.setFileSize((file.length() / (long)1024 / (long)1024) + "MB");
			file = null;
		}
		cateList = funClubService.getCateList();*/
		return "success";
	}
	
	
	
	
	
	
	// 软件类文件管理
	public String fileSoftManage() {
		cateList = funClubService.getPositionById(1);
		String cateId = ServletActionContext.getRequest()
				.getParameter("cateId");
		UserInfo userInfo = (UserInfo)ServletActionContext.getRequest().getSession().getAttribute(Constants.SESSION_USER);
		String loginId = userInfo.getLoginId();
		String id = "";
		if (cateList.size() == 0)
			return "success";
		else if (cateList.size() == 1)
			id = cateList.get(0).getIntId() + "";
		else {
			for (FileCategory fc : cateList) {
				id += "'" + fc.getIntId() + "',";
			}
			id = id.substring(1, id.length() - 2);
		}
		if (cateId != null && !cateId.equals("null")) {
			id = cateId;
			fileCategory = new FileCategory();
			fileCategory.setIntId(Integer.parseInt(cateId));
		}

		fileList = funClubService.getFileListByMoreId(id, page, pagesize,loginId);
		pageCount = funClubService.getPageCount(id);//总页数
		if (pageCount % pagesize == 0)
			pageCount = pageCount / pagesize;
		else
			pageCount = pageCount / pagesize + 1;
		int listid = 0;
		File file;
		for (FileInformation ff : fileList) {
			ff.setListId(listid++);
			//file = new File(FILE_ABS_PATH + ff.getFileContent());			
			//ff.setFileSize((file.length() / (long)1024 / (long)1024) + "MB");
			//file = null;
		}
		return "success";
	}

	// 游戏类文件管理
	public String fileGameManage() {
		try {
			cateList = funClubService.getPositionById(2);
			String cateId = ServletActionContext.getRequest().getParameter(
					"cateId");
			String pageI = ServletActionContext.getRequest().getParameter(
					"page");
			if (pageI != null) {
				page = Integer.parseInt(pageI);
			}
			String id = "";

			UserInfo userInfo = (UserInfo)ServletActionContext.getRequest().getSession().getAttribute(Constants.SESSION_USER);
			String loginId = userInfo.getLoginId();
			if (cateList.size() == 0)
				return "success";
			else if (cateList.size() == 1)
				id = cateList.get(0).getIntId() + "";
			else {
				for (FileCategory fc : cateList) {
					id += "'" + fc.getIntId() + "',";
				}
				id = id.substring(1, id.length() - 2);
			}

			if (cateId != null) {
				id = cateId;
				fileCategory = new FileCategory();
				fileCategory.setIntId(Integer.parseInt(cateId));
			}
			fileList = funClubService.getFileListByMoreId(id, page, pagesize,loginId);
			pageCount = funClubService.getPageCount(id);
			if (pageCount % pagesize == 0)
				pageCount = pageCount / pagesize;
			else 
				pageCount = pageCount / pagesize + 1;
			int listid = 0;
			File file = null;
			for (FileInformation ff : fileList) {
				ff.setListId(listid++);
				file = new File(FILE_ABS_PATH + ff.getFileContent());				
				ff.setFileSize((file.length() / (long)1024 / (long)1024) + "MB");
				file = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String updateFileShowId() {
		fileInformation = new FileInformation();
		String fileId = ServletActionContext.getRequest().getParameter(
				"webIDList");
		String showid = ServletActionContext.getRequest().getParameter(
				"webshowid");
		String[] mstrs = fileId.split(",");
		String[] showIds = showid.split(",");
		for (int i = 0; i < mstrs.length; i++) {
			fileInformation.setIntId(Integer.parseInt(mstrs[i]));
			fileInformation.setShowId(Integer.parseInt(showIds[i]));
			funClubService.updateFileShowId(fileInformation);
		}
		fileInformation = funClubService
				.getFileInfo(Integer.parseInt(mstrs[0]));
		int position = funClubService.getCateById(
				fileInformation.getCategoryId()).getTPosition();
		if (fileInformation.getEssentail() == 0) {
			if (position == 1)
				return "soft";
			else
				return "game";
		} else
			return "essential";
	}



	// 删除文件
	public String deleteFile() {
		String id = ServletActionContext.getRequest().getParameter("id");
		fileInformation = funClubService.getFileInfo(Integer.parseInt(id));
		int position = funClubService.getCateById(
				fileInformation.getCategoryId()).getTPosition();
		int ok = funClubService.deleteById(Integer.parseInt(id));
		if (ok > 0) {
			if (fileInformation.getEssentail() == 0) {
				if (position == 1)
					return "soft";
				else
					return "game";
			} else
				return "essential";
		} else {

			return "Fail";
		}
	}

	// 更新软件，游戏，装机必备
	public String updateFile() {
		int position;
		///跳转到修改页面
		if (fileInformation == null) {
			String id = ServletActionContext.getRequest().getParameter("id");
			fileInformation = funClubService.getFileInfo(Integer.parseInt(id));
			if (!StringUtil.isNull(fileInformation.getFileImage())) {
				imagesName = fileInformation.getFileImage().split(",");
			}
			cateList = funClubService.getCateList();
			if (fileInformation.getEssentail() == 0) {
				position = funClubService.getCateById(
						fileInformation.getCategoryId()).getTPosition();
				cateList = funClubService.getPositionById(position);
			}
			return "Fail";
		}
		
		///修改文件内容
		int a=0;String icoarray="";
		if(upsfileFileName!=null){
			a=upsfileFileName.length;
		}
		for(int i=0;i<a;i++){
		if (!StringUtil.isNull(upsfileFileName[i])) {
			String file_path = ServletActionContext.getServletContext()
			.getRealPath("/images/funclub/fileimages/");
			String newUpsfileFileName  = Calendar.getInstance().getTime().getTime()+ "file"+i + getExtention(upsfileFileName[i]);
			String elsePath = pt + "images/funclub/fileimages";
			File file = new File(file_path, newUpsfileFileName);
			File file1 = new File(elsePath, newUpsfileFileName);
			try {
				FileUtils.copyFile(upsfile[i], file);
				FileUtils.copyFile(upsfile[i], file1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			newUpsfileFileName = "/images/funclub/fileimages/"+ newUpsfileFileName;
			icoarray += newUpsfileFileName+",";
		}
		}
		if (!StringUtil.isNull(icoarray)) {
			fileInformation.setFileImage(icoarray.substring(0,icoarray.length()-1));
		}
//		if (upfile != null) {
//			String file_path = ServletActionContext.getServletContext()
//					.getRealPath("/images/funclub/fileimages/");
//			upfileFileName = Calendar.getInstance().getTime().getTime()
//					+ "file" + getExtention(upfileFileName);
//			String elsePath = pt + "images/funclub/fileimages";
//			fileInformation.setFileImage("/images/funclub/fileimages/"
//					+ upfileFileName);
//			File file = new File(file_path, upfileFileName);
//			File file1 = new File(elsePath, upfileFileName);
//			try {
//				FileUtils.copyFile(upfile, file);
//				FileUtils.copyFile(upfile, file1);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		if (softFile != null) {
			softFileFileName = Calendar.getInstance().getTime().getTime()
					+ getExtention(softFileFileName);//
			String elsePath = pt + "file";
			fileInformation.setFileContent("/file/" + softFileFileName);
			File file = new File(elsePath, softFileFileName);
			long fsize = 0;
			fsize = softFile.length() ;// (long) 1024;
			fileInformation.setFileSize(fsize+"");
			try {
				FileUtils.copyFile(softFile, file);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if (pcLogo != null) {
			String path_logo = ServletActionContext.getServletContext()
					.getRealPath("/images/funclub/");  
			pcLogoFileName = Calendar.getInstance().getTime().getTime()
					+ "logo" + getExtention(pcLogoFileName);
			String elsePath = pt + "images/funclub/";
			File fileLogo = new File(path_logo, pcLogoFileName);
			File fileLogo1 = new File(elsePath, pcLogoFileName);
			fileInformation.setFileIcon("/images/funclub/" + pcLogoFileName);
			try {
				FileUtils.copyFile(pcLogo, fileLogo);
				FileUtils.copyFile(pcLogo, fileLogo1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		funClubService.updateFileInfo(fileInformation);
//		if (ok > 0) {
//			this.getSession().setAttribute("update", true);
//			return "Fail";
//		}
//		fileInformation = funClubService
//				.getFileInfo(fileInformation.getIntId());
		if (fileInformation.getEssentail() == 0) {
			position = funClubService.getCateById(
					fileInformation.getCategoryId()).getTPosition();
			cateList = funClubService.getPositionById(position);
			if(position == 1)  ///软件
				return "soft";
			else
				return "game";				
		}else
			return "essential";		
	}

	// 更新类型
	public String goUpdate() {
		if (fileCategory == null) {
			String id = ServletActionContext.getRequest().getParameter("id");
			fileCategory = funClubService.getCateById(Integer.parseInt(id));
			return "Fail";
		}
		if (pcLogo != null) {
			String path_logo = ServletActionContext.getServletContext()
					.getRealPath("/images/funclub/");
			pcLogoFileName = Calendar.getInstance().getTime().getTime()
					+ "cateLogo" + getExtention(pcLogoFileName);
			String elsePath = pt + "images/funclub/";
			File fileLogo = new File(path_logo, pcLogoFileName);
			File fileLogo1 = new File(elsePath, pcLogoFileName);
			fileCategory.setTIcon("/images/funclub/" + pcLogoFileName);
			try {
				FileUtils.copyFile(pcLogo, fileLogo);
				FileUtils.copyFile(pcLogo, fileLogo1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		funClubService.updateCateInfo(fileCategory);
		return "success";
	}

	// 根据ID删除类型
	public String DeletCate() {
		String id = ServletActionContext.getRequest().getParameter("id");
		funClubService.deleteCateById(Integer.parseInt(id));
		return "success";
	}

	// 显示缤纷乐园
	public String toFunclub() {
		cateList = funClubService.getCateList();
		return "success";
	}

	// 根据categId得到FileList
	public String getFileListByCateId() {
		String cateId = ServletActionContext.getRequest().getParameter("id");
		if (cateId != null) {
			fileList = funClubService.getFileList(Integer.parseInt(cateId));
		}
		return "success";
	}

	// 根据fileId得到fileInfo
	public String getFileInfo() {
		try {
			String id = ServletActionContext.getRequest().getParameter("id");
			if (id == null) {
				// System.out.println("没有传�??");
			}
			cateList = funClubService.getCateList();
			fileInformation = funClubService.getFileInfo(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	// 合作厂家软件下载统计
	public String companyCount() {
		try {

			fileList = funClubService.getFileList(0);
			if (companyInfo == null) {
				companyList = funClubService.getCompanyList(0);

			}

			else {
				companyList = funClubService
						.getCompanyList(companyInfo.getId());
				if (companyInfo.getId() != 0)// 当选择不是全部时
					fileList = funClubService.getByCompanyId(companyInfo.getId());
			}
			Map<Integer, CompanyInfo> getCompany = new HashMap<Integer, CompanyInfo>();// fileid为键,值为公司名称
			Map<Integer, FileInformation> getFileInfo = new HashMap<Integer, FileInformation>();
			for (FileInformation fm : fileList) {
				for (CompanyInfo c : companyList) {
					if (fm.getCompanyId() == c.getId()) {
						getCompany.put(fm.getIntId(), c);
					}
				}
			}
			// 将文件信息添加到MAP中
			String strSql = "";
			for (FileInformation f : fileList) {
				getFileInfo.put(f.getIntId(), f);
				strSql += f.getIntId() + ",";
			}
			if (!strSql.equals(""))
				strSql = strSql.substring(0, strSql.length() - 1);
			else
				strSql = "''";
			dlInfoList = funClubService.getDownLoadInfo(starTime, endTime,
					strSql);
			// 根据DownLoadInfor的fileid得到厂家名称
			int Count = 0;
			for (DownLoadInfor d : dlInfoList) {
				d.setInfo(getCompany.get(Integer.parseInt(d.getFileId())));
				d.setFileInfo(getFileInfo.get(Integer.parseInt(d.getFileId())));
				Count += d.getCompanyCount();
			}
			DownLoadInfor dl = new DownLoadInfor();
			CompanyInfo ci = new CompanyInfo();
			ci.setName("总计：");
			dl.setInfo(ci);
			dl.setCompanyCount(Count);
			dlInfoList.add(dl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String orzAppSta(){
		try {
		
			if (orzStaInfo==null) {
				orzStaInfo = new OrzStaInfo();
				orzStaInfo.setTitle("日期");
				return SUCCESS;
			}
			switch (orzStaInfo.getGroupBy()) {
			case 1:
				orzStaInfo.setTitle("日期");
				break;
			case 2:
				orzStaInfo.setTitle("月份");
				break;
			case 3:
				orzStaInfo.setTitle("产品");
				break;
			case 4:
				orzStaInfo.setTitle("渠道");
				break;
			}
			orzStaList = funClubService.getOrzAppSta(orzStaInfo.getFromDay(),orzStaInfo.getToDay(),orzStaInfo.getAppId(),
					orzStaInfo.getCode(),orzStaInfo.getGroupBy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	// 添加厂商广告
	// public String addAdever(){
	// if(funclubAdver==null){
	// String companyCode = getCurUser().getCompany().getCode();
	// funclubAdver=new FunClubAdver();
	// funclubAdver.setCode(companyCode);
	// return "Fail";
	// }
	// try {
	// ServletActionContext.getRequest().setCharacterEncoding("utf-8");
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	// System.out.println("funclubAdver :"+funclubAdver.getName());
	// int ok=funClubService.addAdver(funclubAdver);
	// if(ok>0) System.out.println("添加广告成功!");
	// return "success";
	// }
	// 删除广告
	// public String DelAdver(){
	// String id= ServletActionContext.getRequest().getParameter("id");
	// if(id!=null){
	// int ok=funClubService.delAdver(Integer.parseInt(id));
	// }
	// return "success";
	// }
	// //编辑广告
	// public String updateAdver(){
	// String id= ServletActionContext.getRequest().getParameter("id");
	// if(id!=null&&funclubAdver==null){
	// adverList=funClubService.getAdverList(Integer.parseInt(id));
	// funclubAdver=adverList.get(0);
	// return "Fail";
	// }
	// try {
	// ServletActionContext.getRequest().setCharacterEncoding("utf-8");
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// }
	// int ok= funClubService.updateAdver(funclubAdver);
	// if(ok>0) System.out.println("更新成功�?");
	// return "success";
	// }
	// public String adeverManager(){
	// adverList=funClubService.getAdverList(0);
	// return "success";
	// }
	public List<FileCategory> getCateList() {
		return cateList;
	}

	public void setCateList(List<FileCategory> cateList) {
		this.cateList = cateList;
	}

	public List<FileInformation> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileInformation> fileList) {
		this.fileList = fileList;
	}

	public FileCategory getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(FileCategory fileCategory) {
		this.fileCategory = fileCategory;
	}

	public FileInformation getFileInformation() {
		return fileInformation;
	}

	public void setFileInformation(FileInformation fileInformation) {
		this.fileInformation = fileInformation;
	}

	public List<FunClubAdver> getAdverList() {
		return adverList;
	}

	public void setAdverList(List<FunClubAdver> adverList) {
		this.adverList = adverList;
	}

	public FunClubAdver getFunclubAdver() {
		return funclubAdver;
	}

	public void setFunclubAdver(FunClubAdver funclubAdver) {
		this.funclubAdver = funclubAdver;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<CompanyInfo> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyInfo> companyList) {
		this.companyList = companyList;
	}

	public List<DownLoadInfor> getDlInfoList() {
		return dlInfoList;
	}

	public void setDlInfoList(List<DownLoadInfor> dlInfoList) {
		this.dlInfoList = dlInfoList;
	}

	public DownLoadInfor getDownLoadInfor() {
		return downLoadInfor;
	}

	public void setDownLoadInfor(DownLoadInfor downLoadInfor) {
		this.downLoadInfor = downLoadInfor;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public File[] getUpsfile() {
		return upsfile;
	}

	public void setUpsfile(File[] upsfile) {
		this.upsfile = upsfile;
	}

	public String[] getUpsfileFileName() {
		return upsfileFileName;
	}

	public void setUpsfileFileName(String[] upsfileFileName) {
		this.upsfileFileName = upsfileFileName;
	}

	public String[] getUpsfileContentType() {
		return upsfileContentType;
	}

	public void setUpsfileContentType(String[] upsfileContentType) {
		this.upsfileContentType = upsfileContentType;
	}

	public String[] getImagesName() {
		return imagesName;
	}

	public void setImagesName(String[] imagesName) {
		this.imagesName = imagesName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FunComments> getFunCommentslist() {
		return funCommentslist;
	}

	public void setFunCommentslist(List<FunComments> funCommentslist) {
		this.funCommentslist = funCommentslist;
	}

	public int getComid() {
		return comid;
	}

	public void setComid(int comid) {
		this.comid = comid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public OrzStaInfo getOrzStaInfo() {
		return orzStaInfo;
	}

	public void setOrzStaInfo(OrzStaInfo orzStaInfo) {
		this.orzStaInfo = orzStaInfo;
	}

	public List<OrzStaInfo> getOrzStaList() {
		return orzStaList;
	}

	public void setOrzStaList(List<OrzStaInfo> orzStaList) {
		this.orzStaList = orzStaList;
	}
	
}

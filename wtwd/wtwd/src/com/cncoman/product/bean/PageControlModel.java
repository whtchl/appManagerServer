package com.cncoman.product.bean;

import java.io.Serializable;

public class PageControlModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int curPage = 1;
	private int totalPage = 1;
	private int rowsOfPage = 30;
	private String url = "#";
	private int records;
	private int firstPage = 1;   //��ʱδ��
	private int endPage = 5;   //��ʱδ��
	
	public int getTotalPage(int totalRecords, int rowsOfPage){
		this.records = totalRecords;
		if(totalRecords % rowsOfPage == 0){
			return totalRecords / rowsOfPage;
		}		
		return totalRecords / rowsOfPage + 1;
	}
	
	public int getEndPage(int firstPage){
		System.out.println();
		if(firstPage < endPage)
			return endPage;
		return firstPage + endPage - firstPage;
	}
	
	public int getCurPage() {		
		return curPage < 1 ? 1 : curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getRowsOfPage() {
		return rowsOfPage;
	}
	public void setRowsOfPage(int rowsOfPage) {
		this.rowsOfPage = rowsOfPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}

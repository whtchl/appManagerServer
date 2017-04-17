function gotoPage(url){
	document.forms[0].curPage.value=document.forms[0].inputPage.value; 
	document.forms[0].method = "POST"
	document.forms[0].action=url; 
	document.forms[0].submit();
}
function pageUp(curPage,url){
	document.forms[0].curPage.value = curPage - 1;
	document.forms[0].method = "POST"
	document.forms[0].action=url;
	document.forms[0].submit();
}
function pageDown(curPage,url){
	document.forms[0].curPage.value= curPage + 1;
	document.forms[0].method = "POST"
	document.forms[0].action=url;
	document.forms[0].submit();
}
function firstPage(url){
	document.forms[0].curPage.value=1;
	document.forms[0].method = "POST"
	document.forms[0].action=url;
	document.forms[0].submit();
}
function lastpage(totalPage,url){
	document.forms[0].curPage.value = totalPage;
	document.forms[0].method = "POST"
	document.forms[0].action=url; 
	document.forms[0].submit();
}
function changeRecords(url){
	var curRecords = document.all["curRecords"].value;	
	if(curRecords <=0 || curRecords >=100 || isNaN(curRecords)){
		alert("请输入正确记录数,1~100之间的整数!");
		document.all["curRecords"].focus();
		return false;
	}
	document.forms[0].curPage.value=1;
	document.forms[0].action=url; 
	document.forms[0].submit();
}
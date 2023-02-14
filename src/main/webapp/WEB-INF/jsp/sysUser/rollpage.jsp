<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
 		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${pageInfo.total }条记录&nbsp;&nbsp; ${pageInfo.pageNum}/${pageInfo.pages}页</li>
				<c:if test="${pageInfo.hasPreviousPage}">
					<a href="${pageContext.request.contextPath }/sys/user/list/1">首页</a>
					<a href="${pageContext.request.contextPath }/sys/user/list/${pageInfo.pageNum-1}">上一页</a>
				</c:if>
				<c:if test="${pageInfo.hasNextPage}">
					<a href="${pageContext.request.contextPath }/sys/user/list/${pageInfo.pageNum+1 }">下一页</a>
					<a href="${pageContext.request.contextPath }/sys/user/list/${pageInfo.pages}">尾页</a>
				</c:if>
				&nbsp;&nbsp;
			</ul>
		<span class="page-go-form"><label>跳转至</label>
		<input type="text" name="inputPage" id="inputPage" class="page-key" />页
<%--		<input type="text" id="totalPageCount" value="${pageInfo.pages}">--%>
		<button type="button" onclick="gogo(${pageInfo.pages})" class="page-btn">GO</button>
		</span>
		</div> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysRole/rollpage.js"></script>
<script type="text/javascript">
	function gogo(pageCount){
		let inoutPage = document.getElementById("inputPage").value;
		if (inoutPage > pageCount){
			alert("请输入小于总页数的页码");
			return false;
		}else if (inoutPage <= pageCount){
			window.location.href = path+"/sys/user/list/"+inoutPage;
		}
	}
</script>
</html>
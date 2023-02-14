<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>当前位置:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="supplierAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/sys/user/update">
			<input type="hidden" name="id" value="${sysUser.id }"/>
			 <div>
                    <label for="account">账号：</label>
                    <input type="text" readonly name="account" id="account" value="${sysUser.account }">
					<font color="red"></font>
             </div>
            <div>
                <label for="realName">真实姓名：</label>
                <input type="text" name="realName" id="realName" value="${sysUser.realName }">
                <font color="red"></font>
            </div>
			 <div>
                    <label >性别：</label>
                    <select name="sex" id="sex">
						<c:choose>
							<c:when test="${sysUser.sex == 1 }">
								<option value="1" selected="selected">女</option>
					    		<option value="2">男</option>
							</c:when>
							<c:otherwise>
								<option value="1">女</option>
					    		<option value="2" selected="selected">男</option>
							</c:otherwise>
						</c:choose>
					 </select>
             </div>
            <div>
                <label for="birthday">出生日期：</label>
                <input type="text" Class="Wdate" id="birthday" name="birthdayUtil" value="<fmt:formatDate value="${sysUser.birthday }" pattern="yyyy-MM-dd"/>"
                       readonly="readonly" onclick="WdatePicker();">
                <font color="red"></font>
            </div>
			
		       <div>
                    <label for="phone">手机号码：</label>
                    <input type="text" name="phone" id="phone" value="${sysUser.phone }">
                    <font color="red"></font>
               </div>
                <div>
                    <label for="address">地址：</label>
                    <input type="text" name="address" id="address" value="${sysUser.address }">
                </div>
				<div>
                    <label >角色：</label>
                    <!-- 列出所有的角色分类 -->
					<input type="hidden" value="${sysUser.roleId }" id="rid" />
					<select name="roleId" id="roleList">
                        <c:forEach var="sysRole" items="${sysRoleList}">
                            <option value=${sysRole.id}>${sysRole.roleName}</option>
                        </c:forEach>
                    </select>
        			<font color="red"></font>
                </div>
			 <div class="supplierAddBtn">
                    <input type="button" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysUser/update.js"></script>

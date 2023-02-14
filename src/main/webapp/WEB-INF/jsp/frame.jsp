<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/statics/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${userSession.realName }</h2>
<%--            未登录--%>
            <c:if test="${log_msg != null}">
                <p>欢迎来到724便利店管理系统!${log_msg}</p>
            </c:if>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>

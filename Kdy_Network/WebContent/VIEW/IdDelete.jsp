<%@page import="kr.gsm.model.IdDAO"%>
<%@page import="kr.gsm.model.IdDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<script type="text/javascript">
	function alertFn(){
		alert("삭세성공!");
	}
</script>

<jsp:useBean id="dto" class="kr.gsm.model.IdDTO">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
	IdDAO dao = new IdDAO();
	int cnt = dao.idDelete(dto);
	if(dto.getWebid() != null){
		response.sendRedirect("WebIdList.jsp");
	}else if(dto.getGameid() != null){
		response.sendRedirect("GameIdList.jsp");
	}else if(dto.getSnsid() != null){
		response.sendRedirect("SnsIdList.jsp");
	}
%>
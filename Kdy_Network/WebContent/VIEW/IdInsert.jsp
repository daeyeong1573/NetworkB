<%@page import="kr.gsm.model.IdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>


<jsp:useBean id="dto" class="kr.gsm.model.IdDTO">
	<jsp:setProperty name="dto" property="*" />
</jsp:useBean>


<%
IdDAO dao = new IdDAO();
int cnt = dao.idInsert(dto);
if (dto.getWebid() != null) {
	response.sendRedirect("WebIdForm.jsp");
} else if (dto.getGameid() != null) {
	response.sendRedirect("GameIdForm.jsp");
} else if (dto.getSnsid() != null) {
	response.sendRedirect("SnsIdForm.jsp");
}
%>
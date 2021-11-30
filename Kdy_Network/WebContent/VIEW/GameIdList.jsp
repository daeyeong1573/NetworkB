<%@page import="kr.gsm.model.GameDTO"%>
<%@page import="kr.gsm.model.WebDTO"%>
<%@page import="kr.gsm.model.IdDTO"%>
<%@page import="kr.gsm.model.IdDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	IdDAO dao = new IdDAO();
	List<IdDTO> list = dao.idList("Game");
%>
<%@ include file="../Layout/header.jsp"%>

<h2>게임 아이디</h2>

<table border="1" style="background-color: white;">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>플랫폼</td>
		<td>가입일자</td>
	</tr>
	<%
	for (IdDTO dto : list) {		
	%>
	<tr align="center">
		<td><a href="GameIdContent.jsp?gameid=<%=dto.getGameid()%>"><%=dto.getGameid()%></a></td>
		<td><%=dto.getPwd()%></td>
		<td><%=dto.getPlatform()%></td>
		<td colspan="2"><%=dto.getJoindate()%> <input type="button"
				value="삭제" onClick="location='IdDelete.jsp?gameid=<%=dto.getGameid()%>'" /></td>
	</tr>
	<%
	}
	%>

</table>



<%@ include file="../Layout/footer.jsp"%>
<%@page import="kr.gsm.model.IdDAO"%>
<%@page import="kr.gsm.model.IdDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
IdDAO dao = new IdDAO();
List<IdDTO> list = dao.idList("Web");
%>

<script type="text/javascript">
	function deleteFn() {
		alert("삭제성공!");
		document.frm.submit();
	}
</script>

<%@ include file="../Layout/header.jsp"%>

<h2>웹 아이디</h2>

<form name="frm" method="post" action="IdDelete.jsp">
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
			<td><a href="WebIdContent.jsp?webid=<%=dto.getWebid()%>"><%=dto.getWebid()%></a></td>
			<td><%=dto.getPwd()%></td>
			<td><%=dto.getPlatform()%></td>
			<td colspan="2"><%=dto.getJoindate()%> <input type="button"
				value="삭제" onClick="location='IdDelete.jsp?webid=<%=dto.getWebid()%>'" /></td>
		</tr>
		<%
		}
		%>

	</table>
</form>



<%@ include file="../Layout/footer.jsp"%>
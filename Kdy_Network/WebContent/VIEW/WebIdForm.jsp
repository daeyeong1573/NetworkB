<%@page import="kr.gsm.model.IdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	IdDAO dao = new IdDAO();

%>

<script type="text/javascript">
	function insertFn(){
		var id =document.getElementById("webid").value;
		var pwd=document.getElementById("pwd").value;
		var platform=document.getElementById("platform").value;
		var joindate=document.getElementById("joindate").value;
/* 		var kind=document.getElementById("kind").value;
 */		if(id==""){
		alert("아이디가 입력되지 않았습니다");
		document.getElementById("webid").focus();
		return false;
		}
		if(pwd==""){
		alert("비밀번호가 입력되지 않았습니다");
		document.getElementById("pwd").focus();
		return false;
		}
		if(platform==""){
		alert("플랫폼이 입력되지 않았습니다");
		document.getElementById("platform").focus();
		return false;
		}
		if(joindate==""){
		alert("가입일자가 입력되지 않았습니다");
		document.getElementById("joindate").focus();
		return false;
		}
	
		alert("아이디 추가가 완료되었습니다.");
		document.frm.submit();
	}

</script>

<%@ include file="../Layout/header.jsp"%>
<h2>웹 아이디 등록</h2>
<form name="frm" action="IdInsert.jsp" method="post">
	<table border=1 style="background-color: white;">
		<tr>
			<td>아이디</td>
			<td><input type="text" id="webid" name="webid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" id="pwd" name="pwd"></td>
		</tr>
		<tr>
			<td>플랫폼</td>
			<td><input type="text" id="platform" name="platform"></td>
		</tr>

		<tr>
			<td>가입일자</td>
			<td><input type="text" id="joindate" name="joindate"></td>
		</tr>
		<td colspan="2" style="text-align: center;"><input type="button"
			value="등록" onClick="insertFn()"> <input type="button"
			value="조회" onClick="location.href='WebIdList.jsp'"></td>
		</tr>
	</table>

</form>

<%@ include file="../Layout/footer.jsp"%>
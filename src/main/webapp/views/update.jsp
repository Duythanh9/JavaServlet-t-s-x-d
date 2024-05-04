<%--
  Created by IntelliJ IDEA.
  User: Nhu Quynh
  Date: 3/31/2024
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/update" method="post">
    id:<input name="id" value="${detail.id}" type="text">
    Ma:<input name="ma" value="${detail.ma}" type="text">

    Ten: <input name="ten" value="${detail.ten}" type="text">
    Tuoi: <input name="tuoi" value="${detail.tuoi}" type="text">
    Dia chi: <input name="diaChi" value="${detail.diaChi}" type="text">
    Gioi Tinh:<br> Male: <input ${detail.gioiTinh ==true ? "checked":""} name="gioiTinh"  value="true" type="radio">
    Fermale: <input  ${detail.gioiTinh == false ?"checked":""} name="gioiTinh"  value="false" type="radio">
    Lop id: <input name="lopId" value="${detail.lopId}" type="text">
    <button type="submit">Update</button>
</form>

</body>
</html>

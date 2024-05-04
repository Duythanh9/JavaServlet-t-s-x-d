<%--
  Created by IntelliJ IDEA.
  User: Nhu Quynh
  Date: 3/30/2024
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/add" method="post">
    Ma:<input name="ma" value="${detail.ma}" type="text">
    Ten: <input name="ten" value="${detail.ten}" type="text">
    Tuoi: <input name="tuoi" value="${detail.tuoi}" type="text">
    Dia chi: <input name="diaChi" value="${detail.diaChi}" type="text">
    Gioi Tinh:<br> Male: <input name="gioiTinh" ${detail.gioiTinh == true ? "checked":""}  value="true" type="radio">
    Fermale: <input name="gioiTinh"  value="false" ${detail.gioiTinh == false ? "checked":""}   type="radio">
    Lop id: <input name="lopId" value="${detail.lopId}" type="text">
    <button type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Dia Chi</th>
        <th>Gioi Tinh</th>
        <th>Lop id</th>
        <th>
            Action
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${key}" var="sv" varStatus="i">
        <tr>

            <td>${sv.id}</td>
            <td>${sv.ma}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.gioiTinh ? "Nam" : "Nu"}</td>
            <td>${sv.lopId}</td>
            <td>
                <a href="/sinh-vien/view-update?id=${sv.id}">Update</a>
                <a href="/sinh-vien/detail?viTri=${sv.id}">Detail</a>
                <a href="/sinh-vien/delete?viTri=${sv.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

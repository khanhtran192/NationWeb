<%--
  Created by IntelliJ IDEA.
  User: tranduykhanh
  Date: 16/10/2021
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List regiones</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Nation</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                    <a class="nav-link" href="/region/list">Regiones</a>
                    <a class="nav-link" href="/countries/list">Countries</a>
                </div>
            </div>
        </div>
    </nav>
</head>
<body>
<div class="row">
    <div class="container">
        <h3 class="text-center">LIST REGIONES</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Thêm region</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Continent ID</th>
                <th>Điều chỉnh</th>
            </tr>
            </thead>
            <body>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="region" items="${listRegion}">

                <tr>
                    <td>
                        <c:out value="${region.regionID}" />
                    </td>
                    <td>
                        <c:out value="${region.name}" />
                    </td>
                    <td>
                        <c:out value="${region.continentID}" />
                    </td>
                    <td><a href="edit?id=<c:out value='${region.regionID}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${region.regionID}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </body>

        </table>
    </div>
</div>


</body>
</html>

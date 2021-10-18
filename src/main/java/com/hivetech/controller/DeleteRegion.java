package com.hivetech.controller;


import com.hivetech.jdbc.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/region/delete")
public class DeleteRegion extends HttpServlet {
    private DBUtil dbUtil;

    @Override
    public void init() {
        dbUtil = new DBUtil();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            dbUtil.deleteRegion(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("list");
    }
}

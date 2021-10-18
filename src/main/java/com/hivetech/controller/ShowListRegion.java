package com.hivetech.controller;

import com.hivetech.jdbc.DBUtil;
import com.hivetech.model.Region;
import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/region/list")
public class ShowListRegion extends HttpServlet {
    private DBUtil dbUtil;

    @Override
    public void init(){
        dbUtil = new DBUtil();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Region> list = dbUtil.selectAll();
        request.setAttribute("listRegion", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/listRegion.jsp");
        dispatcher.forward(request, response);
    }


}

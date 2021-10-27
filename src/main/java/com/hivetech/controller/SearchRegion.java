package com.hivetech.controller;

import com.hivetech.jdbc.DBUtil;
import com.hivetech.model.Region;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/region/search")
public class SearchRegion extends HttpServlet {

    private DBUtil dbUtil;

    @Override
    public void init(){
        dbUtil = new DBUtil();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namesearch = req.getParameter("name");
        List<Region> list =  dbUtil.searchRegion(namesearch);
        req.setAttribute("listRegion", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/listPagination.jsp");
        dispatcher.forward(req, resp);

    }

}

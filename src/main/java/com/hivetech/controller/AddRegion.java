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

@WebServlet("/region/new")
public class AddRegion extends HttpServlet {

    private DBUtil dbUtil;

    @Override
    public void init(){
        dbUtil = new DBUtil();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int regionID = Integer.parseInt(req.getParameter("regionID"));
//        String name = req.getParameter("name");
//        int continentID = Integer.parseInt(req.getParameter("continentID"));
//        Region regionadd = new Region(regionID, name, continentID);

        Region newRegion = new Region();
//        newRegion.setRegionID(Integer.parseInt(req.getParameter("regionID")));
        newRegion.setName(req.getParameter("name"));
        newRegion.setContinentID(Integer.parseInt(req.getParameter("continentID")));
        dbUtil.insertRegion(newRegion);

        resp.sendRedirect("/region/listpagination?page=1");

    }
}

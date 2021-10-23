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


@WebServlet("/region/listpagination")
public class ShowPagination extends HttpServlet {

    private DBUtil dbUtil;

    @Override
    public void init(){
        dbUtil = new DBUtil();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int pageid= Integer.parseInt(request.getParameter("page"));
        int total=5;
        if(pageid==1){}
        else{
            pageid=pageid-1;
            pageid=pageid*total+1;
        }
        List<Region> list = dbUtil.showPag(pageid,total);
        request.setAttribute("listRegion", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/listPagination.jsp");
        dispatcher.forward(request, response);

    }


}



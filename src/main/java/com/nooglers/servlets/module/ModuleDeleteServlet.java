package com.nooglers.servlets.module;

import com.nooglers.dao.ModuleDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( name = "ModuleDeleteServlet", value = "/deleteModule" )
public class ModuleDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/module/delete.jsp");
//        requestDispatcher.forward(request , response);

        Integer id = Integer.valueOf(request.getParameter("mid"));
        System.out.println(" module deleted id = " + id);
        ModuleDao dao = ModuleDao.getInstance();
        dao.deleteById(id);
        response.sendRedirect("/listModule");
    }

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        response.sendError(405 , "Method not allowed");
    }
}

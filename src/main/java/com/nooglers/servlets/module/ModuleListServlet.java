package com.nooglers.servlets.module;

import com.nooglers.dao.ModuleDao;
import com.nooglers.domains.Module;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet( name = "ModuleListServlet", value = "/listModule" )
public class ModuleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        ModuleDao moduleDao = ModuleDao.getInstance();

        final Integer userId = ( Integer ) request.getSession().getAttribute("user_id");
        final List<Module> modules = moduleDao.getAll(userId);
        request.setAttribute("modules" , modules);

        System.out.println("moduleDao.getAll() = " + modules);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/module/list.jsp");
        requestDispatcher.forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        response.sendError(405 , "Method Not Supported");
    }
}

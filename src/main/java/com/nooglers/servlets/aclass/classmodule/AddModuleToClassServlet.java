package com.nooglers.servlets.aclass.classmodule;

import com.nooglers.services.ClassService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddModuleToClassServlet", value = "/class/module/add")
public class AddModuleToClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer groupId = Integer.valueOf(request.getParameter("groupId"));
        Integer moduleId = Integer.valueOf(request.getParameter("moduleId"));
        ClassService classService = ClassService.getInstance();
        classService.addClassModule(groupId, moduleId);
        response.sendRedirect("/class/module/get?groupId=" + groupId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer groupId = Integer.valueOf(request.getParameter("groupId"));
        Integer moduleId = Integer.valueOf(request.getParameter("moduleId"));
        ClassService classService = ClassService.getInstance();
        classService.addClassModule(groupId, moduleId);
        response.sendRedirect("/class/module/get?groupId=" + groupId);
    }
}

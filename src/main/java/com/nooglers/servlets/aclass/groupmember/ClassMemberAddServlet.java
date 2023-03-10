package com.nooglers.servlets.aclass.groupmember;

import com.nooglers.services.ClassService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ClassMemberAddServlet", value = "/group/member/add")
public class ClassMemberAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ClassDao classDao = ClassDao.getInstance();
//        UserDao userDao = UserDao.getInstance();
        final ClassService classService = ClassService.getInstance();


        Integer userId = Integer.valueOf(request.getParameter("userId"));
        Integer groupId = Integer.valueOf(request.getParameter("groupId"));

        classService.addUser(userId,groupId);

        response.sendRedirect("/group");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


    }
}

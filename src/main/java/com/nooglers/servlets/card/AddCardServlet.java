package com.nooglers.servlets.card;

import com.nooglers.dao.CardDao;
import com.nooglers.dao.ModuleDao;
import com.nooglers.domains.Card;
import com.nooglers.domains.Module;
import com.nooglers.dto.SendMessageDto;
import com.nooglers.services.ModuleService;
import com.nooglers.services.QuizService;
import com.nooglers.services.userprogress.UserProgressService;
import com.nooglers.utils.MessageUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddCardServlet", urlPatterns = "/addcard")
@MultipartConfig(location = "/home/baxtigul/apps/library/upload")
public class AddCardServlet extends HttpServlet {


    QuizService quizService = QuizService.getInstance();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer moduleId = Integer.valueOf(request.getParameter("mid"));
        final Integer userId = (Integer) request.getSession().getAttribute("user_id");

        if (!quizService.doesUserHaveAccessToThisModule(moduleId, userId)) {
            MessageUtil.setMessage(request, new SendMessageDto("Opps!", "This module does not belong to you", "study sets", "/listModule"));
            request.getRequestDispatcher("/utils/error.jsp").forward(request, response);
        } else {
            request.setAttribute("moduleid", moduleId);
            /** test uchun 1 qiyati berilgan, tepadagi qator commentdan olinishi kk */

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/card/add.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModuleDao moduleDao = ModuleDao.getInstance();
        final ModuleService moduleService = ModuleService.getInstance();
        final UserProgressService userProgressService = UserProgressService.getInstance();
        String term = request.getParameter("term");
        String description = request.getParameter("description");
        Integer moduleid = Integer.valueOf(request.getParameter("moduleid"));
        final Integer userId = (Integer) request.getSession().getAttribute("user_id");
        Card card;
        final Module moduleById = moduleDao.findById(moduleid);
        card = Card.builder().title(term)
                .module(moduleById)
                .description(description).build();
        final CardDao cardDao = CardDao.getInstance();
        cardDao.save(card);
        final Module module = moduleService.getById(moduleid);
        moduleService.updateLastSeend(module);


        response.sendRedirect("/getModule?mid=" + moduleid);

    }

}

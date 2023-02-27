package com.nooglers.servlets.folder;

import com.nooglers.dao.ModuleDao;
import com.nooglers.domains.Module;
import com.nooglers.utils.Validators;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( name = "AddModuleToFolderServlet", value = "/appendModule" )
public class AddModuleToFolderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

        final String fid = request.getParameter("fid");
        final String mid = request.getParameter("mid");

        if ( Validators.checkForNullOrBlank(fid) && Validators.checkForNullOrBlank(mid) ) {
            final ModuleDao moduleDao = ModuleDao.getInstance();
            final Module byId = moduleDao.findById(Integer.valueOf(mid));
            moduleDao.save(byId , fid);
            request.getRequestDispatcher("/setModule?fid=" + fid).forward(request , response);
        }
    }


}

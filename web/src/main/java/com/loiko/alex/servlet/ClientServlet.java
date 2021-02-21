package com.loiko.alex.servlet;

import com.loiko.alex.client.Client;
import com.loiko.alex.service.ClientService;
import com.loiko.alex.util.JSPPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client defaultClient = ClientService.getInstance().getDefaultClient();
        req.setAttribute("client", defaultClient);
        getServletContext()
                .getRequestDispatcher(JSPPathUtil.get("client"))
                .forward(req, resp);
    }
}
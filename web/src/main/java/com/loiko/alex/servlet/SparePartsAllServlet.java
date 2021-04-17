package com.loiko.alex.servlet;

import com.loiko.alex.country.Country;
import com.loiko.alex.service.SparePartService;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.util.ContextUtil;
import com.loiko.alex.util.JSPPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/all-spareparts")
public class SparePartsAllServlet extends HttpServlet {

    private static final SparePartService SPARE_PART_SERVICE =
            ContextUtil.getBean("sparePartService", SparePartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SparePart> spareParts = SPARE_PART_SERVICE.findAll();
        List<Country> countries = Arrays.asList(Country.values());
        req.setAttribute("spareparts", spareParts);
        req.setAttribute("countries", countries);
        getServletContext().getRequestDispatcher(JSPPathUtil.getPath("spareparts")).forward(req, resp);
    }
}
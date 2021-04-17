package com.loiko.alex.servlet;

import com.loiko.alex.country.Country;
import com.loiko.alex.service.SparePartService;
import com.loiko.alex.sparepart.LimitOffSetDto;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePartFilterDto;
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

@WebServlet("/spareparts-filter")
public class SparePartsFiltersServlet extends HttpServlet {

    private static final String FILTERS = "filters";
    private static final String ITEMS_ON_PAGE = "items_on_page";
    private static final SparePartService SPARE_PART_SERVICE =
            ContextUtil.getBean("sparePartService", SparePartService.class);
    private static final String PAGE = "page";
    private static final String PRICE = "price";
    private static final String SPARE_PART_NAME = "sparePartName";
    private static final String COUNTRY = "country";
    private static final String FILTERED_SPAREPARTS = "filteredSpareparts";
    private static final String PAGES_NUMBER = "pagesNumber";
    private static final String CURRENT_PAGE = "currentPage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SparePartFilterDto filters = SparePartFilterDto.builder().build();
        LimitOffSetDto limitOffset = LimitOffSetDto.of(0, 0);
        List<SparePart> filteredGames;
        int pagesNumber = 0;
        int currentPage = 0;
        Integer limit = null;
        if (req.getSession().getAttribute(ITEMS_ON_PAGE) != null) {
            limit = Integer.valueOf((String) req.getSession().getAttribute(ITEMS_ON_PAGE));
        }
        if (req.getSession().getAttribute(FILTERS) != null) {
            filters = (SparePartFilterDto) req.getSession().getAttribute(FILTERS);
        }
        if (limit != null) {
            List<SparePart> allFilteredGames = SPARE_PART_SERVICE.filterSpareParts(filters, limitOffset);
            pagesNumber = (int) Math.ceil(allFilteredGames.size() / Double.valueOf((String) req.getSession().getAttribute(ITEMS_ON_PAGE)));
            String page = req.getParameter(PAGE);
            if (page == null) {
                limitOffset = LimitOffSetDto.of(limit, 0);
                currentPage = 1;
            } else {
                Integer offset = limit * (Integer.valueOf(page) - 1);
                limitOffset = LimitOffSetDto.of(limit, offset);
                currentPage = Integer.valueOf(page);
            }
        }
        filteredGames = SPARE_PART_SERVICE.filterSpareParts(filters, limitOffset);
        req.setAttribute(FILTERED_SPAREPARTS, filteredGames);
        req.setAttribute(PAGES_NUMBER, pagesNumber);
        req.setAttribute(CURRENT_PAGE, currentPage);
        getServletContext().getRequestDispatcher(JSPPathUtil.getPath("spareparts-filter")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SparePartFilterDto filters = SparePartFilterDto.builder().build();
        if (req.getParameterValues(FILTERS) != null) {
            Arrays.stream(req.getParameterValues(FILTERS))
                    .filter(PRICE::equals)
                    .findFirst()
                    .ifPresent(x -> filters.setPrice(Double.valueOf(req.getParameter(x))));
            Arrays.stream(req.getParameterValues(FILTERS))
                    .filter(SPARE_PART_NAME::equals)
                    .findFirst()
                    .ifPresent(x -> filters.setSparePartName(String.valueOf(req.getParameter(x))));
            Arrays.stream(req.getParameterValues(FILTERS))
                    .filter(COUNTRY::equals)
                    .findFirst()
                    .ifPresent(x -> filters.setCountry(Country.valueOf(x)));
            req.getSession().setAttribute(FILTERS, filters);
        }
        if (!"".equals(req.getParameter(ITEMS_ON_PAGE))) {
            req.getSession().setAttribute(ITEMS_ON_PAGE, req.getParameter(ITEMS_ON_PAGE));
        }
        resp.sendRedirect("/spareparts-filter");
    }
}
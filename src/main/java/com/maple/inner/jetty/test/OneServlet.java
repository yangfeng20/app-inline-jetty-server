package com.maple.inner.jetty.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author yangfeng
 * @date : 2023/12/5 9:25
 * desc:
 */

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        req.setAttribute("list", list);

        // 转发到指定的jsp页面
        req.getRequestDispatcher(page).forward(req, resp);
    }
}

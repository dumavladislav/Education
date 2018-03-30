package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllRequestsServlet extends HttpServlet {

    public AllRequestsServlet(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("Hey there");

        Map<String, Object> pageVariables = createPageVariablesMap(req);
        pageVariables.put("message", "");

        resp.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(req);

        String message = req.getParameter("message");

        if(message ==  null || message.isEmpty())   resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        else    resp.setStatus(HttpServletResponse.SC_OK);

        pageVariables.put("message", message == null ? "" : message);
        resp.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest req){
        Map<String, Object> pageVariables = new HashMap<String, Object>();

        pageVariables.put("method", req.getMethod());
        pageVariables.put("URL", req.getRequestURL().toString());
        pageVariables.put("pathInfo", req.getPathInfo());
        pageVariables.put("sessionId", req.getSession().getId());
        pageVariables.put("parameters", req.getParameterMap().toString());
        return pageVariables;
    }


}

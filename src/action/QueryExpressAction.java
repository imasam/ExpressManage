package action;

import dao.Dao;
import dao.entities.ExpressInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class QueryExpressAction {
    private String expressNo;

    public String execute() throws Exception{
        boolean succeed = false;

        ExpressInfo express = Dao.instance().queryExpress(expressNo);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(express == null) {
            out.print("<script>alert('不存在对应快递'); " +
                    "window.location='queryExpress.jsp' </script>");

            out.flush();
            out.close();
            return null;
        }
        else
            return "success";
    }

    public String getExpressNo() { return expressNo; }

    public void setExpressNo(String expressNo) { this.expressNo = expressNo; }
}

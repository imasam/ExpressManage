package action;

import dao.Dao;
import dao.entities.ExpressInfo;
import dao.entities.RouteInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QueryExpressAction {
    private String expressNo;

    public String execute() throws Exception{
        boolean succeed = false;

        ArrayList<RouteInfo> rInfo = Dao.instance().queryExpress(expressNo);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(rInfo.size() == 0) {
            out.print("<script>alert('物流信息不存在'); " +
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

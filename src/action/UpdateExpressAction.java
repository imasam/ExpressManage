package action;

import dao.Dao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class UpdateExpressAction {
    private String expressNo;
    private Timestamp time;
    private String info;

    public String execute() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("content-type","text/html;charset=UTF-8");

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // 更新物流并返回结果
        if(Dao.instance().updateRoute(expressNo,info,time)) {
            out.print("<script language='javascript'>alert('更新物流信息成功');" +
                    " window.location='./index.jsp';</script>");
        }
        else {
            out.print("<script language='javascript'>alert('更新物流信息失败');" +
                    " window.location='./index.jsp';</script>");
        }

        out.flush();
        out.close();
        return null;
    }

    public String getExpressNo() { return expressNo; }

    public void setExpressNo(String expressNo) { this.expressNo = expressNo; }

    public Timestamp getTime() { return time; }

    public void setTime(Timestamp time) { this.time = time; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }
}

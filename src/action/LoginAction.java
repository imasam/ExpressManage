package action;

import com.opensymphony.xwork2.ActionContext;
import dao.Dao;
import org.apache.struts2.ServletActionContext;
import org.hibernate.*;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;
import sun.font.Script;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class LoginAction {
    private String account;
    private String password;
    private String loginType;

    public String execute() throws Exception{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(!Dao.instance().login(loginType,account,password)) {
            out.print("<script>alert('请输入正确有效的账号密码'); " +
                    "window.location='login.jsp' </script>");
            out.flush();
            out.close();
            return null;
        }

        // 保存Cookie
        Cookie cookie = new Cookie("loginType",loginType);
        cookie.setMaxAge(600);
        response.addCookie(cookie);
        cookie = new Cookie("account",account);
        cookie.setMaxAge(600);
        response.addCookie(cookie);
        cookie = new Cookie("password",password);
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        // 保存Session
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.put("loginType",loginType);
        session.put("account",account);

        return "success";
    }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getLoginType() { return loginType; }

    public void setLoginType(String loginType) { this.loginType = loginType; }
}

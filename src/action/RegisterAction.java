package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.Dao;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RegisterAction extends ActionSupport {
    private String loginType;
    private String account;
    private String password;
    private String name;
    private String city;
    private String tel;

    public String execute() throws Exception{
        boolean succeed = false;
        if(loginType.equals("user")){
            succeed = Dao.instance().addUser(account,password);
        }
        else if(loginType.equals("courier")){
            succeed = Dao.instance().addCourier(account,password,name,city,tel);
        }

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(succeed) {
            out.print("<script>alert('注册成功'); " +
                    "window.location='login.jsp' </script>");
        }
        else {
            out.print("<script>alert('注册失败'); " +
                    "window.location='register.jsp' </script>");
        }
        out.flush();
        out.close();

        return null;
    }

    public void validate(){
        if(loginType.equals("user")) {
            if (account.length() == 0 || password.length() == 0)
                this.addFieldError("no input", "*信息必须填写");
        }
        else if(loginType.equals("courier")){
            if(account.length() == 0 || password.length() == 0
                    || name.length() == 0 || city.length() == 0 || tel.length() == 0)
                this.addFieldError("no input", "*信息必须填写");
        }
    }

    public String getLoginType() { return loginType; }

    public void setLoginType(String loginType) { this.loginType = loginType; }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }
}

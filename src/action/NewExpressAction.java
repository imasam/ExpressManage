package action;

import dao.Dao;
import dao.entities.CourierInfo;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class NewExpressAction {
    private String fromName;
    private String fromTel;
    private String fromCity;
    private String fromAddr;
    private String fromAccount;

    private String toName;
    private String toTel;
    private String toCity;
    private String toAddr;
    //private String courierAccount;

    public String execute() throws Exception{
        boolean succeed = false;

        // 详细地址
        String fromArea = fromCity + " " + fromAddr;
        String toArea = toCity + " " + toAddr;
        // 随机生成单号
        String expressNo = "0123" + fromAccount;
        // 随机指派快递员
        List<CourierInfo> couriers = Dao.instance().getCouriers(fromCity);
        int choice = 1;

        succeed = Dao.instance().addExpress(expressNo,
                fromName,fromTel,fromArea,fromAccount,
                toName,toTel,toArea,
                couriers.get(choice).getAccount());

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(succeed) {
            out.print("<script>alert('寄件成功'); " +
                    "window.location='login.jsp' </script>");
        }
        /*
        else {
            out.print("<script>alert('注册失败'); " +
                    "window.location='register.jsp' </script>");
        }
        */
        out.flush();
        out.close();

        return null;
    }


    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromTel() {
        return fromTel;
    }

    public void setFromTel(String fromTel) {
        this.fromTel = fromTel;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(String fromAddr) {
        this.fromAddr = fromAddr;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToTel() {
        return toTel;
    }

    public void setToTel(String toTel) {
        this.toTel = toTel;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToAddr() {
        return toAddr;
    }

    public void setToAddr(String toAddr) {
        this.toAddr = toAddr;
    }

    /*
    public String getCourierAccount() {
        return courierAccount;
    }

    public void setCourierAccount(String courierAccount) {
        this.courierAccount = courierAccount;
    }
    */
}

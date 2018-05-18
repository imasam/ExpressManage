package dao;

import dao.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.security.auth.login.Configuration;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dao {
    private static Dao instance;

    static {
        instance = new Dao();
    }

    public static Dao instance()
    {
        return instance;
    }

    /*
     * 验证登录
     */
    public boolean login(String _loginType,String _account,String _pwd){
        if(_account.equals("")||_pwd.equals(""))
            return false;

        Session session = HibernateSessionFactory.getSession();
        String realPwd = "";

        if(_loginType.equals("user")){
            UserInfo usr =  session.get(UserInfo.class,_account);
            if(usr != null)
                realPwd = usr.getPassword();
        }
        else if(_loginType.equals("courier")){
            CourierInfo courier =  session.get(CourierInfo.class,_account);
            if (courier != null)
                realPwd = courier.getPassword();
        }

        session.close();
        return realPwd.equals(_pwd);
    }

    /*
     * 获得省份列表
     */
    public List<String> getProvinces(){
        List<String> provinces = new ArrayList<>();

        Session session = HibernateSessionFactory.getSession();
        String hql = "from Province";
        Query query = session.createQuery(hql);
        List list = query.list();

        for(int i = 0;i<list.size();i++){
            Province province = (Province)list.get(i);
            provinces.add(province.getProvince());
        }

        session.close();
        return provinces;
    }

    /*
     * 获得城市-省份列表
     */
    public Map<String,List<String >> getCities(){
        Map<String,List<String>> cityMap = new HashMap<>();

        Session session = HibernateSessionFactory.getSession();
        String hql = "from City";
        Query query = session.createQuery(hql);
        List list = query.list();

        for(int i = 0;i<list.size();i++){
            City city = (City)list.get(i);

            if(cityMap.get(city.getProvince()) == null)
                cityMap.put(city.getProvince(),new ArrayList<>());

            cityMap.get(city.getProvince()).add(city.getCity());
        }

        session.close();
        return cityMap;
    }

    /*
     * 添加用户
     */
    public boolean addUser(String _account,String _password){
        Session session = HibernateSessionFactory.getSession();

        // 判断是否存在同名账号
        if(session.get(UserInfo.class,_account) != null)
            return false;

        UserInfo usr = new UserInfo();
        usr.setAccount(_account);
        usr.setPassword(_password);

        Transaction tran = session.beginTransaction();
        session.save(usr);
        tran.commit();

        session.close();
        return true;
    }

    /*
     * 添加快递员
     */
    public boolean addCourier(String _account,String _password,
                              String _name,String _city,String _tel){
        Session session = HibernateSessionFactory.getSession();

        // 判断是否存在同名账号
        if(session.get(CourierInfo.class,_account) != null)
            return false;

        CourierInfo  courier = new CourierInfo();
        courier.setAccount(_account);
        courier.setPassword(_password);
        courier.setName(_name);
        courier.setCity(_city);
        courier.setTel(_tel);

        Transaction tran = session.beginTransaction();
        session.save(courier);
        tran.commit();

        session.close();
        return true;
    }

    /*
     * 添加快递信息
     */
    public boolean addExpress(String _expressNo,
                              String _fromName,String _fromTel,String _fromArea,String _fromAccount,
                              String _toName, String _toTel, String _toArea,
                              String _courierAccount) {
        Session session = HibernateSessionFactory.getSession();

        /*
        // 判断是否存在同单号快递
        if(session.get(CourierInfo.class,_expressNo) != null)
            return false;
        */

        ExpressInfo express = new ExpressInfo();
        express.setExpressNo(_expressNo);
        express.setFromName(_fromName);
        express.setFromTel(_fromTel);
        express.setFromArea(_fromArea);
        express.setFromAccount(_fromAccount);
        express.setToName(_toName);
        express.setToTel(_toTel);
        express.setToArea(_toArea);
        express.setCourierAccount(_courierAccount);

        Transaction tran = session.beginTransaction();
        session.save(express);
        tran.commit();

        session.close();
        return true;
    }

    /*
     * 查找指定城市的快递员
     */
    public List<CourierInfo> getCouriers(String _city){
        List<CourierInfo> couriers = new ArrayList<>();

        Session session = HibernateSessionFactory.getSession();
        String hql = "from CourierInfo where city =?";
        Query query = session.createQuery(hql);
        query.setString(0,_city);
        List list = query.list();

        for(int i = 0;i < list.size();i++){
            CourierInfo courier = (CourierInfo) list.get(i);
            couriers.add(courier);
        }

        session.close();
        return couriers;
    }


    /*
     * 查找指定快递员的所有快递
     */
    public ArrayList<ExpressInfo> getCourierExpresses(String _courierAccount){
        ArrayList<ExpressInfo> courierExpresses = new ArrayList<>();

        Session session = HibernateSessionFactory.getSession();
        String hql = "from ExpressInfo where courierAccount = ?";
        Query query = session.createQuery(hql);
        query.setString(0,_courierAccount);
        List list = query.list();

        for(int i = 0;i < list.size();i++){
            ExpressInfo express = (ExpressInfo) list.get(i);
            courierExpresses.add(express);
        }

        session.close();
        return courierExpresses;
    }

    /*
     * 查找指定用户的所有快递
     */
    public ArrayList<ExpressInfo> getUserExpresses(String _userAccount){
        ArrayList<ExpressInfo> userExpresses = new ArrayList<>();

        Session session = HibernateSessionFactory.getSession();
        String hql = "from ExpressInfo where fromAccount = ? ";
        Query query = session.createQuery(hql);
        query.setString(0,_userAccount);
        List list = query.list();

        for(int i = 0;i < list.size();i++){
            ExpressInfo express = (ExpressInfo) list.get(i);
            userExpresses.add(express);
        }

        session.close();
        return userExpresses;
    }

    /*
     * 查找指定单号的物流信息
     */
    public ArrayList<RouteInfo> queryExpress(String _expressNo){
        ArrayList<RouteInfo> rts = new ArrayList<>();

        Session session = HibernateSessionFactory.getSession();
        String hql = "from RouteInfo where expressNo = ? order by time";
        Query query = session.createQuery(hql);
        query.setString(0,_expressNo);
        List list = query.list();

        for(int i = 0;i < list.size();i++) {
            rts.add((RouteInfo) list.get(i));
        }
        session.close();
        return rts;
    }

    /*
     * 更新物流信息
     */
    public boolean updateRoute(String _expressNo,String _info,Timestamp _time) {
        Session session = HibernateSessionFactory.getSession();

        RouteInfo rt = new RouteInfo();
        rt.setExpressNo(_expressNo);
        rt.setInfo(_info);
        rt.setTime(_time);

        Transaction tran = session.beginTransaction();

        try {
            session.saveOrUpdate(rt);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

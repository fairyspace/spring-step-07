package bean;

import io.github.fairyspace.beans.factory.DisposableBean;
import io.github.fairyspace.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId)+"company="+company+"location="+location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("执行：UserService.afterPropertiesSet");
    }


}

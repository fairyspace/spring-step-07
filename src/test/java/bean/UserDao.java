package bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();


    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "AAAA");
        hashMap.put("10002", "BBBB");
        hashMap.put("10003", "CCCC");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }


}

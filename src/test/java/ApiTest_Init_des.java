import bean.UserDao;
import bean.UserService;
import io.github.fairyspace.beans.PropertyValue;
import io.github.fairyspace.beans.PropertyValues;
import io.github.fairyspace.beans.core.io.DefaultResourceLoader;
import io.github.fairyspace.beans.factory.config.BeanDefinition;
import io.github.fairyspace.beans.factory.config.BeanReference;
import io.github.fairyspace.beans.factory.support.DefaultListableBeanFactory;
import io.github.fairyspace.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

public class ApiTest_Init_des {
   @Test
    public void test(){
      // 1.初始化 BeanFactory
      DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

      // 2. UserDao 注册
      beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

      // 3. UserService 设置属性[uId、userDao]
      PropertyValues propertyValues = new PropertyValues();
      propertyValues.addPropertyValue(new PropertyValue("uId", "10002"));
      propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

      // 4. UserService 注入bean
      BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
      beanFactory.registerBeanDefinition("userService", beanDefinition);

      // 5. UserService 获取bean
      UserService userService = (UserService) beanFactory.getBean("userService");
      userService.queryUserInfo();

   }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}

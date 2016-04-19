package unit;

import cave.entity.User;
import cave.server.UserServer;
import cave.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Jeor on 2016/4/18.
 */
@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServer {
    @Resource
    private UserServer userServer;
    @Test
    public void testServer()throws Exception{
        System.out.println("testServer start.");
        System.out.println(userServer);
        User user=this.userServer.findById(User.class,3);
        System.out.println("user:"+user.getName());

        Page page=new Page<User>();
        this.userServer.findByObjectPage(User.class,page);
        System.out.println(page.getResult());
    }
}
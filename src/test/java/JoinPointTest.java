import com.hh.controller.UserController;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import sun.util.logging.resources.logging;

/**
 * Created by Administrator on 15-10-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring.xml","classpath:spring/spring-mvc.xml","classpath:spring/spring-mybatis.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class JoinPointTest {
    Logger logger = Logger.getLogger(JoinPointTest.class);
    @Autowired
    private UserController userController;
    private MockMvc mockMvc;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    @Before
    public void init(){
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void test(){
        logger.error("--------调用方法一");
        request.setParameter("id","1");
        userController.getUserById(request,response);
        logger.error("--------调用方法二");
        userController.getUserById(1);
        logger.error("--------调用方法三");
        userController.getUserById(1,"haha");
    }
}

import com.hh.controller.UserController;
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
import org.springframework.web.context.WebApplicationContext;

/*注意这里使用static*/
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
/**
 * Created by Administrator on 15-9-30.
 * 注意必须见log4j的配置文件放在resources文件的第一层，否则test启动将会报错
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring.xml","classpath:spring/spring-mvc.xml","classpath:spring/spring-mybatis.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class GetUserTest {
    //第一种测试方法
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void init(){
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void getAllUser() throws Exception{
        mockMvc.perform(post("/userController/getAllUsre.do"));
    }

   /* 第二种测试方法
   private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    @Before
    public void setUp(){
        request =  new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Autowired
    private UserController userController;
    @Test
    public void test() throws Exception{
       *//* 传递参数的方法
       request.setParameter("name", "tom");
        System.out.println(logging.tt(request, response));*//*
        userController.getAllUser();


    }
*/

}

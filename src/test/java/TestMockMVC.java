import com.kkb.ssm.controller.ItemController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebAppConfiguration:可以在单元测试的时候，不用启动Servlet容器，就可以获取一个Web应用上下文
//以前的思路：tomcat启动之后，创建Servlet对象、创建ServletContext对象--->创建spring容器(WebApplicationContext)--->spring容器存储到ServletContext对象中
@RunWith(SpringJUnit4ClassRunner.class)
//需要所有的配置文件
@ContextConfiguration(locations = {"classpath:spring/spring-mvc.xml","classpath:spring/applicationContext-*.xml"})
@WebAppConfiguration
public class TestMockMVC {
    // 自动获取由@WebAppConfiguration产生的web应用上下文
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private ItemController itemController;

    @Before
    public void setUp(){
        // MockMvcBuilders -- MockMvcBuilder -- > MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/item/findItem"))
                .andExpect(MockMvcResultMatchers.view().name("success"));
    }

    @Test
    public void test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/json/responsePojo"))
                .andExpect(jsonPath("$.username").value("haiya"));
    }

    @Test
    public void test3() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/json/responsePojo")).andExpect(status().isOk())
                .andExpect(jsonPath("$.sex").value("女"))
                .andDo(print()).andReturn();
        Object obj = mvcResult.getHandler();
        System.out.println(obj);
    }
}

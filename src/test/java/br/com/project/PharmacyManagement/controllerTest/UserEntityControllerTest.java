package br.com.project.PharmacyManagement.controllerTest;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
public class UserEntityControllerTest {

    private URI path;
    private MockHttpServletRequest mockHttpServletRequest;
    private ResultMatcher expectedResult;

    @Autowired
    private MockMvc mock;

    private String token;

    @Before
    public void setUp() throws Exception {
        String json = "{\"email\":\"edu@rdo\",\"password\":\"1234\"}";

        path = new URI ("/usuario/login");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path).contentType(MediaType.APPLICATION_JSON).content(json);

        expectedResult = MockMvcResultMatchers.status().isOk();

        String response = mock.perform(request).andExpect(expectedResult).andReturn().getResponse().getContentAsString();

        JSONObject data = new JSONObject(response);

        token = data.getString("Authorization");
    }

    @Test
    public void registerUserTest() throws Exception{
        String jsonRegister = "{\"email\":\"edu@rdo\",\"password\":\"1234\",\"roles\":[{\"roleName\":\"ROLE_ADMINISTRATOR\"}]}";

        path = new URI("/usuario/cadastro");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonRegister)
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void authenticateUserTest() throws Exception {
        String jsonAuthenticate = "{\"email\":\"edu@rdo\",\"password\":\"1234\"}";

        path = new URI("/usuario/login");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonAuthenticate)
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }
}

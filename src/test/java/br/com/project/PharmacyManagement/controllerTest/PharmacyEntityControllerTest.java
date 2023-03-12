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
public class PharmacyEntityControllerTest {

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
    public void createPharmacyTest() throws Exception{
        String jsonRegister = "{\"corporateName\":\"Clamed\",\"cnpj\":\"84.683.481/0001-77\",\"tradeName\":\"CATARINENSE\",\"email\":\"c@pp.com\",\"phone\":\"(47)3030-3030\",\"cellphone\":\"(47)98899-5544\",\"address\":{\"cep\":\"89201400\",\"number\":638,\"addressCompl\":\"Aolado\",\"latitude\":-42.00000,\"longitude\":-27.0000}}";

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonRegister)
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);
    }


    @Test
    public void UpdatePharmacyByIdTest() throws Exception {
        String jsonUpdate = "{\"corporateName\":\"Clamed\",\"cnpj\":\"84.683.481/0001-77\",\"tradeName\":\"FORMULA\",\"email\":\"c@pp.com\",\"phone\":\"(47)3030-3030\",\"cellphone\":\"(47)98899-5544\",\"address\":{\"cep\":\"89201400\",\"logradouro\":\"\",\"number\":1200,\"bairro\":\"\",\"localidade\":\"\",\"uf\":\"sc\",\"addressCompl\":\"Emfrente\",\"latitude\":-42.00000,\"longitude\":-27.0000}}";

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(path)
                .content(jsonUpdate)
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void deletePharmacyByIdTest() throws Exception {

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .param("id","2")
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getAllPharmaciesTest() throws Exception{

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getPharmacyByIdTest() throws Exception{

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .param("id","2")
                .header("Content-Type", "application/json")
                .header("Authorization", token);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }
}

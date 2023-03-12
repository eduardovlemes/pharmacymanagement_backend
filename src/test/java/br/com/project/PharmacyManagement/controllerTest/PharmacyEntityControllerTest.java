package br.com.project.PharmacyManagement.controllerTest;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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

        token = data.getString("token");

        Assertions.assertNotNull(token);
    }

    @Test
    public void createPharmacyAsAdmin() throws Exception{
        String jsonRegister = "{\"corporateName\":\"Clamed\",\"cnpj\":\"84.683.481/0001-77\",\"tradeName\":\"CATARINENSE\",\"email\":\"c@pp.com\",\"phone\":\"(47)3030-3030\",\"cellphone\":\"(47)98899-5544\",\"address\":{\"cep\":\"89201400\",\"number\":638,\"addressCompl\":\"Aolado\",\"latitude\":-42.00000,\"longitude\":-27.0000}}";

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder requestBody = MockMvcRequestBuilders.post(path)
                .header("Authorization","Bearer " + token)
                .header("Content-Type", "application/json")
                .content(jsonRegister);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(requestBody).andExpect(expectedResult);
    }


    @Test
    public void updatePharmacyByIdAsAdmin() throws Exception {
        String jsonUpdate = "{\"corporateName\":\"Clamed\",\"cnpj\":\"84.683.481/0001-77\",\"tradeName\":\"FORMULA\",\"email\":\"c@pp.com\",\"phone\":\"(47)3030-3030\",\"cellphone\":\"(47)98899-5544\",\"address\":{\"cep\":\"89201400\",\"logradouro\":\"\",\"number\":1200,\"bairro\":\"\",\"localidade\":\"\",\"uf\":\"sc\",\"addressCompl\":\"Emfrente\",\"latitude\":-42.00000,\"longitude\":-27.0000}}";

        path = new URI("/farmacia/1");

        MockHttpServletRequestBuilder requestBody = MockMvcRequestBuilders.put(path)
                .header("Authorization","Bearer " + token)
                .header("Content-Type", "application/json")
                .param("id", String.valueOf(1))
                .content(jsonUpdate);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(requestBody).andExpect(expectedResult);
    }

    @Test
    public void deletePharmacyByIdAsAdmin() throws Exception {
        path = new URI("/farmacia/1");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .header("Authorization","Bearer " + token)
                .header("Content-Type", "application/json")
                .param("id", String.valueOf(1));

        expectedResult = MockMvcResultMatchers.status().isAccepted();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getAllPharmaciesAsAdmin() throws Exception{

        path = new URI("/farmacia");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Authorization", "Bearer " +  token)
                .header("Content-Type", "application/json");

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getPharmacyByIdAsAdmin() throws Exception{
        path = new URI("/farmacia");

        MockHttpServletRequestBuilder requestBody = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " +  token)
                .param("id", String.valueOf(2));

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(requestBody).andExpect(expectedResult);
    }
}

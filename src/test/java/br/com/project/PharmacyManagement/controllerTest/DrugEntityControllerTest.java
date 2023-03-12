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
public class DrugEntityControllerTest {

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
    public void registerDrugAsAdmin() throws Exception{
        String jsonRegister = "{\"drugName\":\"vitaminaD\",\"lab\":\"catarinensepharma\",\"dosage\":\"1000mg\",\"description\":\"reforçoparaosistemaimunológico\",\"price\":10.90,\"type\":\"suplemento\"}";

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .header("Authorization","Bearer " + token)
                .header("Content-Type", "application/json")
                .content(jsonRegister);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void updateDrugByIdAsAdmin() throws Exception {
        String jsonUpdate = "{\"drugName\":\"NIMESULIDA\",\"lab\":\"Catarinense\",\"dosage\":\"900\",\"description\":\"combateinflamação\",\"price\":2.50,\"type\":\"anti-inflamatório\"}";

        path = new URI("/medicamentos/52");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(path)
                .header("Authorization","Bearer " + token)
                .header("Content-Type", "application/json")
                .param("id", String.valueOf(52))
                .content(jsonUpdate);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void deleteDrugByIdAsAdmin() throws Exception {

        path = new URI("/medicamentos/52");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .header("Authorization","Bearer " + token)
                .header("Content-Type", "application/json")
                .param("id", String.valueOf(52));

        expectedResult = MockMvcResultMatchers.status().isAccepted();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getAllDrugsAsAdmin() throws Exception{

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Authorization", "Bearer " +  token)
                .header("Content-Type", "application/json");

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getDrugByIdAsAdmin() throws Exception{

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " +  token)
                .param("id", String.valueOf(52));

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }
}

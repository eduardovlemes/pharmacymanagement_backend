package br.com.project.PharmacyManagement.controllerTest;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

public class DrugEntityControllerTest {
    private URI path;
    private MockHttpServletRequest mockHttpServletRequest;
    private ResultMatcher expectedResult;

    @Autowired
    private MockMvc mock;

    private String jwtToken;

    @Before
    public void setUp() throws Exception {
        String json = "{\"email\":\"edu@rdo\",\"password\":\"1234\"}";

        path = new URI ("/usuario/login");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path).contentType(MediaType.APPLICATION_JSON).content(json);

        expectedResult = MockMvcResultMatchers.status().isOk();

        String response = mock.perform(request).andExpect(expectedResult).andReturn().getResponse().getContentAsString();

        JSONObject data = new JSONObject(response);

        jwtToken = data.getString("Authorization");
    }

    @Test
    public void registerDrugTest() throws Exception{
        String jsonRegister = "{\"drugName\":\"vitaminaD\",\"lab\":\"catarinensepharma\",\"dosage\":\"1000mg\",\"description\":\"reforçoparaosistemaimunológico\",\"price\":10.90,\"type\":\"suplemento\"}";

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonRegister)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);
    }


    @Test
    public void UpdateDrugByIdTest() throws Exception {
        String jsonUpdate = "{\"drugName\":\"NIMESULIDA\",\"lab\":\"Catarinense\",\"dosage\":\"900\",\"description\":\"combateinflamação\",\"price\":2.50,\"type\":\"anti-inflamatório\"}";

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(path)
                .content(jsonUpdate)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void deletePharmacyByIdTest() throws Exception {

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .param("id","2")
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getAllPharmaciesTest() throws Exception{

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    @Test
    public void getPharmacyByIdTest() throws Exception{

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .param("id","2")
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }




}

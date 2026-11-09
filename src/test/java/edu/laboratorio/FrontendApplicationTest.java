
package edu.laboratorio;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FrontendApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    // PRUEBA 1: La página responde con HTTP 200
    @Test
    void paginaPrincipalResponde() throws Exception {

        mockMvc.perform(get("/"))
               .andExpect(status().isOk());
    }

    // PRUEBA 2: Existe el título
    @Test
    void paginaContieneTitulo() throws Exception {

        String html = mockMvc.perform(get("/"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(
            html.contains("Mi primera página con Java")
        );
    }

    // PRUEBA 3: Existe el botón
    @Test
    void paginaContieneBoton() throws Exception {

        String html = mockMvc.perform(get("/"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(
            html.contains("Mostrar mensaje")
        );
    }
}

package edu.laboratorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/** Comprueba que index.html se sirva desde la ruta / . */
@SpringBootTest
@AutoConfigureMockMvc
class FrontendApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void paginaPrincipalDevuelve200() throws Exception {
        mvc.perform(get("/"))
           .andExpect(status().isOk());
    }

    @Test
    void paginaContieneTitulo() throws Exception {
        mvc.perform(get("/"))
           .andExpect(content().string(org.hamcrest.Matchers.containsString("Mi primera página con Java")));
    }

    @Test
    void paginaContieneBoton() throws Exception {
        mvc.perform(get("/"))
           .andExpect(content().string(org.hamcrest.Matchers.containsString("id="saludar"")));
    }
}


package edu.laboratorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class FrontendApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    // Prueba 1: verificar que la página responda
    @Test
    void paginaPrincipalResponde() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    // Prueba 2: verificar el título
    @Test
    void paginaContieneTitulo() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                    org.hamcrest.Matchers.containsString(
                        "Mi primera página con Java"
                    )
                ));
    }

    // Prueba 3: verificar que exista un botón
    @Test
    void paginaContieneBoton() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                    org.hamcrest.Matchers.containsString(
                        "Mostrar mensaje"
                    )
                ));
    }
}

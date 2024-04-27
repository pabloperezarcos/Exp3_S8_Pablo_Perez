package com.fullstack.exp3_s8.CasoB.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fullstack.CasoB.controller.ConsultaController;
import com.fullstack.CasoB.model.Consulta;
import com.fullstack.CasoB.service.ConsultaService;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(ConsultaController.class)
@ActiveProfiles("casoB") // Activar solo el perfil del Caso B para esta prueba
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaService consultaService;

    @Test
    public void testGetConsultasReturnsListOfConsultas() throws Exception {
        // Crear el objeto de prueba para el modelo
        Consulta consulta = new Consulta();
        consulta.setId(1);
        consulta.setMotivo("Revision Anual");
        consulta.setDiagnostico("Saludable");

        List<Consulta> consultas = Arrays.asList(consulta);

        // Configurar el servicio para devolver la lista esperada cuando se invoque
        when(consultaService.getConsultas()).thenReturn(consultas);

        // Realizar la llamada al endpoint y verificar los resultados
        mockMvc.perform(get("/consultas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(consulta.getId()))
                .andExpect(jsonPath("$[0].motivo").value("Revision Anual"))
                .andExpect(jsonPath("$[0].diagnostico").value("Saludable"));

        // Verificar que el servicio fue invocado correctamente
        verify(consultaService, times(1)).getConsultas();
    }
}

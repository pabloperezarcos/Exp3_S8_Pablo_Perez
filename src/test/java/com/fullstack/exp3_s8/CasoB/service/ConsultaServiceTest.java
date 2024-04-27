package com.fullstack.exp3_s8.CasoB.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fullstack.CasoB.model.Consulta;
import com.fullstack.CasoB.repository.ConsultaRepository;
import com.fullstack.CasoB.service.ConsultaServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConsultaServiceTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private ConsultaServiceImpl consultaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetConsultas() {
        // Preparar datos de prueba
        Consulta consulta1 = new Consulta();
        consulta1.setId(1);
        consulta1.setMotivo("Chequeo General");
        consulta1.setDiagnostico("Saludable");

        Consulta consulta2 = new Consulta();
        consulta2.setId(2);
        consulta2.setMotivo("Dolor de cabeza");
        consulta2.setDiagnostico("Migraña");

        when(consultaRepository.findAll()).thenReturn(Arrays.asList(consulta1, consulta2));

        // Llamada al método que se está probando
        List<Consulta> consultas = consultaService.getConsultas();

        // Verificar el resultado
        assertNotNull(consultas);
        assertEquals(2, consultas.size());
        assertTrue(consultas.contains(consulta1));
        assertTrue(consultas.contains(consulta2));

        // Verificar que el repositorio fue invocado correctamente
        verify(consultaRepository, times(1)).findAll();
    }

    @Test
    public void testGetConsultaById() {
        // Preparar datos de prueba
        Consulta consulta = new Consulta();
        consulta.setId(1);
        consulta.setMotivo("Chequeo Anual");
        consulta.setDiagnostico("Bueno");

        when(consultaRepository.findById(1)).thenReturn(Optional.of(consulta));

        // Llamada al método que se está probando
        ResponseEntity<?> response = consultaService.getConsultaById(1);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(consulta, response.getBody());

        // Verificar que el repositorio fue invocado correctamente
        verify(consultaRepository, times(1)).findById(1);
    }

    // Agrega más pruebas para los otros métodos: getConsultasByDiagnostico,
    // createConsulta, updateConsulta, deleteConsulta
}
package com.fullstack.exp3_s8.CasoB.repository;

import com.fullstack.CasoB.model.Consulta;
import com.fullstack.CasoB.repository.ConsultaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("casoB") // Asegúrate de tener un perfil para las pruebas que configure una BD en memoria
public class ConsultaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Test
    public void whenFindByDiagnostico_thenReturnConsultas() {
        // Crear y guardar una entidad
        Consulta consulta = new Consulta();
        consulta.setFecha(new Date());
        consulta.setMotivo("Chequeo General");
        consulta.setDiagnostico("Saludable");
        consulta.setIdPaciente(1); // Asegúrate de que este ID sea válido o simula también la inserción de un
                                   // paciente si es necesario
        entityManager.persist(consulta);
        entityManager.flush();

        // Buscar la entidad
        List<Consulta> found = consultaRepository.findByDiagnosticoIgnoreCase("saludable");
        // Verificar los resultados
        assertThat(found).hasSize(1);
        assertThat(found.get(0).getDiagnostico()).isEqualTo("Saludable");
    }

}
package interviewProject.robotApocalypse.repository;

import interviewProject.robotApocalypse.entity.Survivor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


public class SurvivorRepositoryTest {


    @Test
    public void testFindByInfected() {
        SurvivorRepository survivorRepository = mock(SurvivorRepository.class);

        // Define the behavior of the mock
        when(survivorRepository.findByInfected(true))
                .thenReturn(Optional.of(Arrays.asList(new Survivor())));

        // Perform the test
        Optional<List<Survivor>> result = survivorRepository.findByInfected(true);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals(1, result.get().size());
    }

    @Test
    public void testCountByInfected() {
        SurvivorRepository survivorRepository = mock(SurvivorRepository.class);

        // Define the behavior of the mock
        when(survivorRepository.countByInfected(true))
                .thenReturn(5L);

        // Perform the test
        long count = survivorRepository.countByInfected(true);

        // Verify the result
        assertEquals(5L, count);

    }

    @Test
    public void testCountByInfectedFalse() {
        SurvivorRepository survivorRepository = mock(SurvivorRepository.class);

        // Define the behavior of the mock
        when(survivorRepository.countByInfectedFalse())
                .thenReturn(10L);

        // Perform the test
        long count = survivorRepository.countByInfectedFalse();

        // Verify the result
        assertEquals(10L, count);

    }


}

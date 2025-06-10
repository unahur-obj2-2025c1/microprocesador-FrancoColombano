package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class MicroprocesadorTest {
    Programable micro;
    @BeforeEach
        public void setUp() {
        micro = new Microprocesador(); 
    }

    @Test
    void hacerAvanzar3PosicionesElPC() {
        List<Operable> programa = new ProgramBuilder()
            .addNOP()
            .addNOP()
            .addNOP()
            .build();
        micro.run(programa);
        assertEquals(3, micro.getProgramCounter());
    }
    
    @Test
    void sumar20mas17() {
        List<Operable> programa = new ProgramBuilder()
            .addLODV(20)
            .addSWAP()
            .addLODV(17)
            .addADD()
            .build();
        micro.run(programa);
        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    void sumar2mas8mas7() {
        List<Operable> programa = new ProgramBuilder()
            .addLODV(2)
            .addSTR(0)
            .addLODV(8)
            .addSWAP()
            .addLODV(5)
            .addADD()
            .addSWAP()
            .addLOD(0)
            .addADD()
            .build();
        micro.run(programa);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(9, micro.getProgramCounter());
    }
}

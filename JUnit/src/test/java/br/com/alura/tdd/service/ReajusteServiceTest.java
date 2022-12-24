package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
//    private final ReajusteService reajusteService;
//    private final Funcionario funcionario;
//
//    public ReajusteServiceTest() {
//        reajusteService = new ReajusteService();
//        funcionario = new Funcionario("Ana", LocalDate.of(2020,2,14), new BigDecimal("1000.00"));
//    }

    private ReajusteService reajusteService;
    private Funcionario funcionario;
    @BeforeEach
    public void inicializar() {
        System.out.println("início");
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.of(2020,2,14), new BigDecimal("1000.00"));
    }
    @AfterEach
    public void finalizar() {
        System.out.println("fim");
    }
    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("Antes de todos");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("Depois de todos");
    }

    @Test
    void reajusteDeveriaSerTresPorcentoDesempenhoAdesejar() {
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerQuinzePorcentoDesempenhoBom() {
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerVintePorcentoDesempenhoOtimo() {
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }

}

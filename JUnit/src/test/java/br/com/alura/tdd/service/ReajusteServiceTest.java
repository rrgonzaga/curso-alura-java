package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    @Test
    void reajusteDeveriaSerTresPorcentoDesempenhoAdesejar() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.of(2020,2,14), new BigDecimal("1000.00"));

        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerQuinzePorcentoDesempenhoBom() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.of(2020,2,14), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerVintePorcentoDesempenhoOtimo() {
        ReajusteService reajusteService = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.of(2020,2,14), new BigDecimal("1000.00"));
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }



}

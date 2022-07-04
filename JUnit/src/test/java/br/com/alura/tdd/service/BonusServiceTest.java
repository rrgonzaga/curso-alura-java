package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    //Se 10% do salário do funcionário for maior que 1.000,00, não recebe bonus
    @Test
    void bonusZeroCasoDezPorcentoSalarioMaiorQueMilReais() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.of(2022,3,1),new BigDecimal(10500));
        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("0.00"),valorBonus);
    }

    @Test
    void bonusDeveLancarExcecaoParaSalarioMaiorQueDezMil_E_QuinhentosReais() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.of(2022,3,1),new BigDecimal(10500.50));
        //Primeira opção do teste lançar uma exception
        //assertThrows(IllegalArgumentException.class,() -> bonusService.calcularBonus(funcionario));

        //Segunda opção do teste lançar uma exception e comparar a mensagem da exception
        try {
            BigDecimal bonus = bonusService.calcularBonus(funcionario);
            fail("Falhou porque não lançou a exception!");
        } catch (Exception e) {
            assertEquals("Funcionario com salário maior que 10.500,00 reais",e.getMessage());
        }

    }

    @Test
    void bonusMaiorQueZeroCasoDezPorcentoSalarioMenorQueMilReais() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.of(2022,3,1),new BigDecimal("7500.50"));
        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        assertTrue(valorBonus.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void bonusMaiorQueZeroCasoDezPorcentoSalarioIgual_a_MilReais() {
        BonusService bonusService = new BonusService();
        Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.of(2022,3,1),new BigDecimal("10000.00"));
        BigDecimal valorBonus = bonusService.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"),valorBonus);
    }

}
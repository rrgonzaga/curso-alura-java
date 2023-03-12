package br.com.alura.rh.service.beneficios;

import br.com.alura.rh.model.Beneficio;
import br.com.alura.rh.model.Pessoa;
import br.com.alura.rh.model.PlanoSaude;

import java.math.BigDecimal;

public interface BeneficioEmpresa_v01 {
    BigDecimal definirValeRefeicao();
    BigDecimal definirValeTransporte();
    PlanoSaude definirPlanoSaude();
    BigDecimal definirBolsaEstagio();
    BigDecimal definirPLR();
    BigDecimal definirBonificacaoMetaSuperada();
    void gravarBeneficio(Pessoa pessoa);
    Beneficio obterBeneficio(Pessoa pessoa);
}

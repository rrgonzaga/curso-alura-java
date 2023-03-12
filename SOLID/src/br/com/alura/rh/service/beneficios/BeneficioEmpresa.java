package br.com.alura.rh.service.beneficios;

import br.com.alura.rh.model.Beneficio;
import br.com.alura.rh.model.Pessoa;
import br.com.alura.rh.model.PlanoSaude;

import java.math.BigDecimal;

public interface BeneficioEmpresa {
    BigDecimal definirValeRefeicao();
    BigDecimal definirValeTransporte();
    PlanoSaude definirPlanoSaude();
    void gravarBeneficio(Pessoa pessoa);
    Beneficio obterBeneficio(Pessoa pessoa);
}

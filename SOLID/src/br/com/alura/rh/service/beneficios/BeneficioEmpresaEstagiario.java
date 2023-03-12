package br.com.alura.rh.service.beneficios;

import br.com.alura.rh.model.Beneficio;
import br.com.alura.rh.model.Pessoa;
import br.com.alura.rh.model.PlanoSaude;

import java.math.BigDecimal;

public interface BeneficioEmpresaEstagiario extends BeneficioEmpresa {
    BigDecimal definirBolsaEstagio();
}

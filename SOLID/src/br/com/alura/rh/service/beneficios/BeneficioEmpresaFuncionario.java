package br.com.alura.rh.service.beneficios;

import java.math.BigDecimal;

public interface BeneficioEmpresaFuncionario extends BeneficioEmpresa {
    BigDecimal definirPLR();
    BigDecimal definirBonificacaoMetaSuperada();
}

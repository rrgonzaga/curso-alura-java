package br.com.alura.rh.service.beneficios;
import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.*;

import java.math.BigDecimal;

public class BeneficioEmpresaEstagiarioService_v01 implements BeneficioEmpresa_v01 {
    private void validaPessoaEstagiario(Pessoa pessoa) {
        if (pessoa instanceof Funcionario)
            throw new ValidacaoException("Pessoa não pode ser funcionário. Precisa ser estagiário");
    }
    @Override
    public BigDecimal definirValeRefeicao() { return new BigDecimal("680.00"); }
    @Override
    public BigDecimal definirValeTransporte() { return null; //TODO Falta implementar
    }
    @Override
    public PlanoSaude definirPlanoSaude() {return null; //TODO Falta implementar
    }
    @Override
    public BigDecimal definirBolsaEstagio() { return new BigDecimal("585.00"); }

    /** Estagiário não tem direito a PLR */
    @Override
    public BigDecimal definirPLR() { return null; }

    /** Estagiário não tem direito a bonificação meta superada */
    @Override
    public BigDecimal definirBonificacaoMetaSuperada() { return null; }

    @Override
    public void gravarBeneficio(Pessoa pessoa) {
        validaPessoaEstagiario(pessoa);
        BigDecimal valeRefeicao = definirValeRefeicao();
        PlanoSaude planoSaude = definirPlanoSaude();
        BigDecimal valeTransporte = definirValeTransporte();
        BigDecimal bolsaEstagio = definirBolsaEstagio();

        BeneficioEstagiario beneficio = new BeneficioEstagiario(valeRefeicao,valeTransporte,planoSaude, bolsaEstagio);

        pessoa.setBeneficio(beneficio);
        //Chama o repositório para gravar benefício
    }

    @Override
    public Beneficio obterBeneficio(Pessoa pessoa) {return null; //TODO Falta implementar
    }
}

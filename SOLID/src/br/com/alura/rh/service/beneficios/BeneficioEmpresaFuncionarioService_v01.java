package br.com.alura.rh.service.beneficios;
import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.*;

import java.math.BigDecimal;

public class BeneficioEmpresaFuncionarioService_v01 implements BeneficioEmpresa_v01 {
    private Funcionario validaPessoaFuncionario(Pessoa pessoa) {
        if (pessoa instanceof Estagiario)
            throw new ValidacaoException("Pessoa não pode ser estagiário. Precisa ser funcionário");

        return (Funcionario)pessoa;
    }
    @Override
    public BigDecimal definirValeRefeicao() { return new BigDecimal("680.00"); }
    @Override
    public BigDecimal definirValeTransporte() { return null; //TODO Falta implementar
    }
    @Override
    public PlanoSaude definirPlanoSaude() {return null; //TODO Falta implementar
    }
    /** Funcionário não tem direito a bolsa estágio */
    @Override
    public BigDecimal definirBolsaEstagio() { return null; }
    @Override
    public BigDecimal definirPLR() { return null; //TODO Falta implementar
    }
    @Override
    public BigDecimal definirBonificacaoMetaSuperada() { return null; //TODO Falta implementar
    }
    @Override
    public void gravarBeneficio(Pessoa pessoa) {
        Funcionario funcionario = validaPessoaFuncionario(pessoa);

        BigDecimal valeRefeicao = definirValeRefeicao();
        PlanoSaude planoSaude = definirPlanoSaude();
        BigDecimal valeTransporte = definirValeTransporte();

        BeneficioFuncionario beneficio = new BeneficioFuncionario(valeRefeicao,valeTransporte,planoSaude);

        funcionario.setBeneficio(beneficio);
        //Chama o repositório de funcionario para gravar benefício
    }

    public void gravarPLR(Funcionario funcionario) {
        BigDecimal valorPLR = definirPLR();
        funcionario.getBeneficio().setValorPLR(valorPLR);
        funcionario.setBeneficio(funcionario.getBeneficio());
        //Chama o repositório de funcionario para gravar benefício
    }

    public void gravarBonificacaoMetaSuperada(Funcionario funcionario) { //TODO Falta implementar
    }

    @Override
    public Beneficio obterBeneficio(Pessoa pessoa) {return null; //TODO Falta implementar
    }
}

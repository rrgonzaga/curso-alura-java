package br.com.alura.rh.service.beneficios;
import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.*;

import java.math.BigDecimal;

public class BeneficioEmpresaFuncionarioService implements BeneficioEmpresaFuncionario {
    private Funcionario funcionario;
    private void validaPessoaFuncionario(Pessoa pessoa) {
        if (pessoa instanceof Estagiario)
            throw new ValidacaoException("Pessoa não pode ser estagiário. Precisa ser funcionário");

        funcionario = (Funcionario)pessoa;
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
    public BigDecimal definirPLR() { return funcionario.getSalario().multiply(new BigDecimal("0.95")); }
    @Override
    public BigDecimal definirBonificacaoMetaSuperada() { return funcionario.getSalario().multiply(new BigDecimal("1.5"));
    }
    @Override
    public void gravarBeneficio(Pessoa pessoa) {
        validaPessoaFuncionario(pessoa);

        BigDecimal valeRefeicao = definirValeRefeicao();
        PlanoSaude planoSaude = definirPlanoSaude();
        BigDecimal valeTransporte = definirValeTransporte();

        BeneficioFuncionario beneficio = new BeneficioFuncionario(valeRefeicao,valeTransporte,planoSaude);

        funcionario.setBeneficio(beneficio);
        //Chama o repositório de funcionario para gravar benefício
    }

    @Override
    public Beneficio obterBeneficio(Pessoa pessoa) {return null; //TODO Falta implementar
    }

    public void gravarPLR(Funcionario funcionario) {
        BigDecimal valorPLR = definirPLR();
        funcionario.getBeneficio().setValorPLR(valorPLR);
        funcionario.setBeneficio(funcionario.getBeneficio());
        //Chama o repositório de funcionario para gravar benefício
    }

    public void gravarBonificacaoMetaSuperada(Funcionario funcionario) { //TODO Falta implementar
    }

}

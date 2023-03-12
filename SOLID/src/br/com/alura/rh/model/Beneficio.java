package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Beneficio {
    private BigDecimal valeRefeicao;
    private BigDecimal valeTransporte;
    private PlanoSaude planoSaude;

    public Beneficio(BigDecimal valeRefeicao, BigDecimal valeTransporte, PlanoSaude planoSaude) {
        this.valeRefeicao = valeRefeicao;
        this.valeTransporte = valeTransporte;
        this.planoSaude = planoSaude;
    }

    public BigDecimal getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(BigDecimal valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public BigDecimal getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(BigDecimal valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }
}

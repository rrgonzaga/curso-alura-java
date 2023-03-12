package br.com.alura.rh.model;

import br.com.alura.rh.enumerations.TipoPessoa;

public abstract class Pessoa {
    TipoPessoa tipoPessoa;
    private Beneficio Beneficio;

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Beneficio getBeneficio() {
        return Beneficio;
    }

    public void setBeneficio( Beneficio beneficio) {
        this.Beneficio = beneficio;
    }
}

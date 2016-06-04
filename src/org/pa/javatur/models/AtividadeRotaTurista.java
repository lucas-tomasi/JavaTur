package org.pa.javatur.models;

/**
 *
 * @author lucas
 */
public class AtividadeRotaTurista 
{
    private int id;
    private int ref_rota_turista;
    private int ref_atividade;
    private double valor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ref_rota_turista
     */
    public int getRefRotaTurista() {
        return ref_rota_turista;
    }

    /**
     * @param ref_rota_turista the ref_rota_turista to set
     */
    public void setRefRotaTurista(int ref_rota_turista) {
        this.ref_rota_turista = ref_rota_turista;
    }

    /**
     * @return the ref_atividade
     */
    public int getRefAtividade() {
        return ref_atividade;
    }

    /**
     * @param ref_atividade the ref_atividade to set
     */
    public void setRefAtividade(int ref_atividade) {
        this.ref_atividade = ref_atividade;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}

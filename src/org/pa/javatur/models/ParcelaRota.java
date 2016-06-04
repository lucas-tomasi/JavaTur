package org.pa.javatur.models;

/**
 *
 * @author lucas
 */
public class ParcelaRota 
{
    private int id;
    private int ref_rota;
    private int ref_parcela;

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
     * @return the ref_rota
     */
    public int getRefRota() {
        return ref_rota;
    }

    /**
     * @param ref_rota the ref_rota to set
     */
    public void setRefRota(int ref_rota) {
        this.ref_rota = ref_rota;
    }

    /**
     * @return the ref_parcela
     */
    public int getRefParcela() {
        return ref_parcela;
    }

    /**
     * @param ref_parcela the ref_parcela to set
     */
    public void setRefParcela(int ref_parcela) {
        this.ref_parcela = ref_parcela;
    }
}

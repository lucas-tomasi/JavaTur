
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.models;

/**
 *
 * @author lucas
 */
    public class Local {
    private int id;
    private boolean ativo;
    private String descricao;
    private int ref_tipo_local;
    private String obs;

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
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the ref_tipo_local
     */
    public int getTipoLocal() {
        return ref_tipo_local;
    }

    /**
     * @param ref_tipo_local the ref_tipo_local to set
     */
    public void setTipoLocal(int ref_tipo_local) {
        this.ref_tipo_local = ref_tipo_local;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}

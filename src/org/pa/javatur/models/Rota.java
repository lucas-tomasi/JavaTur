/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.models;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class Rota {
    private int id;
    private boolean ativo;
    private String descricao;
    private Date dt_inicio;
    private Date dt_fim;
    private String obs;
    private double valor;
    private int vagas;

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
     * @return the dt_inicio
     */
    public Date getDtInicio() {
        return dt_inicio;
    }

    /**
     * @param dt_inicio the dt_inicio to set
     */
    public void setDtInicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    /**
     * @return the dt_fim
     */
    public Date getDtFim() {
        return dt_fim;
    }

    /**
     * @param dt_fim the dt_fim to set
     */
    public void setDtFim(Date dt_fim) {
        this.dt_fim = dt_fim;
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

    /**
     * @return the vagas
     */
    public int getVagas() {
        return vagas;
    }

    /**
     * @param vagas the vagas to set
     */
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    
    
    @Override
    public String toString() {
        return this.getDescricao();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.models;

import org.pa.javatur.daos.AtividadeDAO;
import java.sql.Time;

/**
 *
 * @author lucas
 */
public class AtividadeLocal 
{
    private int id;
    private int ref_atividade;
    private int ref_local;
    private Time hr_ini;
    private Time hr_fim;
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
     * @return the ref_atividade
     */
    public int getAtividade() {
        return ref_atividade;
    }

    /**
     * @param ref_atividade the ref_atividade to set
     */
    public void setAtividade(int ref_atividade) {
        this.ref_atividade = ref_atividade;
    }

    /**
     * @return the ref_local
     */
    public int getLocal() {
        return ref_local;
    }

    /**
     * @param ref_local the ref_local to set
     */
    public void setLocal(int ref_local) {
        this.ref_local = ref_local;
    }

    /**
     * @return the hr_ini
     */
    public Time getHrIni() {
        return hr_ini;
    }

    /**
     * @param hr_ini the hr_ini to set
     */
    public void setHrIni(Time hr_ini) {
        this.hr_ini = hr_ini;
    }

    /**
     * @return the hr_fim
     */
    public Time getHrFim() {
        return hr_fim;
    }

    /**
     * @param hr_fim the hr_fim to set
     */
    public void setHrFim(Time hr_fim) {
        this.hr_fim = hr_fim;
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
    
    public String toString()
    {
        AtividadeDAO dao = new AtividadeDAO();
        Atividade atividade = dao.buscar(getAtividade());
        return atividade.getDescricao();
    }
}

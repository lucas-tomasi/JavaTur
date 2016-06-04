package org.pa.javatur.models;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class Parcela 
{
  private int id;
  private double valor_estimado;
  private char status_pagamento;
  private double valor_realizado;
  private Date dt_pagamento;
  private Date dt_vencimento;
  private int parcela;
  
  public static final char STATUS_PAGA = 'P';
  public static final char STATUS_ABERTA = 'A';
  public static final char STATUS_CANCELADA = 'C';
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
     * @return the valor_estimado
     */
    public double getValorEstimado() {
        return valor_estimado;
    }

    /**
     * @param valor_estimado the valor_estimado to set
     */
    public void setValorEstimado(double valor_estimado) {
        this.valor_estimado = valor_estimado;
    }

    /**
     * @return the status_pagamento
     */
    public char getStatusPagamento() {
        return status_pagamento;
    }

    /**
     * @param status_pagamento the status_pagamento to set
     */
    public void setStatusPagamento(char status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    /**
     * @return the valor_realizado
     */
    public double getValorRealizado() {
        return valor_realizado;
    }

    /**
     * @param valor_realizado the valor_realizado to set
     */
    public void setValorRealizado(double valor_realizado) {
        this.valor_realizado = valor_realizado;
    }

    /**
     * @return the dt_pagamento
     */
    public Date getDtPagamento() {
        return dt_pagamento;
    }

    /**
     * @param dt_pagamento the dt_pagamento to set
     */
    public void setDtPagamento(Date dt_pagamento) {
        this.dt_pagamento = dt_pagamento;
    }

    /**
     * @return the dt_vencimento
     */
    public Date getDtVencimento() {
        return dt_vencimento;
    }

    /**
     * @param dt_vencimento the dt_vencimento to set
     */
    public void setDtVencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    /**
     * @return the parcela
     */
    public int getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    
    public String toString()
    {
        return String.valueOf(this.getStatusPagamento());
    }
}

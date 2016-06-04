package org.pa.javatur.models;

import java.sql.Date;
import org.pa.javatur.daos.RotaDAO;

/**
 *
 * @author lucas
 */
public class RotaTurista 
{
    private int id;
    private int ref_turista;
    private int ref_rota;
    private char status;
    private Date dt_inscricao;
    private double valor_total;
    private char status_pagamento;
    private double valor_rota;
    private int total_parcelas;
    private int ref_forma_pagameto;

    public static final char PAGO      = 'P';
    public static final char ABERTO    = 'A';
    public static final char CANCELADO = 'C';
    
    public static final char MARCADA   = 'M';
    public static final char CONCLUIDA = 'X';
    public static final char CANCELADA = 'C';
    
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
     * @return the ref_turista
     */
    public int getRefTurista() {
        return ref_turista;
    }

    /**
     * @param ref_turista the ref_turista to set
     */
    public void setRefTurista(int ref_turista) {
        this.ref_turista = ref_turista;
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
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * @return the dt_inscricao
     */
    public Date getDtInscricao() {
        return dt_inscricao;
    }

    /**
     * @param dt_inscricao the dt_inscricao to set
     */
    public void setDtInscricao(Date dt_inscricao) {
        this.dt_inscricao = dt_inscricao;
    }

    /**
     * @return the valor_total
     */
    public double getValorTotal() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValorTotal(double valor_total) {
        this.valor_total = valor_total;
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
     * @return the valor_rota
     */
    public double getValorRota() {
        return valor_rota;
    }

    /**
     * @param valor_rota the valor_rota to set
     */
    public void setValorRota(double valor_rota) {
        this.valor_rota = valor_rota;
    }

    /**
     * @return the total_parcelas
     */
    public int getTotalParcelas() {
        return total_parcelas;
    }

    /**
     * @param total_parcelas the total_parcelas to set
     */
    public void setTotalParcelas(int total_parcelas) {
        this.total_parcelas = total_parcelas;
    }

    /**
     * @return the ref_forma_pagameto
     */
    public int getRefFormaPagameto() {
        return ref_forma_pagameto;
    }

    /**
     * @param ref_forma_pagameto the ref_forma_pagameto to set
     */
    public void setRefFormaPagameto(int ref_forma_pagameto) {
        this.ref_forma_pagameto = ref_forma_pagameto;
    }
    
    public String toString()
    {
        
        RotaDAO rDAO = new RotaDAO();
        Rota rota = rDAO.buscar( this.getRefRota() );
        return rota.getDescricao();
    }
}

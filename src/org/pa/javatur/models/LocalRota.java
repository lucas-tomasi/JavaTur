package org.pa.javatur.models;

import org.pa.javatur.daos.LocalDAO;
import java.sql.Date;

/**
 *
 * @author lucas
 */
public class LocalRota 
{
    private int id;
    private int ref_rota;
    private int ref_local;
    private Date dt_rota;
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
     * @return the ref_local
     */
    public int getRefLocal() {
        return ref_local;
    }

    /**
     * @param ref_local the ref_local to set
     */
    public void setRefLocal(int ref_local) {
        this.ref_local = ref_local;
    }

    /**
     * @return the dt_rota
     */
    public Date getDtRota() {
        return dt_rota;
    }

    /**
     * @param dt_rota the dt_rota to set
     */
    public void setDtRota(Date dt_rota) {
        this.dt_rota = dt_rota;
    }
    
    public String toString() 
    {
        LocalDAO dao = new LocalDAO();
        Local local = dao.buscar( this.ref_local );

        return local.getDescricao();
    }

    @Override
    public boolean equals(Object obj) 
    {
        return false;
    }
    
    
}

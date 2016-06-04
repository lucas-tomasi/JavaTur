/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.itext;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.pa.javatur.models.ConexaoBD;

/**
 *
 * @author lucas
 */
public class Sql 
{
    private ArrayList colunas;
    private ArrayList tabelas;
    private ArrayList constraints;

    public Sql() {
        colunas     = new ArrayList();
        tabelas     = new ArrayList();
        constraints = new ArrayList();
    }
    
    
    
    public void addColuna( String coluna )
    {
        colunas.add(coluna);
    }
    
    public void addTabela( String tabela )
    {
        tabelas.add(tabela);
    }
    
    public void addConstraint( String coluna, String condicao, String valor, String operacao )
    {
        String constraint = "";
        if( operacao == null )
        {
            constraint = coluna +" "+condicao+" "+valor;
        }
        else
        {
            constraint = " " + operacao + " " + coluna +" "+condicao+" "+valor;
        }
        constraints.add( constraint );
    }
    
    public String[][] get() throws Exception
    {
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();
        ResultSet resultado = st.executeQuery( this.show() );
        
        String valores[][] = {};
        
        if (resultado.isBeforeFirst()) 
        {
            valores = new String[count()][colunas.size()];
            
            int k = 0;
            
            while (resultado.next()) 
            {
                for (int i = 0; i < colunas.size(); i++) 
                {                    
                    valores[k][i] = resultado.getString(i+1);
                }
                k++;
            }
        }
        
        return valores;
    }
    
    public String show()
    {
        String sql = "";
        
        sql += "SELECT ";
        
        for (int i = 0; i < this.colunas.size(); i++) 
        {
            if( i != ( this.colunas.size() - 1) )
            {
                sql += colunas.get(i) +", ";
            }
            else
            {
                sql += colunas.get(i);
            }
        }
        
        sql += " FROM ";
        
        for (int i = 0; i < this.tabelas.size(); i++) 
        {
            if( i != ( this.tabelas.size() - 1) )
            {
                sql += tabelas.get(i) +", ";
            }
            else
            {
                sql += tabelas.get(i);
            }
        }
        
        if (!this.constraints.isEmpty()) 
        {
            sql += " WHERE ";

            for (int i = 0; i < this.constraints.size(); i++) 
            {
                sql += constraints.get(i);
            }
        }
        return sql;
    }
    
    public int count() throws Exception
    {
        String sql = "SELECT count(*) FROM ";
        for (int i = 0; i < this.tabelas.size(); i++) 
        {
            if( i != ( this.tabelas.size() - 1) )
            {
                sql += tabelas.get(i) +", ";
            }
            else
            {
                sql += tabelas.get(i);
            }
        }
        
        if (!this.constraints.isEmpty()) 
        {
            sql += " WHERE ";

            for (int i = 0; i < this.constraints.size(); i++) 
            {
                sql += constraints.get(i);
            }
        }
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();
        ResultSet resultado = st.executeQuery( sql );
        resultado.next();
        int count = resultado.getInt("count");
        return count;
    }
}

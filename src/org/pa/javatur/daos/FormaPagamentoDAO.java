/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.daos;

import org.pa.javatur.interfaces.DAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.pa.javatur.models.ConexaoBD;
import org.pa.javatur.models.FormaPagamento;

/**
 * @author lucas
 */
public class FormaPagamentoDAO  implements DAOInterface<FormaPagamento>
{       
    public boolean salvar( FormaPagamento obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO formas_pagamentos ( descricao , ativo ) VALUES (?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo() );
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE formas_pagamentos SET descricao = ? , ativo = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo());
                pst.setInt(3, obj.getId());
                pst.executeUpdate();
            }
            
            return true;
        }
        catch( Exception e )
        {
            System.err.println(e);
            return false;
        }
    }

    public ArrayList<FormaPagamento> buscar() 
    {
        try 
        {
            ArrayList<FormaPagamento> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM formas_pagamentos ORDER BY descricao ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    FormaPagamento tipoLocal = new FormaPagamento();
                    tipoLocal.setId(resultado.getInt("id"));
                    tipoLocal.setAtivo(resultado.getBoolean("ativo"));
                    tipoLocal.setDescricao(resultado.getString("descricao"));
                    tiposLocais.add(tipoLocal);
                }
            }
            return tiposLocais;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    public FormaPagamento buscar(int id) 
    {
        try 
        {
            FormaPagamento tipoLocal = new FormaPagamento();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM formas_pagamentos WHERE id = "+ id);

            resultado.next();
            tipoLocal.setId(resultado.getInt("id"));
            tipoLocal.setAtivo(resultado.getBoolean("ativo"));
            tipoLocal.setDescricao(resultado.getString("descricao"));
            
            return tipoLocal;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    public ArrayList buscar(String condicao) 
    {
        try 
        {
            ArrayList<FormaPagamento> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM formas_pagamentos WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    FormaPagamento tipoLocal = new FormaPagamento();
                    tipoLocal.setId(resultado.getInt("id"));
                    tipoLocal.setAtivo(resultado.getBoolean("ativo"));
                    tipoLocal.setDescricao(resultado.getString("descricao"));
                    tiposLocais.add(tipoLocal);
                }
            }
            return tiposLocais;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    @Override
    public int lastID() 
    {
        int last = 0;

        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT last_value FROM formas_pagamentos_id_seq" );
            
            resultado.next();
            last = resultado.getInt("last_value");
            return last;
        }
        catch( Exception e )
        {
            System.err.println(e);
            return last;
        }
    }
}

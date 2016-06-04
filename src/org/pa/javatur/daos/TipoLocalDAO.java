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
import org.pa.javatur.models.TipoLocal;

/**
 * @author lucas
 */
public class TipoLocalDAO  implements DAOInterface<TipoLocal>
{       
    public boolean salvar( TipoLocal obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO tipos_locais ( descricao , ativo ) VALUES (?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo() );
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE tipos_locais SET descricao = ? , ativo = ? WHERE id = ?");
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

    public ArrayList<TipoLocal> buscar() 
    {
        try 
        {
            ArrayList<TipoLocal> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM tipos_locais ORDER BY descricao ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    TipoLocal tipoLocal = new TipoLocal();
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

    public TipoLocal buscar(int id) 
    {
        try 
        {
            TipoLocal tipoLocal = new TipoLocal();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM tipos_locais WHERE id = "+ id);

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
            ArrayList<TipoLocal> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM tipos_locais WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    TipoLocal tipoLocal = new TipoLocal();
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM tipos_locais_id_seq" );
            
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

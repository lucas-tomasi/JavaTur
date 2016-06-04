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
import org.pa.javatur.models.Atividade;
import org.pa.javatur.models.ConexaoBD;

/**
 * @author lucas
 */
public class AtividadeDAO implements DAOInterface<Atividade>
{       
    @Override
    public boolean salvar( Atividade obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO atividades ( descricao , ativo , obs ) VALUES (?, ? , ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo() );
                pst.setString(3, obj.getObs());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE atividades SET descricao = ? , ativo = ? , obs = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo());
                pst.setString(3, obj.getObs());
                pst.setInt(4, obj.getId());
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

    @Override
    public ArrayList<Atividade> buscar() 
    {
        try 
        {
            ArrayList<Atividade> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades ORDER BY descricao ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Atividade atividade = new Atividade();
                    atividade.setId(resultado.getInt("id"));
                    atividade.setAtivo(resultado.getBoolean("ativo"));
                    atividade.setDescricao(resultado.getString("descricao"));
                    atividade.setObs(resultado.getString("obs"));
                    tiposLocais.add(atividade);
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
    public Atividade buscar(int id) 
    {
        try 
        {
            Atividade atividade = new Atividade();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades WHERE id = "+ id);

            resultado.next();
            atividade.setId(resultado.getInt("id"));
            atividade.setAtivo(resultado.getBoolean("ativo"));
            atividade.setDescricao(resultado.getString("descricao"));
            atividade.setObs(resultado.getString("obs"));
            
            return atividade;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList buscar(String condicao) 
    {
        try 
        {
            ArrayList<Atividade> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Atividade atividade = new Atividade();
                    atividade.setId(resultado.getInt("id"));
                    atividade.setAtivo(resultado.getBoolean("ativo"));
                    atividade.setDescricao(resultado.getString("descricao"));
                    atividade.setObs(resultado.getString("obs"));
                    tiposLocais.add(atividade);
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM atividades_id_seq" );
            
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

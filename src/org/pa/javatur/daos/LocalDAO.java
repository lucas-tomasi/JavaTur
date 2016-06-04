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
import java.util.Iterator;
import org.pa.javatur.models.ConexaoBD;
import org.pa.javatur.models.Local;

/**
 * @author lucas
 */
public class LocalDAO implements DAOInterface<Local>
{       
    @Override
    public boolean salvar( Local obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO locais ( descricao , ativo, obs, ref_tipo_local ) VALUES (?, ?, ?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo() );
                pst.setString(3, obj.getObs());
                pst.setInt(4, obj.getTipoLocal());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE locais SET descricao = ? , ativo = ? , obs = ? , ref_tipo_local = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setString(3, obj.getObs());
                pst.setBoolean(2, obj.isAtivo());
                pst.setInt(4, obj.getTipoLocal());
                pst.setInt(5, obj.getId());
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
    public ArrayList<Local> buscar() 
    {
        try 
        {
            ArrayList<Local> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM locais ORDER BY descricao ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Local local = new Local();
                    local.setId(resultado.getInt("id"));
                    local.setTipoLocal(resultado.getInt("ref_tipo_local"));
                    local.setAtivo(resultado.getBoolean("ativo"));
                    local.setDescricao(resultado.getString("descricao"));
                    local.setObs(resultado.getString("obs"));
                    tiposLocais.add(local);
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
    public Local buscar(int id) 
    {
        try 
        {
            Local local = new Local();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM locais WHERE id = "+ id);

            resultado.next(); 
            local.setId(resultado.getInt("id"));
            local.setTipoLocal(resultado.getInt("ref_tipo_local"));
            local.setAtivo(resultado.getBoolean("ativo"));
            local.setDescricao(resultado.getString("descricao"));
            local.setObs(resultado.getString("obs"));
            
            return local;
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
            ArrayList<Local> tiposLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(); 
            ResultSet resultado = st.executeQuery("SELECT * FROM locais WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Local local = new Local();
                    local.setId(resultado.getInt("id"));
                    local.setTipoLocal(resultado.getInt("ref_tipo_local"));
                    local.setAtivo(resultado.getBoolean("ativo"));
                    local.setDescricao(resultado.getString("descricao"));
                    local.setObs(resultado.getString("obs"));
                    tiposLocais.add(local);
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

    public int lastID()
    {
        int last = 0;
     
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT last_value FROM locais_id_seq" );
            
            resultado.next();
            last = resultado.getInt("last_value");
            
            return last;
        }
        catch( Exception e )
        {
            return last;
        }
    }

    public String buscarLocais( int idRota )
    {
        String stringLocais = "";
        ArrayList<Local> locais = buscar(" id in ( select ref_local from locais_rotas where ref_rota = "+idRota+")");
        
        if( !locais.isEmpty() )
        {
            for ( Local l : locais )
            {
                stringLocais += ", " + l.getDescricao() ;
            }
            stringLocais = stringLocais.substring(2);
        }        
        return stringLocais;
    }
}

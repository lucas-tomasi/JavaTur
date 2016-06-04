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
import org.pa.javatur.models.LocalRota;
import org.pa.javatur.models.ConexaoBD;

/**
 * @author lucas
 */
public class LocalRotaDAO implements DAOInterface<LocalRota>
{       
    @Override
    public boolean salvar( LocalRota obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO locais_rotas ( ref_local , ref_rota, dt_rota) VALUES (?, ?, ? )");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getRefLocal());
                pst.setInt(2, obj.getRefRota());
                pst.setDate(3, obj.getDtRota());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE locais_rotas SET ref_local = ? , ref_rota = ? , dt_rota = ?  WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getRefLocal());
                pst.setInt(2, obj.getRefRota());
                pst.setDate(3, obj.getDtRota());
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
    public ArrayList<LocalRota> buscar() 
    {
        try 
        {
            ArrayList<LocalRota> localRotas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM locais_rotas ORDER BY dt_rota ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    LocalRota localRota = new LocalRota();
                    
                    localRota.setId(resultado.getInt("id"));
                    localRota.setRefLocal(resultado.getInt("ref_local"));
                    localRota.setRefRota(resultado.getInt("ref_rota"));
                    localRota.setDtRota(resultado.getDate("dt_rota"));
                    
                    localRotas.add(localRota);
                }
            }
            return localRotas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public LocalRota buscar(int id) 
    {
        try 
        {
            LocalRota localRota = new LocalRota();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM locais_rotas WHERE id = "+ id);

            resultado.next();
            localRota.setId(resultado.getInt("id"));
            localRota.setRefLocal(resultado.getInt("ref_local"));
            localRota.setRefRota(resultado.getInt("ref_rota"));
            localRota.setDtRota(resultado.getDate("dt_rota"));
            
            return localRota;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<LocalRota> buscar(String condicao) 
    {
        try 
        {
            ArrayList<LocalRota> localRotas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM locais_rotas WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    LocalRota localRota = new LocalRota();
                    
                    localRota.setId(resultado.getInt("id"));
                    localRota.setRefLocal(resultado.getInt("ref_local"));
                    localRota.setRefRota(resultado.getInt("ref_rota"));
                    localRota.setDtRota(resultado.getDate("dt_rota"));
                    
                    localRotas.add(localRota);
                }
            }
            return localRotas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public void delete( int idRota )
    {
        try
        {
            StringBuilder sql = new StringBuilder();

            sql.append("DELETE FROM locais_rotas WHERE ref_rota = ?");
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
            pst.setInt(1, idRota );   
            pst.executeUpdate();
        }
        catch( Exception e)
        {

        }
    }
    
    @Override
    public int lastID() 
    {
        int last = 0;
            
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT last_value FROM locais_rotas_id_seq" );
            
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

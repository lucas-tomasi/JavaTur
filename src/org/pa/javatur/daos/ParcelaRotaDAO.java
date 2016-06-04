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
import org.pa.javatur.models.ParcelaRota;

/**
 * @author lucas
 */
public class ParcelaRotaDAO implements DAOInterface<ParcelaRota>
{       
    @Override
    public boolean salvar( ParcelaRota obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO parcelas_rotas ( ref_rota_turista, ref_parcela ) VALUES (?,?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt( 1, obj.getRefRota());
                pst.setInt( 2, obj.getRefParcela());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE parcelas_rotas SET ref_rota_turista = ? , ref_parcela = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt( 1, obj.getRefRota());
                pst.setInt( 2, obj.getRefParcela());
                pst.setInt( 3, obj.getId());
                pst.executeUpdate();
            }
            
            return true;
        }
        catch( Exception e )
        {
            System.err.println("AQUI"+e);
            return false;
        }
    }
    
    @Override
    public ArrayList<ParcelaRota> buscar() 
    {
        try 
        {
            ArrayList<ParcelaRota> parcelas_rotas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM parcelas_rotas ORDER BY id ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    ParcelaRota parcela = new ParcelaRota();
                    
                    parcela.setId(resultado.getInt("id"));
                    parcela.setRefParcela(resultado.getInt("ref_parcela"));
                    parcela.setRefRota(resultado.getInt("ref_rota_turista"));
                    
                    parcelas_rotas.add(parcela);
                }
            }
            return parcelas_rotas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ParcelaRota buscar(int id) 
    {
        try 
        {
            ParcelaRota parcela = new ParcelaRota();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM parcelas_rotas WHERE id = "+ id);

            resultado.next();

            parcela.setId(resultado.getInt("id"));
            parcela.setRefParcela(resultado.getInt("ref_parcela"));
            parcela.setRefRota(resultado.getInt("ref_rota_turista"));

            return parcela;
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
            ArrayList<ParcelaRota> parcelas_rotas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(); 
            ResultSet resultado = st.executeQuery("SELECT * FROM parcelas_rotas WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    ParcelaRota parcela = new ParcelaRota();
                    parcela.setId(resultado.getInt("id"));
                    parcela.setRefParcela(resultado.getInt("ref_parcela"));
                    parcela.setRefRota(resultado.getInt("ref_rota_turista"));
                    parcelas_rotas.add(parcela);
                }
            }
            return parcelas_rotas;
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM parcelas_rotas_id_seq" );
            
            resultado.next();
            last = resultado.getInt("last_value");
            
            return last;
        }
        catch( Exception e )
        {
            return last;
        }
    }
}

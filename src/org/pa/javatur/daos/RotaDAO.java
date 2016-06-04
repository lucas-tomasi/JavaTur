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
import org.pa.javatur.models.Rota;
import org.pa.javatur.models.ConexaoBD;

/**
 * @author lucas
 */
public class RotaDAO implements DAOInterface<Rota>
{          
    @Override
    public boolean salvar( Rota obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO rotas ( descricao , ativo , obs , dt_inicio, dt_fim, vagas, valor ) VALUES (?, ?, ?, ?, ?, ?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo() );
                pst.setString(3, obj.getObs());
                pst.setDate(4, obj.getDtInicio());
                pst.setDate(5, obj.getDtFim());
                pst.setInt(6, obj.getVagas());
                pst.setDouble(7, obj.getValor());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE rotas SET descricao = ? , ativo = ? , obs = ?, dt_inicio = ?, dt_fim = ?, vagas = ?, valor =?  WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getDescricao() );
                pst.setBoolean(2, obj.isAtivo());
                pst.setString(3, obj.getObs());
                pst.setDate(4, obj.getDtInicio());
                pst.setDate(5, obj.getDtFim());
                pst.setInt(6, obj.getVagas());
                pst.setDouble(7, obj.getValor());
                pst.setInt(8, obj.getId());
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
    public ArrayList<Rota> buscar() 
    {
        try 
        {
            ArrayList<Rota> rotas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rotas ORDER BY descricao ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Rota rota = new Rota();
                    rota.setId(resultado.getInt("id"));
                    rota.setAtivo(resultado.getBoolean("ativo"));
                    rota.setDescricao(resultado.getString("descricao"));
                    rota.setObs(resultado.getString("obs"));
                    rota.setDtFim(resultado.getDate("dt_fim"));
                    rota.setDtInicio(resultado.getDate("dt_inicio"));
                    rota.setVagas(resultado.getInt("vagas"));
                    rota.setValor(resultado.getDouble("valor"));
                    rotas.add(rota);
                }
            }
            return rotas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public Rota buscar(int id) 
    {
        try 
        {
            Rota rota = new Rota();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rotas WHERE id = "+ id);

            resultado.next();
            rota.setId(resultado.getInt("id"));
            rota.setAtivo(resultado.getBoolean("ativo"));
            rota.setDescricao(resultado.getString("descricao"));
            rota.setObs(resultado.getString("obs"));
            rota.setDtFim(resultado.getDate("dt_fim"));
            rota.setDtInicio(resultado.getDate("dt_inicio"));
            rota.setVagas(resultado.getInt("vagas"));
            rota.setValor(resultado.getDouble("valor"));
            
            return rota;
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
            ArrayList<Rota> rotas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rotas WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Rota rota = new Rota();
                    rota.setId(resultado.getInt("id"));
                    rota.setAtivo(resultado.getBoolean("ativo"));
                    rota.setDescricao(resultado.getString("descricao"));
                    rota.setObs(resultado.getString("obs"));
                    rota.setDtInicio(resultado.getDate("dt_inicio"));
                    rota.setDtFim(resultado.getDate("dt_fim"));
                    rota.setVagas(resultado.getInt("vagas"));
                    rota.setValor(resultado.getDouble("valor"));
                    rotas.add(rota);
                }
            }
            return rotas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public int getVagasRestantes( Rota rota )
    {
        int total = 0;
       
        RotaTuristaDAO rtDAO = new RotaTuristaDAO();
        
        int rotasVendidas = rtDAO.getCountRotasVendidas(rota.getId());
        
        total = rota.getVagas() - rotasVendidas;
        
        return total;
    }
    
    @Override
    public int lastID() 
    {
        int last = 0;
            
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT last_value FROM rotas_id_seq" );
            
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

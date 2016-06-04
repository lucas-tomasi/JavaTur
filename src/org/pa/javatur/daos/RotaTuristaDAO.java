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
import org.pa.javatur.models.RotaTurista;
import org.pa.javatur.models.ConexaoBD;

/**
 * @author lucas
 */
public class RotaTuristaDAO implements DAOInterface<RotaTurista>
{       
    @Override
    public boolean salvar( RotaTurista obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO rotas_turistas ( ref_turista , ref_rota, status, status_pagamento, dt_inscricao, valor_total, valor_rota, total_parcelas, ref_forma_pagamento ) VALUES (?,?, ?, ?, ?, ?, ?, ?, ? )");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                
                pst.setInt(1, obj.getRefTurista());
                pst.setInt(2,obj.getRefRota());
                pst.setString(3, String.valueOf(obj.getStatus()));
                pst.setString(4, String.valueOf(obj.getStatusPagamento()));
                pst.setDate(5,obj.getDtInscricao());
                pst.setDouble(6,obj.getValorTotal());
                pst.setDouble(7,obj.getValorRota());
                pst.setInt(8,obj.getTotalParcelas());
                pst.setInt(9,obj.getRefFormaPagameto());
                
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE rotas_turistas SET ref_turista = ? , ref_rota = ?, status = ?, status_pagamento = ?, dt_inscricao = ?, valor_total = ?, valor_rota = ?, total_parcelas = ? , ref_forma_pagamento = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getRefTurista());
                pst.setInt(2,obj.getRefRota());
                pst.setString(3, String.valueOf(obj.getStatus()));
                pst.setString(4, String.valueOf(obj.getStatusPagamento()));
                pst.setDate(5,obj.getDtInscricao());
                pst.setDouble(6,obj.getValorTotal());
                pst.setDouble(7,obj.getValorRota());
                pst.setInt(8,obj.getTotalParcelas());
                pst.setInt(9,obj.getRefFormaPagameto());
                pst.setInt(10,obj.getId());
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
    public ArrayList<RotaTurista> buscar() 
    {
        try 
        {
            ArrayList<RotaTurista> rotasTuristas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rotas_turistas ORDER BY id ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    RotaTurista RotaTurista = new RotaTurista();
                    
                    RotaTurista.setId(resultado.getInt("id"));
                    RotaTurista.setDtInscricao(resultado.getDate("dt_inscricao"));
                    RotaTurista.setRefRota(resultado.getInt("ref_rota"));
                    RotaTurista.setRefTurista(resultado.getInt("ref_turista"));
                    RotaTurista.setStatus(resultado.getString("status").charAt(0));
                    RotaTurista.setStatusPagamento(resultado.getString("status_pagamento").charAt(0));
                    RotaTurista.setTotalParcelas(resultado.getInt("total_parcelas"));
                    RotaTurista.setValorRota(resultado.getDouble("valor_rota"));
                    RotaTurista.setValorTotal(resultado.getDouble("valor_total"));
                    RotaTurista.setRefFormaPagameto(resultado.getInt("ref_forma_pagamento"));
                    
                    rotasTuristas.add(RotaTurista);
                }
            }
            return rotasTuristas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public RotaTurista buscar(int id) 
    {
        try 
        {
            RotaTurista RotaTurista = new RotaTurista();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rotas_turistas WHERE id = "+ id);

            resultado.next();
            RotaTurista.setId(resultado.getInt("id"));
            RotaTurista.setDtInscricao(resultado.getDate("dt_inscricao"));
            RotaTurista.setRefRota(resultado.getInt("ref_rota"));
            RotaTurista.setRefTurista(resultado.getInt("ref_turista"));
            RotaTurista.setStatus(resultado.getString("status").charAt(0));
            RotaTurista.setStatusPagamento(resultado.getString("status_pagamento").charAt(0));
            RotaTurista.setTotalParcelas(resultado.getInt("total_parcelas"));
            RotaTurista.setValorRota(resultado.getDouble("valor_rota"));
            RotaTurista.setValorTotal(resultado.getDouble("valor_total"));
            RotaTurista.setRefFormaPagameto(resultado.getInt("ref_forma_pagamento"));
            
            return RotaTurista;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<RotaTurista> buscar(String condicao) 
    {
        try 
        {
            ArrayList<RotaTurista> rotasTuristas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rotas_turistas WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    RotaTurista RotaTurista = new RotaTurista();
                    
                    RotaTurista.setId(resultado.getInt("id"));
                    RotaTurista.setDtInscricao(resultado.getDate("dt_inscricao"));
                    RotaTurista.setRefRota(resultado.getInt("ref_rota"));
                    RotaTurista.setRefTurista(resultado.getInt("ref_turista"));
                    RotaTurista.setStatus(resultado.getString("status").charAt(0));
                    RotaTurista.setStatusPagamento(resultado.getString("status_pagamento").charAt(0));
                    RotaTurista.setTotalParcelas(resultado.getInt("total_parcelas"));
                    RotaTurista.setValorRota(resultado.getDouble("valor_rota"));
                    RotaTurista.setValorTotal(resultado.getDouble("valor_total"));
                    RotaTurista.setRefFormaPagameto(resultado.getInt("ref_forma_pagamento"));
                    
                    rotasTuristas.add(RotaTurista);
                }
            }
            return rotasTuristas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public int getCountRotasVendidas( int idRota )
    {
        int count = 0;
        
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT count(id) as qtde FROM rotas_turistas WHERE status <> 'C' AND ref_rota = "+ idRota);
            resultado.next();
            count = resultado.getInt("qtde");
        }
        catch( Exception e)
        {
            System.err.println(e);
            return 0;
        }
        
        return count;
    }
    
    @Override
    public int lastID() 
    {
        int last = 0;
            
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT last_value FROM rotas_turistas_id_seq" );
            
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

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
import org.pa.javatur.models.Parcela;
import org.pa.javatur.models.PessoaFisica;
import org.pa.javatur.models.Rota;

/**
 * @author lucas
 */
public class ParcelaDAO implements DAOInterface<Parcela>
{       
    private final PessoaFisicaDAO pDAO;
    private final RotaDAO         rDAO;
    
    public ParcelaDAO()
    {
        pDAO = new PessoaFisicaDAO();
        rDAO = new RotaDAO();
    }
    @Override
    public boolean salvar( Parcela obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO parcelas ( valor_estimado,status_pagamento,valor_realizado,dt_pagamento,dt_vencimento,parcela ) VALUES (?,?,?,?,?,?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setDouble( 1, obj.getValorEstimado());
                pst.setString( 2, String.valueOf(obj.getStatusPagamento()));
                pst.setDouble( 3, obj.getValorRealizado() );
                pst.setDate( 4, obj.getDtPagamento() );
                pst.setDate( 5, obj.getDtVencimento());
                pst.setInt( 6, obj.getParcela());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE parcelas SET valor_estimado = ? , status_pagamento = ?,valor_realizado = ?, dt_pagamento = ?,dt_vencimento = ?,parcela =? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setDouble( 1, obj.getValorEstimado());
                pst.setString( 2, String.valueOf(obj.getStatusPagamento()));
                pst.setDouble( 3, obj.getValorRealizado() );
                pst.setDate( 4, obj.getDtPagamento() );
                pst.setDate( 5, obj.getDtVencimento());
                pst.setInt( 6, obj.getParcela());
                pst.setInt(7, obj.getId());
                pst.executeUpdate();
            }
            
            return true;
        }
        catch( Exception e )
        {
            System.err.println("OPA"+e);
            return false;
        }
    }
    
    @Override
    public ArrayList<Parcela> buscar() 
    {
        try 
        {
            ArrayList<Parcela> parcelas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM parcelas ORDER BY dt_pagamento ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Parcela parcela = new Parcela();
                    parcela.setId(resultado.getInt("id"));
                    parcela.setDtPagamento(resultado.getDate("dt_pagamento"));
                    parcela.setDtVencimento(resultado.getDate("dt_vencimento"));
                    parcela.setParcela(resultado.getInt("parcela"));
                    parcela.setStatusPagamento(resultado.getString("status_pagamento").charAt(0) );
                    parcela.setValorEstimado(resultado.getDouble("valor_estimado"));
                    parcela.setValorRealizado(resultado.getDouble("valor_realizado"));
                    
                    parcelas.add(parcela);
                }
            }
            return parcelas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public Parcela buscar(int id) 
    {
        try 
        {
            Parcela parcela = new Parcela();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM parcelas WHERE id = "+ id);

            resultado.next();
            parcela.setId(resultado.getInt("id"));
            parcela.setDtPagamento(resultado.getDate("dt_pagamento"));
            parcela.setDtVencimento(resultado.getDate("dt_vencimento"));
            parcela.setParcela(resultado.getInt("parcela"));
            parcela.setStatusPagamento(resultado.getString("status_pagamento").charAt(0) );
            parcela.setValorEstimado(resultado.getDouble("valor_estimado"));
            parcela.setValorRealizado(resultado.getDouble("valor_realizado"));
            
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
            ArrayList<Parcela> parcelas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement(); 
            ResultSet resultado = st.executeQuery("SELECT * FROM parcelas WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Parcela parcela = new Parcela();
                    parcela.setId(resultado.getInt("id"));
                    parcela.setDtPagamento(resultado.getDate("dt_pagamento"));
                    parcela.setDtVencimento(resultado.getDate("dt_vencimento"));
                    parcela.setParcela(resultado.getInt("parcela"));
                    parcela.setStatusPagamento(resultado.getString("status_pagamento").charAt(0) );
                    parcela.setValorEstimado(resultado.getDouble("valor_estimado"));
                    parcela.setValorRealizado(resultado.getDouble("valor_realizado"));
                    parcelas.add(parcela);
                }
            }
            return parcelas;
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM parcelas_id_seq" );
            
            resultado.next();
            last = resultado.getInt("last_value");
            
            return last;
        }
        catch( Exception e )
        {
            return last;
        }
    }
    
    public PessoaFisica getTurista( int idParcela )
    {
        String filtro = " id = ( SELECT ref_turista "
                + "                FROM rotas_turistas rt, "
                + "                     parcelas_rotas rp "
                + "               WHERE rt.id = rp.ref_rota_turista "
                + "                 AND ref_parcela ="+idParcela+")";
        ArrayList<PessoaFisica> turistas = pDAO.buscar( filtro );
        PessoaFisica turista = turistas.get(0);
     
        return turista;
    }
    
    public Rota getRota( int idParcela )
    {
        String filtro = " id = ( SELECT ref_rota"
                + "                FROM rotas_turistas rt, "
                + "                     parcelas_rotas rp "
                + "               WHERE rt.id = rp.ref_rota_turista "
                + "                 AND ref_parcela ="+idParcela+")";
        ArrayList<Rota> rotas = rDAO.buscar( filtro );
        Rota rota = rotas.get(0);
     
        return rota;
    }
    /**
     * 
     * @param idParcela Codigo da parcela
     * @return id da rota para alterar o status;
     */
    public int isUltimaParcela( int idParcela ) 
    {
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "SELECT ref_rota_turista "
                       + "  FROM parcelas       p, "
                       + "       parcelas_rotas pr "
                       + " WHERE p.parcela = ( SELECT MAX(parcela) "
                       + "                       FROM parcelas "
                       + "                      WHERE id IN ( SELECT ref_parcela "
                       + "                                      FROM parcelas_rotas "
                       + "                                     WHERE ref_rota_turista = ( SELECT ref_rota_turista "
                       + "                                                                  FROM parcelas_rotas "
                       + "                                                                  WHERE ref_parcela = "+idParcela+" )) "
                       + "                       AND p.id = "+idParcela
                       + "                       AND p.id = pr.ref_parcela )";

            ResultSet resultado = st.executeQuery(sql);

            resultado.next();
            return resultado.getInt(1);
        }
        catch(Exception e)
        {
            System.err.println(e);
            return 0;
        }
    }
}

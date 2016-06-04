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
import org.pa.javatur.models.AtividadeRotaTurista;
import org.pa.javatur.models.ConexaoBD;

/**
 *
 * @author lucas
 */
public class AtividadeRotaTuristaDAO implements DAOInterface<AtividadeRotaTurista>
{
    @Override
    public boolean salvar( AtividadeRotaTurista obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO atividades_rotas_turistas ( ref_atividade, ref_rota_turista, valor ) VALUES (?, ?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getRefAtividade());
                pst.setInt(2, obj.getRefRotaTurista());
                pst.setDouble(3, obj.getValor());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE atividades_rotas_turistas SET ref_atividade = ? , ref_rota_turista = ? , valor = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getRefAtividade());
                pst.setInt(2, obj.getRefRotaTurista());
                pst.setDouble(3, obj.getValor());
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
    public AtividadeRotaTurista buscar(int id) 
    {
        try
        {
            AtividadeRotaTurista atLocal = new AtividadeRotaTurista();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_rotas_turistas WHERE id = "+ id);
            
            resultado.next();
            
            AtividadeRotaTurista tipoAtividadeRotaTurista = new AtividadeRotaTurista();

            tipoAtividadeRotaTurista.setId(resultado.getInt("id"));
            tipoAtividadeRotaTurista.setRefAtividade(resultado.getInt("ref_atividade"));
            tipoAtividadeRotaTurista.setRefRotaTurista(resultado.getInt("ref_rota_turista"));
            tipoAtividadeRotaTurista.setValor(resultado.getDouble("valor"));
            
            return atLocal;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<AtividadeRotaTurista> buscar(String filtro) 
    {
        try 
        {
            ArrayList<AtividadeRotaTurista> atividadesRotas = new ArrayList<>();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_rotas_turistas WHERE "+ filtro );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    AtividadeRotaTurista tipoAtividadeRotaTurista = new AtividadeRotaTurista();
                    
                    
                    tipoAtividadeRotaTurista.setId(resultado.getInt("id"));
                    tipoAtividadeRotaTurista.setRefAtividade(resultado.getInt("ref_atividade"));
                    tipoAtividadeRotaTurista.setRefRotaTurista(resultado.getInt("ref_rota_turista"));
                    tipoAtividadeRotaTurista.setValor(resultado.getDouble("valor"));
                    atividadesRotas.add(tipoAtividadeRotaTurista);
                }
            }
            return atividadesRotas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<AtividadeRotaTurista> buscar() 
    {
        try 
        {
            ArrayList<AtividadeRotaTurista> atividadesRotas = new ArrayList<>();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_rotas_turistas" );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    AtividadeRotaTurista tipoAtividadeRotaTurista = new AtividadeRotaTurista();
                    
                    
                    tipoAtividadeRotaTurista.setId(resultado.getInt("id"));
                    tipoAtividadeRotaTurista.setRefAtividade(resultado.getInt("ref_atividade"));
                    tipoAtividadeRotaTurista.setRefRotaTurista(resultado.getInt("ref_rota_turista"));
                    tipoAtividadeRotaTurista.setValor(resultado.getDouble("valor"));
                    atividadesRotas.add(tipoAtividadeRotaTurista);
                }
            }
            return atividadesRotas;
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM atividades_rotas_turistas_id_seq" );
            
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

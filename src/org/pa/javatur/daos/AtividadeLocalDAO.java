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
import org.pa.javatur.models.AtividadeLocal;
import org.pa.javatur.models.ConexaoBD;

/**
 *
 * @author lucas
 */
public class AtividadeLocalDAO implements DAOInterface<AtividadeLocal>
{
    @Override
    public boolean salvar( AtividadeLocal obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO atividades_locais ( ref_local, ref_atividade , hr_ini, hr_fim, valor ) VALUES (?, ?, ?, ?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getLocal());
                pst.setInt(2, obj.getAtividade());
                pst.setTime(3, obj.getHrIni());
                pst.setTime(4, obj.getHrFim());
                pst.setDouble(5, obj.getValor());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE atividades_locais SET ref_local = ? , ref_atividade = ? , hr_ini = ? , hr_fim = ? , valor = ? WHERE id = ?");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setInt(1, obj.getLocal());
                pst.setInt(2, obj.getAtividade());
                pst.setTime(3, obj.getHrIni());
                pst.setTime(4, obj.getHrFim());
                pst.setDouble(5, obj.getValor());
                pst.setInt(6, obj.getId());
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

    public ArrayList<AtividadeLocal> buscarLocaisAtividade( int id ) 
    {
        try 
        {       
            ArrayList<AtividadeLocal> atividadesLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_locais WHERE ref_atividade = "+ id);

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    AtividadeLocal tipoAtividadeLocal = new AtividadeLocal();
                    
                    tipoAtividadeLocal.setId(resultado.getInt("id"));
                    tipoAtividadeLocal.setLocal(resultado.getInt("ref_local"));
                    tipoAtividadeLocal.setAtividade(resultado.getInt("ref_atividade"));
                    tipoAtividadeLocal.setHrFim(resultado.getTime("hr_fim"));
                    tipoAtividadeLocal.setHrIni(resultado.getTime("hr_ini"));
                    tipoAtividadeLocal.setValor(resultado.getDouble("valor"));
                    
                    atividadesLocais.add(tipoAtividadeLocal);
                }
            }
            return atividadesLocais;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    public ArrayList<AtividadeLocal> buscarAtividadesLocal(int id) 
    {
        try 
        {       
            ArrayList<AtividadeLocal> atividadesLocais = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_locais WHERE ref_local = "+ id);

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    AtividadeLocal tipoAtividadeLocal = new AtividadeLocal();
                    
                    tipoAtividadeLocal.setId(resultado.getInt("id"));
                    tipoAtividadeLocal.setLocal(resultado.getInt("ref_local"));
                    tipoAtividadeLocal.setAtividade(resultado.getInt("ref_atividade"));
                    tipoAtividadeLocal.setHrFim(resultado.getTime("hr_fim"));
                    tipoAtividadeLocal.setHrIni(resultado.getTime("hr_ini"));
                    tipoAtividadeLocal.setValor(resultado.getDouble("valor"));
                    
                    atividadesLocais.add(tipoAtividadeLocal);
                }
            }
            return atividadesLocais;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String obterDescricoesAtividadesLocais( int local)
    {
        String desc = "";
        
        AtividadeDAO dao = new AtividadeDAO();
        
        ArrayList<AtividadeLocal> atividadesLocal = buscarAtividadesLocal(local);
        
        if( atividadesLocal != null )
        {
            for (int i = 0; i < atividadesLocal.size(); i++) 
            {
                String comp = ( i < ( atividadesLocal.size() - 1 ) )? ", ": "";
                AtividadeLocal al = atividadesLocal.get(i);
                Atividade at = dao.buscar(al.getAtividade());
                desc+=at.getDescricao()+comp;
            }
        }           
        return desc;
    }

    @Override
    public AtividadeLocal buscar(int id) 
    {
        try
        {
            AtividadeLocal atLocal = new AtividadeLocal();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_locais WHERE ref_atividade = "+ id);
            
            resultado.next();
            
            AtividadeLocal tipoAtividadeLocal = new AtividadeLocal();

            tipoAtividadeLocal.setId(resultado.getInt("id"));
            tipoAtividadeLocal.setLocal(resultado.getInt("ref_local"));
            tipoAtividadeLocal.setAtividade(resultado.getInt("ref_atividade"));
            tipoAtividadeLocal.setHrFim(resultado.getTime("hr_fim"));
            tipoAtividadeLocal.setHrIni(resultado.getTime("hr_ini"));
            tipoAtividadeLocal.setValor(resultado.getDouble("valor"));
            
            return atLocal;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<AtividadeLocal> buscar(String filtro) 
    {
        try 
        {
            ArrayList<AtividadeLocal> atividadesLocais = new ArrayList<>();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_locais WHERE "+ filtro );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    AtividadeLocal tipoAtividadeLocal = new AtividadeLocal();
                    
                    tipoAtividadeLocal.setId(resultado.getInt("id"));
                    tipoAtividadeLocal.setLocal(resultado.getInt("ref_local"));
                    tipoAtividadeLocal.setAtividade(resultado.getInt("ref_atividade"));
                    tipoAtividadeLocal.setHrFim(resultado.getTime("hr_fim"));
                    tipoAtividadeLocal.setHrIni(resultado.getTime("hr_ini"));
                    tipoAtividadeLocal.setValor(resultado.getDouble("valor"));
                    
                    atividadesLocais.add(tipoAtividadeLocal);
                }
            }
            return atividadesLocais;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public ArrayList<AtividadeLocal> buscar() 
    {
        try 
        {
            ArrayList<AtividadeLocal> atividadesLocais = new ArrayList<>();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM atividades_locais" );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    AtividadeLocal tipoAtividadeLocal = new AtividadeLocal();
                    
                    tipoAtividadeLocal.setId(resultado.getInt("id"));
                    tipoAtividadeLocal.setLocal(resultado.getInt("ref_local"));
                    tipoAtividadeLocal.setAtividade(resultado.getInt("ref_atividade"));
                    tipoAtividadeLocal.setHrFim(resultado.getTime("hr_fim"));
                    tipoAtividadeLocal.setHrIni(resultado.getTime("hr_ini"));
                    tipoAtividadeLocal.setValor(resultado.getDouble("valor"));
                    
                    atividadesLocais.add(tipoAtividadeLocal);
                }
            }
            return atividadesLocais;
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM atividades_locais_id_seq" );
            
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
    
    public boolean excluirAtividades( int idLocal )
    {
        try
        {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM atividades_locais WHERE ref_local = ?");
            PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
            pst.setInt(1, idLocal);
            pst.executeUpdate();
        }
        catch(Exception e)
        {
            System.err.println(e);
            return false;
        }
       
       return true;
    }
}

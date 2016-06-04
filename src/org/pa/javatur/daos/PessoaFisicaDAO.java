/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.daos;

import org.pa.javatur.interfaces.DAOInterface;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.ConexaoBD;
import org.pa.javatur.models.PessoaFisica;

/**
 * @author lucas
 */
public class PessoaFisicaDAO implements DAOInterface<PessoaFisica>
{       
    public boolean salvar( PessoaFisica obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
           
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO pessoas_fisicas ( nome, cpf, dt_nascimento, sexo, email, telefone, ativo ) VALUES (?, ?, ?, ?, ?, ?,?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getNome());
                pst.setString(2, obj.getCpf());
                pst.setDate(3, obj.getDtNascimento() );
                pst.setString(4, String.valueOf(obj.getSexo()));
                pst.setString(5, obj.getEmail() );
                pst.setString(6, obj.getTelefone());
                pst.setBoolean(7, obj.isAtivo());
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE pessoas_fisicas SET nome = ? , cpf = ?, dt_nascimento = ?, sexo = ?, email = ?, telefone = ?, ativo = ? WHERE id = ?");                
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getNome());
                pst.setString(2, obj.getCpf());
                pst.setDate(3, obj.getDtNascimento() );
                pst.setString(4, String.valueOf(obj.getSexo()));
                pst.setString(5, obj.getEmail() );
                pst.setString(6, obj.getTelefone());
                pst.setBoolean(7, obj.isAtivo());
                pst.setInt( 8 , obj.getId());

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

    public ArrayList<PessoaFisica> buscar() 
    {
        try 
        {
            ArrayList<PessoaFisica> pessoas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM pessoas_fisicas ORDER BY nome ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    PessoaFisica pessoa = new PessoaFisica();
                    pessoa.setId(resultado.getInt("id"));
                    pessoa.setEmail(resultado.getString("email"));
                    pessoa.setNome(resultado.getString("nome"));
                    pessoa.setAtivo(resultado.getBoolean("ativo"));
                    pessoa.setTelefone(resultado.getString("telefone"));
                    pessoa.setCpf(Util.formatarCPF(resultado.getString("cpf")));
                    pessoa.setSexo(resultado.getString("sexo").charAt(0));
                    pessoa.setDtNascimento(Date.valueOf(resultado.getString("dt_nascimento")));
                    
                    pessoas.add(pessoa);
                }
            }
            return pessoas;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    public PessoaFisica buscar(int id) 
    {
        try 
        {
            PessoaFisica pessoa = new PessoaFisica();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM pessoas_fisicas WHERE id = "+ id);

            resultado.next();               
            pessoa.setId(resultado.getInt("id"));
            pessoa.setEmail(resultado.getString("email"));
            pessoa.setNome(resultado.getString("nome"));
            pessoa.setAtivo(resultado.getBoolean("ativo"));
            pessoa.setTelefone(resultado.getString("telefone"));
            pessoa.setCpf(resultado.getString("cpf"));
            pessoa.setSexo(resultado.getString("sexo").charAt(0));
            pessoa.setDtNascimento(Date.valueOf(resultado.getString("dt_nascimento")));
            
            return pessoa;
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
            ArrayList<PessoaFisica> pessoas = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM pessoas_fisicas WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    PessoaFisica pessoa = new PessoaFisica();
                    pessoa.setId(resultado.getInt("id"));
                    pessoa.setEmail(resultado.getString("email"));
                    pessoa.setNome(resultado.getString("nome"));
                    pessoa.setAtivo(resultado.getBoolean("ativo"));
                    pessoa.setTelefone(resultado.getString("telefone"));
                    pessoa.setCpf(Util.formatarCPF(resultado.getString("cpf")));
                    pessoa.setSexo(resultado.getString("sexo").charAt(0));
                    pessoa.setTelefone(resultado.getString("telefone"));
                    pessoa.setDtNascimento(Date.valueOf(resultado.getString("dt_nascimento")));
                    
                    pessoas.add(pessoa);
                }
            }
            return pessoas;
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM pessoas_fisicas_id_seq" );
            
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

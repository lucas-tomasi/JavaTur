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
import org.pa.javatur.javatur.Util;
import org.pa.javatur.models.ConexaoBD;
import org.pa.javatur.models.Usuario;

/**
 * @author lucas
 */
public class UsuarioDAO implements DAOInterface<Usuario>
{       
    public boolean salvar( Usuario obj) 
    {
        try
        {
            StringBuilder sql = new StringBuilder();
           
            if ( obj.getId() == 0 ) 
            {
                sql.append("INSERT INTO usuarios ( nome, email, senha, login , ativo ) VALUES (?, ?, ?, ?, ?)");
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( sql.toString() );
                pst.setString(1, obj.getNome());
                pst.setString(2, obj.getEmail());
                pst.setString(3, Util.gerarHash(obj.getSenha(), "SHA-1"));
                pst.setString(4, obj.getLogin());
                pst.setBoolean(5, obj.isAtivo() );
                pst.executeUpdate();
            }
            else
            {
                sql.append("UPDATE usuarios SET nome = ? ,email = ? ,login = ? ,ativo = ?,senha = ? WHERE id = ?");
                
                String newSql = sql.toString();
                int posicao = 6; // Verifica se precisa alterar a senha
                if( obj.getSenha().equalsIgnoreCase("") )
                {
                    newSql = newSql.replace(",senha = ?", "");
                    posicao = 5;
                }
                
                PreparedStatement pst = ConexaoBD.getInstance().getConnection().prepareStatement( newSql );
                pst.setString(1, obj.getNome());
                pst.setString(2, obj.getEmail());
                pst.setString(3, obj.getLogin());
                pst.setBoolean(4, obj.isAtivo() );
                if( posicao == 6)
                {
                    pst.setString(5, Util.gerarHash(obj.getSenha(), "SHA-1"));
                }
                pst.setInt( posicao , obj.getId());

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

    public ArrayList<Usuario> buscar() 
    {
        try 
        {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuarios ORDER BY nome ASC");

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setEmail(resultado.getString("email"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setAtivo(resultado.getBoolean("ativo"));
                    usuario.setSenha(resultado.getString("senha"));
                    
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }

    public Usuario buscar(int id) 
    {
        try 
        {
            Usuario usuario = new Usuario();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuarios WHERE id = "+ id);

            resultado.next();               
            usuario.setId(resultado.getInt("id"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setLogin(resultado.getString("login"));
            usuario.setSenha(resultado.getString("senha"));
            usuario.setAtivo(resultado.getBoolean("ativo"));
          
            return usuario;
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
            ArrayList<Usuario> usuarios = new ArrayList<>();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM usuarios WHERE " + condicao );

            if (resultado.isBeforeFirst()) 
            {
                while (resultado.next()) 
                {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setEmail(resultado.getString("email"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setAtivo(resultado.getBoolean("ativo"));
                    
                    usuarios.add(usuario);
                }
            }
            return usuarios;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public Usuario validar( String login, String senha )
    {
        try
        {
            Usuario usuario = new Usuario();
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT * "
                                                 +"  FROM usuarios "
                                                 +" WHERE login = '" + login + "'" 
                                                 +"   AND senha = '" + Util.gerarHash(senha, "SHA-1") + "'");


            resultado.next();
            usuario.setId(resultado.getInt("id"));
            usuario.setEmail(resultado.getString("email"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setLogin(resultado.getString("login"));
            usuario.setAtivo(resultado.getBoolean("ativo"));            
            return usuario;
        }
        catch( Exception e )
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
            ResultSet resultado = st.executeQuery("SELECT last_value FROM usuarios_id_seq" );
            
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
    
    public boolean validarLogin( String login, int id )
    {
        try
        {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            ResultSet resultado = st.executeQuery("SELECT login FROM usuarios WHERE login = '"+login+"' AND id <> "+ id );

            
            if( resultado.next() )
            {
                return false;
            }
        }
        catch( Exception e )
        {
            System.err.println(e);
            return false;
        }
        return true;
    }
}

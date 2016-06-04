/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.javatur;
import javax.swing.JOptionPane;
import org.pa.javatur.models.ConexaoBD;
import org.pa.javatur.views.LoginView;

/**
 *
 * @author lucas
 */
public class JavaTur 
{
    public static void main(String[] args) 
    {
        if ( ConexaoBD.getInstance().getConnection() != null ) 
        {
            new LoginView();
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inicializar o Software", "Error", 0);
        }
    }
}

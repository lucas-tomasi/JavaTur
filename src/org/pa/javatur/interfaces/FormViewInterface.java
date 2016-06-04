/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.interfaces;

/**
 *
 * @author lucas
 */
public interface FormViewInterface <T>
{
    public boolean verificarCampos();
    public void limparCampos();
    public boolean salvar(T object);
}

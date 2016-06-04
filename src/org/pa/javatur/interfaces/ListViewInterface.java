/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.interfaces;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface ListViewInterface <T> 
{
    public void atualizarTabela();
    public void redimencionarTabela( int tamanho );
    public String obterFiltros();
    public ArrayList<T> buscar( String filtro );
    public void editar();
}

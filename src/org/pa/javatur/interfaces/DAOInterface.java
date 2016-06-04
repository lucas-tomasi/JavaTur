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
public interface DAOInterface <T> 
{
    public boolean salvar( T object );
    public T buscar( int id );
    public ArrayList<T> buscar( String filtro );
    public ArrayList<T> buscar();
    public int lastID();
}

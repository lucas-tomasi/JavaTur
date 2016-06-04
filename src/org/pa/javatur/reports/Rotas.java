/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.reports;

import javax.swing.JOptionPane;
import org.pa.javatur.itext.Relatorio;
import org.pa.javatur.itext.Sql;

/**
 *
 * @author lucas
 */
public class Rotas 
{

    public Rotas() 
    {
        try
        {
            Sql sql = new Sql();
            sql.addColuna( "r.id ");
            sql.addColuna( "r.descricao ");
            sql.addColuna( "replace(replace(substring( array( SELECT l.descricao FROM locais l , locais_rotas lr WHERE lr.ref_local = l.id AND lr.ref_rota = r.id )::text ,2 ) , '}',''),'\"','')");
            sql.addColuna( "to_char(r.dt_inicio,'DD/MM/YYYY') ");
            sql.addColuna( "to_char(r.dt_fim,'DD/MM/YYYY') ");
            sql.addColuna( "'R$ '||round(r.valor,2)");
            sql.addColuna( "(SELECT count(*) FROM rotas_turistas rt where rt.ref_rota = r.id and status <> 'C') || ' de ' ||r.vagas");
            sql.addTabela("rotas r");
            sql.addConstraint("","r.ativo","",null); 
            sql.addConstraint("date(now())", " BETWEEN "," dt_inicio AND dt_fim ","AND");

            String resultado[][] = sql.get();
            String[] cabecalho   = {"Cód.","Descrição","Locais","Início","Fim","Valor","Vagas"};
            float[] colunas      = {0.10f,0.20f,0.30f,0.10f,0.10f,0.10f,0.10f};    
            int aligns[]         = {Relatorio.RIGHT,Relatorio.LEFT,Relatorio.LEFT,Relatorio.RIGHT,Relatorio.RIGHT,Relatorio.RIGHT,Relatorio.RIGHT};
            
            Relatorio r = new Relatorio( "Rotas Ativas", colunas, cabecalho, resultado, true);
            r.setAligns(aligns);
            r.generatePDF();
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog(null, "Houve um erro ao gerar esse relatório","erro",JOptionPane.ERROR_MESSAGE );
            System.err.println(e.getMessage());
        }
    }    
}

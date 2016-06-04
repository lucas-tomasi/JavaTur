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
public class Parcelas 
{
    
    public Parcelas( String dt_final, String situacao , String idPessoaFisica ) 
    {        
        try
        {            
            Sql sql = new Sql();
            sql.addColuna("pf.nome");
            sql.addColuna("r.descricao");
            sql.addColuna("'R$ ' || round(rt.valor_total::numeric , 2 )");
            sql.addColuna("'R$ ' || round(p.valor_estimado::numeric , 2 )");
            sql.addColuna("to_char( p.dt_vencimento , 'DD/MM/YYYY' )");
            sql.addColuna("p.parcela || ' de ' ||rt.total_parcelas");
            sql.addColuna("( CASE WHEN p.status_pagamento = 'P'"
                                 +"THEN 'Paga'"
                               +"WHEN p.status_pagamento = 'A'"
                                 +"THEN 'Aberta'"
                               +"ELSE 'Cancelada' END )");
            sql.addTabela("parcelas p");
            sql.addTabela("parcelas_rotas pr");
            sql.addTabela("rotas_turistas rt");
            sql.addTabela("pessoas_fisicas pf");
            sql.addTabela("rotas r");
            sql.addConstraint(" r.id ", "=", "rt.ref_rota", null );
            sql.addConstraint(" pf.id ", "=", "rt.ref_turista", "and");
            sql.addConstraint(" pr.ref_rota_turista ", "=", "rt.id", "and");
            sql.addConstraint(" pr.ref_parcela ", "=", "p.id", "and");
            
            if( !dt_final.trim().equalsIgnoreCase("-  -") )
            {
                sql.addConstraint(" p.dt_vencimento", "=", "'"+dt_final+"'" , "and");
            }
            
            if( !idPessoaFisica.equalsIgnoreCase("0") )
            {
                sql.addConstraint(" rt.ref_turista", "=", idPessoaFisica, "and");
            }
            
            if( !situacao.equalsIgnoreCase("") )
            {
                sql.addConstraint(" p.status_pagamento", "=", "'"+situacao+"'", "and");
            }
            
            
            String[][] valores = sql.get();
            
            String[] cabecalho = {"Nome","Rota","Total","Valor","Dt. Venc.","Parcela","Situação"};
            
            float[] colunas = {0.20f,0.20f,0.10f,0.10f,0.10f,0.15f,0.15f};
            
            Relatorio relatorio = new Relatorio( "Parcelas", colunas, cabecalho, valores,false);
            relatorio.setAligns( Relatorio.LEFT , Relatorio.LEFT , Relatorio.RIGHT , Relatorio.RIGHT , Relatorio.RIGHT , Relatorio.RIGHT , Relatorio.LEFT );
            relatorio.generatePDF();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Houve um erro ao gerar esse relatório","erro",JOptionPane.ERROR_MESSAGE );
            System.err.println(e.getMessage());
        }
    }
}

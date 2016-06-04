package org.pa.javatur.reports;

import javax.swing.JOptionPane;
import org.pa.javatur.itext.Relatorio;
import org.pa.javatur.itext.Sql;

/**
 *
 * @author lucas
 */
public class Vendas 
{

    public Vendas( String idRota, String idPessoaFisica, String de, String ate, String situacao ) 
    {
        try
        {
            Sql sql = new Sql();
            
            sql.addColuna("pf.nome");
            sql.addColuna("r.descricao"); 
            sql.addColuna("'R$ ' || round( rt.valor_total, 2)");
            sql.addColuna("TO_CHAR(rt.dt_inscricao,'DD/MM/YYYY')");
            sql.addColuna("( SELECT count(*) FROM atividades_rotas_turistas WHERE ref_rota_turista = rt.id )");
            sql.addColuna("CASE WHEN rt.status = 'C' THEN 'Cancelada' WHEN rt.status = 'M' THEN 'Marcada' ELSE 'Concluida' END");
            sql.addTabela("pessoas_fisicas pf");
            sql.addTabela("rotas r");
            sql.addTabela("rotas_turistas rt");
            sql.addConstraint("pf.id", "=", "rt.ref_turista", null);
            sql.addConstraint("r.id", "=", "rt.ref_rota", "AND" );
            
            if( !de.equalsIgnoreCase("") && !ate.equalsIgnoreCase("") )
            {
                sql.addConstraint("rt.dt_inscricao", " BETWEEN ", "'"+de+"' AND '"+ate+"'" , "AND");
            }
            
            if( !idPessoaFisica.trim().equalsIgnoreCase("0") )
            {
                sql.addConstraint("pf.id", "=", idPessoaFisica , "AND");
            }
            
            if( !idRota.trim().equalsIgnoreCase("0") )
            {
                sql.addConstraint("r.id", "=", idRota , "AND");
            }
            
            if( !situacao.trim().equalsIgnoreCase("") )
            {
                sql.addConstraint("rt.status_pagamento", "=", "'"+situacao+"'" , "AND");
            }
            
            String valores[][] = sql.get();
            String cabecalho[] = {"Nome","Rota","Valor","Data","Qtde Ativ.","Status"};
            float  colunas[]   = {0.30f,0.20f,0.20f,0.10f,0.10f,0.10f};
            int    aligns[]    = {Relatorio.LEFT,Relatorio.LEFT,Relatorio.RIGHT,Relatorio.RIGHT,Relatorio.RIGHT,Relatorio.LEFT};

            Relatorio r = new Relatorio("Vendas", colunas, cabecalho, valores, true);
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

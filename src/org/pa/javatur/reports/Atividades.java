package org.pa.javatur.reports;

import javax.swing.JOptionPane;
import org.pa.javatur.itext.Relatorio;
import org.pa.javatur.itext.Sql;

/**
 *
 * @author lucas
 */
public class Atividades 
{

    public Atividades() 
    {
        try
        {
            Sql sql = new Sql();       

            sql.addColuna("a.id");
            sql.addColuna("a.descricao");
            sql.addColuna("(select count(*) from (select distinct ref_rota, al.ref_atividade from atividades_locais al, locais_rotas lr where lr.ref_local = al.ref_local and al.ref_atividade = a.id ) as foo) || ' de ' || (SELECT count(*) FROM rotas) as too");
            sql.addColuna("( SELECT count(*) FROM atividades_rotas_turistas WHERE ref_atividade = a.id )");
            sql.addTabela("atividades a");
            
            String valores [][] = sql.get();
            String cabecalho[]  = {"Cód.","Descrição","Qtde em Rotas","Vendidas"};
            float  colunas[]    = {0.20f,0.40f,0.20f,0.20f};
            int    aligns[]     = {Relatorio.RIGHT,Relatorio.LEFT,Relatorio.RIGHT,Relatorio.RIGHT};
                    
            Relatorio r = new Relatorio( "Atividades", colunas, cabecalho, valores, true);
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

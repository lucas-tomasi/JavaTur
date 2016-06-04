package org.pa.javatur.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import org.pa.javatur.javatur.Util;

public class Relatorio extends AbstractReport
{
    
    public static final Integer LEFT   = Element.ALIGN_LEFT;
    public static final Integer CENTER = Element.ALIGN_CENTER;
    public static final Integer RIGHT  = Element.ALIGN_RIGHT;
    
    private final float[]    colunas;
    private final String[]   cabecalho;
    private final String[][] valores;
    private final String     titulo;
    private Table      tabela;
    private String     subTitle;
    private BaseColor  cor; 
    private int[]      aligns;
    
    public Relatorio( String titulo, float[] colunas, String[] cabecalho, String[][] valores, boolean horizontal )
    {
        super(horizontal);
        this.titulo    = titulo;
        this.cabecalho = cabecalho;
        this.valores   = valores;
        this.colunas   = colunas;
        
        aligns = new int[colunas.length];
        for( int i = 0; i < colunas.length; i++ )
        {
            aligns[i] = CENTER;
        }
    }
    /**
    * @param aligns 
    */  
    public void setAligns( int... aligns )
    {
        this.aligns = aligns;
    }
    
    public void setSubTitle( String subTitle )
    {
        this.subTitle = subTitle;
    }
    
    @Override
    protected void generateDocument(Document document) throws Exception 
    {
        setTitle(this.titulo,Util.getLogo());
        
        if( this.subTitle != null )
        {
            setSubTitle(this.subTitle);
        }
        else
        {
            newLine();
        }
        
        this.tabela = new Table( this.colunas );

        this.tabela.setHeader( this.cabecalho );
        
        this.tabela.setAligns(aligns);
                
        preencherTabela();
                
        document.add(this.tabela);
        
        newLine();
        
        Paragraph paragraph = new Paragraph();
        paragraph.add( new Chunk( "Total:  " + valores.length + "  registros", fontRow ) );
        paragraph.setAlignment( Paragraph.ALIGN_RIGHT );
        paragraph.setSpacingAfter( 2f );

        
        document.add(paragraph );
    }
    
    private void preencherTabela()
    {
        for( String[] arrayValores : this.valores )
        {
            this.tabela.addRow((Object[]) arrayValores);
        }
    }
}

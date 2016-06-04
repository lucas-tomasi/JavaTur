package org.pa.javatur.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.pa.javatur.javatur.Util;

/**
 * @author artur
 */
public abstract  class AbstractReport 
{
    protected BaseColor color = BaseColor.BLACK;
    
    protected Font fontHead     = new Font( Font.FontFamily.HELVETICA  , 10, Font.BOLD, BaseColor.BLACK );
    protected Font fontRow      = new Font( Font.FontFamily.HELVETICA  , 8,  Font.NORMAL );
    protected Font fontTitle    = new Font( Font.FontFamily.HELVETICA  , 18, Font.BOLD, color );
    protected Font fontSubTitle = new Font( Font.FontFamily.HELVETICA  , 14, Font.BOLD, color );
     
    protected DateFormat   df   = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
    protected NumberFormat nf   = NumberFormat.getCurrencyInstance( new Locale("pt-BR") );
    
    protected Document document;
    protected PdfWriter writer;
    
    public AbstractReport() 
    {
        this( false );
    }
    
    /**
     * Define orientação do relatório
     * @param rotate False : vertical, True : horizontal
     */
    public AbstractReport( boolean rotate )
    {
        if( rotate )
        {
            document = new Document( PageSize.A4.rotate(), 36f, 36f, 36f, 36f );
        }
        
        else
        {
            document = new Document( PageSize.A4, 36f, 36f, 36f, 36f );
        }
    }
    
    /**
     * Define um titulo para o relatório
     * @param title Titulo do relatório
     * @throws Exception 
     */
    protected void setTitle( String title ) throws Exception
    {
        setTitle( title, null );
    }
    
    /**
     * Define um titulo para o relatório
     * @param title Titulo do relatório
     * @param icon  Caminho relativo
     * @throws Exception 
     */
    protected void setTitle( String title, String icon ) throws Exception
    {
        Paragraph paragraph = new Paragraph();
        paragraph.add( new Chunk( title, fontTitle ) );
        paragraph.setAlignment( Paragraph.ALIGN_CENTER );
        paragraph.setSpacingAfter( 2f );
        
        if( icon != null )
        {
            PdfPCell titleCell = new PdfPCell();
            titleCell.addElement( paragraph );
            titleCell.setPadding( 0 );
            titleCell.setHorizontalAlignment( PdfPCell.ALIGN_RIGHT );
            titleCell.setBorder( PdfPCell.NO_BORDER );

            PdfPCell iconCell = new PdfPCell();
            iconCell.setPadding( 0 );
            iconCell.setHorizontalAlignment( PdfPCell.ALIGN_RIGHT );
            iconCell.setBorder( PdfPCell.NO_BORDER );
            Image img = Image.getInstance( this.getClass().getResource(icon) );
            img.scaleAbsolute( 40, 40 );
            img.setAlignment( Image.ALIGN_RIGHT );
            iconCell.addElement( img );

            PdfPTable titleTable = new PdfPTable( new float[]{ 97f, 3f } );
            titleTable.setSpacingAfter( 2f );
            titleTable.setWidthPercentage( 100 );
            titleTable.addCell( titleCell );
            titleTable.addCell( iconCell );
            
            document.add( titleTable );
        }
        
        else
        {
            document.add( paragraph );
        }
    }
    
    /**
     * Coloca um sub titulo no relatório
     * @param subTitle Sub-Titulo
     * @throws Exception 
     */
    protected void setSubTitle( String subTitle ) throws Exception
    {
        newLine();
        Paragraph paragraph = new Paragraph();
        paragraph.add( new Chunk( subTitle, fontSubTitle ) );
        paragraph.setAlignment( Paragraph.ALIGN_CENTER );
        paragraph.setSpacingAfter( 2f );
        
        document.add( paragraph );
    }
  
    protected void separator() throws Exception
    {
        PdfPTable separator = new PdfPTable( 1 );
        separator.setWidthPercentage( 100 );
        
        PdfPCell cell = new PdfPCell();
        cell.setPadding( 0 );
        cell.setBorder( PdfPCell.BOTTOM );
        cell.setBorderWidth( 2f );
        cell.setBorderColor( color );
        cell.setFixedHeight( 10f );
        
        separator.addCell( cell );
        
        document.add( separator );
    }

    /**
     * Insere nova linha
     * @throws Exception 
     */
    protected void newLine() throws Exception
    {
        document.add( new Phrase( "\n" ) );
    }
    
    /**
     * Insere nova pagina
     */
    protected void newPage()
    {
        document.newPage();
    }
    
    /**
     * Adiciona um HTML no documento
     * @param html String com html
     * @throws Exception 
     */
    protected void addHTML( String html ) throws Exception
    {
        XMLWorkerHelper.parseToElementList( html.replaceAll( "<br>", "<br></br>"), null ).forEach( element -> 
        {
            try
            {
                if( element instanceof Paragraph )
                {
                    Paragraph paragraph = (Paragraph) element;
                    paragraph.setAlignment( Paragraph.ALIGN_CENTER );
                    paragraph.setSpacingAfter( 2f );
                    paragraph.setFont( fontSubTitle );

                    document.add( paragraph );
                }
                
                else if ( element instanceof List )
                {
                    List list = (List) element;

                    document.add( list );
                    
                }
            }
            catch( Exception e )
            {
                System.err.println( e );
            }
        } );
    }

    private void printFooter( PdfWriter writer, String activeUser )
    {
        String user = activeUser;
        String date = df.format( new Date( System.currentTimeMillis() ) );
        
        FooterEvent event = new FooterEvent( user, date );
        
        writer.setPageEvent( event );
    }
    
    public void generatePDF() throws Exception
    {
        new Thread( new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    JFileChooser chooser = new JFileChooser();

                    FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
                    chooser.setFileFilter(filter);
                    
                    chooser.showSaveDialog( null );
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    
                    
                    String nome = chooser.getSelectedFile().getAbsolutePath();
                                        
                    if( nome != null )
                    {
                        if ( !nome.endsWith(".pdf") )
                        {
                              nome += ".pdf"; 
                        }
                        
                        File file = new File( nome );
                        
                        writer = PdfWriter.getInstance( document, new FileOutputStream( file ) );
                        
                        printFooter( writer , Util.getNomeSistema() );

                        document.open();

                        document.addAuthor( "Lucas Tomasi" );
                        document.addCreator( "JavaTur Application" );
                        document.addTitle( "Report JavaTur" );

                        generateDocument( document );

                        document.close();

                        FileUtilities.open( file );
                    }
                }

                catch ( Exception e )
                {
                    System.err.println( e );
                }
            }
        } ).start();
    }

    protected abstract void generateDocument( Document document ) throws Exception;
    
    protected class Table extends PdfPTable
    {
        int aligns[];
        
        public Table( float... widths ) throws Exception
        {
            super( widths );
            setWidthPercentage( 100f );
            aligns = new int[widths.length];
        }
          
        public void setAligns( int... aligns)
        {
            this.aligns = aligns;
        }
        
        public void setHeader( String... header )
        {
            for( String head : header )
            {
                PdfPCell cell = new PdfPCell();
                cell.setBorderColor( AbstractReport.this.color );
                cell.setBorderWidth( 1.5f );
                cell.setBackgroundColor( new BaseColor(	229,229,229) );

                Paragraph paragraph = new Paragraph();
                paragraph.add( new Chunk( head, fontHead ) );
                paragraph.setAlignment( Paragraph.ALIGN_CENTER );
                paragraph.setSpacingAfter( 5f );

                cell.addElement( paragraph );
                
                addCell( cell );
            }
        }
        
        public void addRow( Object... row )
        {   
            int i = 0;
            for( Object r : row )
            {
                PdfPCell cell = new PdfPCell();
                cell.setBorderColor( BaseColor.BLACK );
                cell.setBorderWidth( 1 );
                cell.setPaddingLeft( 3f );
                 
                cell.setBackgroundColor(BaseColor.WHITE);
              
                if ( r instanceof Image )
                {
                    Image img = (Image) r;
                    img.scaleAbsolute( 10, 10 );
                    img.setSpacingBefore( 4f );
                    img.setAlignment( Paragraph.ALIGN_MIDDLE );
                    cell.addElement( img );
                }
                
                else if ( r instanceof PdfPCell )
                {
                    cell = (PdfPCell) r;
                }

                else 
                {
                    Paragraph paragraph = new Paragraph( String.valueOf( r ), fontRow );
                    paragraph.setSpacingAfter( 5f );
                    paragraph.setAlignment(this.aligns[i]);
                    i++;
                    cell.addElement(paragraph);
                }


                addCell( cell );
            }
        }
    }
    
    protected class DetailsTable
        extends 
            PdfPTable
    {
        private BaseColor background = new BaseColor( 179, 179, 179 );
        private boolean formatCelll = true;
        
        public DetailsTable( float... widths ) throws Exception
        {
            super( ( widths.length * 2 ) -1 );
            
            float heads [] = new float[ ( widths.length * 2 ) -1 ];
            
            int j = 0;
            
            for ( int i = 0; i < heads.length; i++ )
            {
                if( i % 2 == 0 )
                {
                    heads[i] = widths[j];
                    j++;
                }
                
                else
                {
                    heads[i] = 1f;
                }
            }
            
            setWidths( heads );
            
            setWidthPercentage( 100f );
            
            addSeparatorRow();
        }
        
        public void setHeader( String... header )
        {
            for( int i = 0; i < header.length; i++ )
            {
                String head = header[i];
                
                PdfPCell cell = new PdfPCell();
                cell.setBorderColor( color );
                cell.setBorderWidth( 1.5f );
                cell.setBackgroundColor( new BaseColor( 160, 166, 174 ) );

                Paragraph paragraph = new Paragraph();
                paragraph.add( new Chunk( head, new Font( Font.FontFamily.HELVETICA  , 12, Font.BOLD, BaseColor.WHITE ) ) );
                paragraph.setAlignment( Paragraph.ALIGN_CENTER );
                paragraph.setSpacingAfter( 5f );

                cell.addElement( paragraph );
                
                addCell( cell );
            
                if( i != header.length -1 )
                {
                    addSeparatorColumn();
                }
            }
            
            addSeparatorRow();
        }
        
        public void addRow( Object... row )
        {
            for ( int i = 0; i < row.length; i++ )
            {
                Object column = row[i];
                
                PdfPCell cell = new PdfPCell();
                cell.setBackgroundColor( BaseColor.WHITE );            
                cell.setBorderWidth( 1.5f );
                cell.setBorderColor( color );

                if( i == 0 && formatCelll )
                {
                    cell.setBackgroundColor( background );
                    
                    if( column instanceof String )
                    {
                        Paragraph paragraph = new Paragraph();
                        paragraph.setAlignment( Paragraph.ALIGN_MIDDLE );
                        paragraph.setIndentationLeft( 5f );
                        paragraph.setSpacingAfter( 5f );
                        paragraph.add( new Chunk( column + ":", new Font( Font.FontFamily.HELVETICA  , 12, Font.BOLD, color ) ) );
                        cell.addElement( paragraph );
                    }

                    else if( column instanceof Image )
                    {
                        Image img = (Image) column;
                        img.scaleAbsolute( 10, 10 );
                        img.setSpacingBefore( 4f );
                        img.setAlignment( Paragraph.ALIGN_MIDDLE );
                        cell.addElement( img );
                    }
                }

                else
                {
                    if( column instanceof String )
                    {
                        Font font = new Font( Font.FontFamily.HELVETICA  , 10, Font.BOLD, cell.getBackgroundColor() == BaseColor.WHITE ? color : BaseColor.WHITE );
                        Paragraph paragraph = new Paragraph();
                        paragraph.setAlignment( Paragraph.ALIGN_MIDDLE );
                        paragraph.setSpacingAfter( 5f );
                        paragraph.setIndentationLeft( 5f );
                        paragraph.add( new Chunk( (String)column, font ) );
                        cell.addElement( paragraph );
                    }

                    else if( column instanceof Image )
                    {
                        Image img = (Image) column;
                        img.scaleAbsolute( 10, 10 );
                        img.setSpacingBefore( 4f );
                        img.setAlignment( Paragraph.ALIGN_MIDDLE );
                        cell.addElement( img );
                    }
                }

                addCell( cell );
                
                if( i != row.length -1 )
                {
                    addSeparatorColumn();
                }
            }
            
            addSeparatorRow();
        }


        private void addSeparatorColumn()
        {
            PdfPCell cell = new PdfPCell();
            cell.setBorder( PdfPCell.NO_BORDER );

            addCell( cell ); 
        }

        private void addSeparatorRow()
        {
            for( int i =0; i < getAbsoluteWidths().length; i++ )
            {
                PdfPCell cell = new PdfPCell();
                cell.setBorder( PdfPCell.NO_BORDER );
                cell.setFixedHeight( 5f );
                addCell( cell );
            }
        }

        public BaseColor getBackground() 
        {
            return background;
        }

        public void setBackground( BaseColor background )
        {
            this.background = background;
        }

        public boolean isFormatCelll() 
        {
            return formatCelll;
        }

        public void setFormatCelll( boolean formatCelll )
        {
            this.formatCelll = formatCelll;
        }
    }
}

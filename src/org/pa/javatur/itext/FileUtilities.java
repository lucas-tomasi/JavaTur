package org.pa.javatur.itext;

import java.awt.Desktop;
import java.io.File;

/**
 * @author artur
 */
public class FileUtilities 
{
    public static void open( final File file ) throws Exception
    {
        validadeFile( file );

        new Thread( new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    if( Desktop.isDesktopSupported() )
                        Desktop.getDesktop().open( file );
                } 
                catch ( Exception e )
                {
                    System.err.print( e );
                }
            }
        } ).start();
    }
    
    private static void validadeFile( File file ) throws Exception
    {
        if( ! file.exists() )
            throw new Exception( "File not found: " + file.getAbsolutePath() );
        
        if( ! file.canRead() )
            throw new Exception( "File can not read: " + file.getAbsolutePath() );
        
        if( ! file.canWrite() )
            throw new Exception( "File can not writer: " + file.getAbsolutePath() );
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pa.javatur.javatur;

import java.awt.Color;
import java.awt.Component;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author lucas
 */
public class Util {
    
    public static HashMap getDadosConexao()
    {
        try
        {
            HashMap configs = new HashMap();

            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));

            configs.put( "name" , prop.getProperty("db.name") );
            configs.put( "user"  , prop.getProperty("db.user") );
            configs.put( "senha" , prop.getProperty("db.senha") );
            configs.put( "host" , prop.getProperty("db.host") );
            
            return configs;
        }
        catch( Exception e )
        {
            System.err.println(e);
            return null;
        }
    }
            

    public static String getDataHoje()
    {
        DateFormat dateFormat     = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date abertura   = new java.util.Date( System.currentTimeMillis() );
        
        return  dateFormat.format(abertura);
    }
    
    public static String getDataProximoMes()
    {
        DateFormat dateFormat     = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date abertura   = new java.util.Date( System.currentTimeMillis() );
        
        
        Calendar c = Calendar.getInstance();
        c.setTime(abertura);

        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
        java.util.Date nextMonth = c.getTime();
        return  dateFormat.format(nextMonth);
    }
    
    public static String getNomeSistema()
    {
        return "JavaTur";
    }
    
    public static String getLogo()
    {
        return "/org/pa/javatur/images/logo.png";
    }
    
    public static Date somarMesData(Date data) 
    {
        Date d = data;

        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.set(Calendar.DAY_OF_MONTH, 10);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);

        Date dataNova = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()).toString());
        return dataNova;
    }
    
    public static Date subtrairMesData(Date data) 
    {
        Date d = data;

        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);

        Date dataNova = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()).toString());
        return dataNova;
    }

    public static String gerarHash(String frase, String algoritmo) 
    {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return stringHexa(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String stringHexa(byte[] bytes) 
    {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    public static String formatarValor( double numero)
    {
        String valor = String.format("%.2f", numero);
        return valor.replaceAll(",", ".");
    }
    
    public static String converterData(String data)
    {
        String novaData = ""; 
        if( !data.equals("null") && data != null && !data.equalsIgnoreCase("  /  /   ") && !data.equalsIgnoreCase(""))
        {
            novaData += data.substring(6) + "-";
            novaData += data.substring(3,5) + "-";
            novaData += data.substring(0,2);
        }
        return novaData;
    }
    
    public static String formatarData(String data)
    {//0123/56/89
        String novaData ="";
        if( !data.equals("null") && data != null && !data.equalsIgnoreCase("  /  /   ") && !data.equalsIgnoreCase(""))
        {
            novaData = data.substring(8, 10) + "/" + data.substring(5, 7) +"/"+data.substring(0, 4);
        }
        return novaData;
    }
    
    public static String formatarCPF(String cpf)
    {
        String novoCPF = cpf.substring(0, 3) + "." + cpf.substring(3, 6)+ "." +cpf.substring(6, 9)+"-"+cpf.substring(9, 11);
        return novoCPF;
    }   
    
    public static String converterCPF(String cpf)
    { 
        cpf = cpf.trim().replace(" ", "");
        cpf = cpf.replaceAll("[.-]","");
        if(cpf.length() == 0)
        {
            return "";
        }
        return cpf;
    }
    
    public static boolean validarData( String data )
    { 
        if( data.equals("/  /") )
        {
            return false;
        }
        else
        {
            try
            {
                String dataFormatada = converterData(data);
                Date dataValida = Date.valueOf(dataFormatada);
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
    }
    
    public static boolean validarTelefone( String telefone )
    { 
        telefone = telefone.replaceAll( "[()-]" , "" );
        telefone = telefone.replaceAll(" ", "");
        if(telefone.length() < 8)
        {
            return false;
        }
        return true;
    }
    
    public static boolean validarCPF( String cadastro)
    {
        cadastro = cadastro.replaceAll(" ", "");
        if(cadastro.length() < 14)
        {
            return false;
        }
        cadastro = String.valueOf(converterCPF(cadastro));
        int cpf [] = new int [11];
        if (cadastro.length()!=11 )
        {
           return false;
        }
        else
        {
            for (int i = 0; i < 10; i++) 
            {              
                cpf[i] = Integer.parseInt(""+cadastro.charAt(i));
            }       
            
            int ver1 = ((cpf[0]*10)+(cpf[1]*9)+(cpf[2]*8)+(cpf[3]*7)+(cpf[4]*6)+(cpf[5]*5)+(cpf[6]*4)+(cpf[7]*3)+(cpf[8]*2));
        
            ver1 = (ver1%11);
       
            if(ver1<2)
            {           
                ver1=0;
            }
            else
            {
                ver1 =11-ver1;
            }
       
            int ver2 = ((cpf[0]*11)+(cpf[1]*10)+(cpf[2]*9)+(cpf[3]*8)+(cpf[4]*7)+(cpf[5]*6)+(cpf[6]*5)+(cpf[7]*4)+(cpf[8]*3)+(cpf[9]*2));
        
            ver2 = (ver2%11);
        
            if (ver2<2)
            {            
                ver2 =0;
            }
            else
            {
                ver2 = 11-ver2;    
            }
        
            if (ver1 == cpf[9]&& ver2== cpf[10])
            {            
                return true;            
            }
            else
            {
                return false;
            }
        
        }
    }
    
    public static boolean isNumero( char key )
    {
        if( key == '0' || key == '1' || key == '2' || key == '3' || key == '4' ||
            key == '5' || key == '6' || key == '7' || key == '8' || key == '.' || key == '9' )
        {
            return true;
        }
        return false;
    }
    
    public static TableCellRenderer pintar( Color foreground, Color background )
    {
        TableCellRenderer tcr = new Colorir( foreground, background);
        return tcr;
    }
}

class Colorir extends JLabel implements TableCellRenderer
{
    Color background;
    Color foreground;
    public Colorir( Color foreground, Color background )
    {
        this.background = background;
        this.foreground = foreground;
    }
    public  Component   getTableCellRendererComponent ( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column )
    {
        table.setForeground(foreground);	

        table.setBackground(background);		

        setText(value.toString());
        return this;   	
    }
}
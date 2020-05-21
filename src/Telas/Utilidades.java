//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Telas;

import Controle.MyException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Utilidades
{   
    public static void formatarCampo(String padrao, JFormattedTextField campo) throws MyException
    {
        MaskFormatter formato = new MaskFormatter(); 
        
        try {
            formato.setMask(padrao); 
            formato.setPlaceholderCharacter('_');
            formato.install(campo); 
        } catch (Exception e){
            throw new MyException(e);
        }
    }
    
    public static Boolean obterRadioButtonSelecionado(ButtonGroup radios)
    {
        for (Enumeration<AbstractButton> botoes = radios.getElements(); botoes.hasMoreElements();)
        {
            AbstractButton botao = botoes.nextElement();

            if (botao.isSelected())
            {
                if(botao.getText().equals( "Sim" ))
                    return true;
                else if (botao.getText().equals( "Não" ))
                    return false;
            }
        }

        return null;
    }
    
    public static Boolean selecionarRadioButton(ButtonGroup radios, Boolean opcao)
    {
        for (Enumeration<AbstractButton> botoes = radios.getElements(); botoes.hasMoreElements();)
        {
            AbstractButton botao = botoes.nextElement();
            
            if( ( botao.getText().equals( "Sim" ) && opcao == true ) || ( botao.getText().equals( "Não" ) && opcao == false) ) 
                botao.setSelected(true);
            else
                botao.setSelected(false);
        }

        return null;
    }
    
    public static void habilitarRadioButton(ButtonGroup radios)
    {
        Enumeration botoes = radios.getElements();
        if(botoes != null)
        {
            while(botoes.hasMoreElements())
            {
                JRadioButton botao = (JRadioButton) botoes.nextElement();
                botao.setEnabled(true);
            }
        }
    }
    
    public static void desabilitarRadioButton(ButtonGroup radios)
    {
        Enumeration botoes = radios.getElements();
        if(botoes != null)
        {
            while(botoes.hasMoreElements())
            {
                JRadioButton botao = (JRadioButton) botoes.nextElement();
                botao.setEnabled(false);
            }
        }
    }
    
    public static Timestamp converterStringData(String dataString) throws MyException
    {
        try{
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dataString);
            long time = data.getTime();
            
            return new Timestamp(time);
        } catch(Exception e) {
            throw new MyException(e);
        }
    }
    
    public static String limparPrepararTexto(JTextField campo)
    {
        return campo.getText().trim().toUpperCase();
    }
    
    public static Integer limparPrepararNumero(JTextField campo)
    {
        if(campo.getText().trim().length() > 0)
        {
            return Integer.parseInt(campo.getText().trim());
        }
        else
        {
            return -1; // Indicativo de campo vazio 
        }
        
    }
    
    public static Double limparPrepararDecimal(JTextField campo)
    {
        if(campo.getText().trim().length() > 0)
        {
            return Double.parseDouble(campo.getText().trim());
        }
        else
        {
            return -1.0; // Indicativo de campo vazio
        }
    }
    
    public static Timestamp limparPrepararData(JTextField campo) throws MyException
    {
        return converterStringData(campo.getText());
    }
    
    public static void exibirInteiro(JTextField campo, Integer numero)
    {
        if(numero >= 0)
            campo.setText(numero.toString());
        else
            campo.setText("");
    }
    
    public static void exibirDecimal(JTextField campo, Double numero)
    {
        if(numero >= 0)
            campo.setText(numero.toString());
        else
            campo.setText("");
    }
    
    public static void exibirData(JTextField campo, Timestamp dataAntiga) throws MyException
    {
        try
        {
            SimpleDateFormat formatoAntigo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            Date dataNova = formatoAntigo.parse( dataAntiga.toString() );
            SimpleDateFormat formatoNovo = new SimpleDateFormat("dd/MM/YYYY");  
            campo.setText(formatoNovo.format(dataNova));
        } catch (Exception e) {
            throw new MyException(e);
        }

    }
    
    public static boolean testaStringNumerica(String string)
    {  
        return string.matches("[0-9]*");  
    }
    
}

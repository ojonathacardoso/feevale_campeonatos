//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Telas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacao
{   
    public static Boolean validarCampoTexto(JTextField campo, Boolean obrigatorio, int minimo, int maximo, String descricaoCampo)
    {
        if(obrigatorio || (! obrigatorio && campo.getText().trim().length() > 0) )
        {
            {
                if(campo.getText().trim().length() < minimo)
                {
                    String mensagem = "Problema no campo " + descricaoCampo + " \nTamanho mínimo: " + minimo;
                    JOptionPane.showMessageDialog(null, mensagem);
                    return false;
                }
                else if(campo.getText().trim().length() > maximo)
                {
                    String mensagem = "Problema no campo " + descricaoCampo + " \nTamanho máximo: " + maximo;
                    JOptionPane.showMessageDialog(null, mensagem);
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
        else
        {
            return true;
        }
    }
    
    public static Boolean validarCampoNumerico(JTextField campo, Boolean obrigatorio, int minimo, int maximo, String descricaoCampo)
    {
        
        if(obrigatorio || (! obrigatorio && campo.getText().trim().length() > 0) )
        {
            if(campo.getText().trim().length() <= 0)
            {
                String mensagem = "Problema no campo " + descricaoCampo + " \nValor não informado!";
                JOptionPane.showMessageDialog(null, mensagem);
                return false;
            }
            else if(Integer.parseInt(campo.getText().trim()) < minimo)
            {
                String mensagem = "Problema no campo " + descricaoCampo + " \nValor mínimo: " + minimo;
                JOptionPane.showMessageDialog(null, mensagem);
                return false;
            }
            else if(Integer.parseInt(campo.getText().trim()) > maximo)
            {
                String mensagem = "Problema no campo " + descricaoCampo + " \nValor máximo: " + maximo;
                JOptionPane.showMessageDialog(null, mensagem);
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }
    
    public static Boolean validarCampoRadio(ButtonGroup campo, String descricaoCampo)
    {
        if(Utilidades.obterRadioButtonSelecionado(campo) == null)
        {
            String mensagem = "Problema no campo " + descricaoCampo + " \nNenhuma opção selecionada!";
            JOptionPane.showMessageDialog(null, mensagem);
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static Boolean validarCampoDecimal(JTextField campo, Boolean obrigatorio, int minimo, int maximo, String descricaoCampo)
    {
        if(obrigatorio || (! obrigatorio && campo.getText().trim().length() > 0) )
        {
            if(campo.getText().trim().length() <= 0)
            {
                String mensagem = "Problema no campo " + descricaoCampo + " \nValor não informado!";
                JOptionPane.showMessageDialog(null, mensagem);
                return false;
            }
            else if(Double.parseDouble(campo.getText().trim()) < minimo)
            {
                String mensagem = "Problema no campo " + descricaoCampo + " \nValor mínimo: " + minimo;
                JOptionPane.showMessageDialog(null, mensagem);
                return false;
            }
            else if(Double.parseDouble(campo.getText().trim()) > maximo)
            {
                String mensagem = "Problema no campo " + descricaoCampo + " \nValor máximo: " + maximo;
                JOptionPane.showMessageDialog(null, mensagem);
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }  
    
    public static Boolean validarCampoData(JTextField campo, String descricaoCampo)
    {
        DateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");  
        formato.setLenient(false); // Não perdoa datas como 30/02 ou 32/07. A data tem que existir
        try {  
            formato.parse (campo.getText());
            return true;
        } catch (Exception e) {  
            String mensagem = "Problema no campo " + descricaoCampo + " \nInforme uma data válida, no formato DD/MM/AAAA";
            JOptionPane.showMessageDialog(null, mensagem);
            return false; 
        } 
    }
}

//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Controle;

import javax.swing.JOptionPane;

public class MyException extends Exception
{	
    /** Versão do utilizada pelo serializador da classe */
    private static final long serialVersionUID = -6003018715297216583L;

    public MyException( String mensagem )
    {
        super( mensagem );
        JOptionPane.showMessageDialog(null, "O seguinte erro foi encontrado: \n " + mensagem);
    }

    public MyException( Exception e )
    {
        super( e );
        JOptionPane.showMessageDialog(null, "O seguinte erro foi encontrado: \n " + e.getMessage());
    }
}
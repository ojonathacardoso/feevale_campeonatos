
package Telas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListener
{
    
}

class ListenerInteiro implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e)
    {
        if( e.getKeyChar() < '0' || e.getKeyChar() > '9' )
        {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }
    
}

class ListenerDecimal implements KeyListener{

    Boolean pontoHabilitado = true;
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        if( (e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != '.')
        {
            e.consume();
        }
        else
        {
            if( e.getKeyChar() == '.' )
            {
                if(pontoHabilitado)
                {
                    pontoHabilitado = false;
                }
                else
                {
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }
    
}
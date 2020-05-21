//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Parametros
{
    private static Parametros myself;
    private Properties parametros;
	
    private Parametros() throws IOException
    {
        parametros = new Properties();
        carregaParametros();
    }
	
    public static Parametros getInstance() throws IOException
    {
        if( myself == null )
        {
            myself = new Parametros();
        }
        
        return myself;
    }

    public String getParametro( String chave )
    {
        return parametros.getProperty( chave );
    }

    private void carregaParametros() throws IOException
    {
        File arquivo = new File("src/Controle/Parametros.xml");

        if( arquivo.exists() )
        {
            FileInputStream fis = new FileInputStream( arquivo );

            try {
                parametros.loadFromXML( fis );
            } finally {
                fis.close();
            }
        }
    }
	
}
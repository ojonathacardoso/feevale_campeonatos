//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao
{
    private static Conexao myself;
    
    private Connection conexao;
    Parametros parametros;
    
    private Conexao() throws MyException 
    {
        try {
            parametros = Parametros.getInstance();

            Class.forName( parametros.getParametro( "driver" ) );

            String url = parametros.getParametro( "url" );
            String usuario = parametros.getParametro( "usuario" );
            String senha = parametros.getParametro( "senha" );

            conexao = DriverManager.getConnection( url, usuario, senha );
            
        } catch (Exception e) {
            throw new MyException(e);
        }
    }

    public static Conexao getInstance() throws MyException
    {
        if( myself == null )
        {
            myself = new Conexao();
        }

        return myself;
    }
    
    public Statement createStatement() throws MyException
    {
        try {
            return conexao.createStatement();
        } catch (SQLException e) {
            throw new MyException( e );
        }
    }

    public PreparedStatement prepareStatement(String sql) throws MyException
    {
        try {
            PreparedStatement pst = conexao.prepareStatement( sql );
            return pst;
        } catch (Exception e) {
            throw new MyException(e);
        }
    }

    public void desconecta() throws MyException
    {
        try {
            conexao.close();
            myself = null;
        } catch (Exception e){
            throw new MyException(e);
        }
    }

    public Connection getConnection()
    {
        return conexao;
    }
}
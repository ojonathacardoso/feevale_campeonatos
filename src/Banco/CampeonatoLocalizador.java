//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Banco;

import Controle.Conexao;
import Controle.MyException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class CampeonatoLocalizador 
{
    public static Campeonato buscaCampeonatoId( Integer id ) throws MyException
    {
        String sql = " SELECT * FROM campeonatos WHERE id = ? ";
        Conexao conexao = Conexao.getInstance();
        
        try {
            
            PreparedStatement statement = conexao.prepareStatement( sql.toString() );
            statement.setInt( 1, id );
            ResultSet resultado = statement.executeQuery();
            
            if( resultado.next() )
            {
                Campeonato campeonato = new Campeonato();
                
                campeonato.setId( resultado.getInt( "id" ) ); 
                
                campeonato.setNome( resultado.getString("nome" ) ); 
                campeonato.setEdicao( resultado.getString( "edicao" ) ); 
                campeonato.setPatrocinador( resultado.getString( "patrocinador" ) ); 
                campeonato.setCampeao( resultado.getString( "campeao" ) ); 
                campeonato.setViceCampeao( resultado.getString( "viceCampeao" ) ); 
                
                campeonato.setQtdeParticipantes( resultado.getInt("qtdeParticipantes" ) ); 
                campeonato.setQtdeFases( resultado.getInt( "qtdeFases" ) ); 
                campeonato.setQtdePartidas( resultado.getInt( "qtdePartidas" ) ); 
                campeonato.setQtdeGols( resultado.getInt( "qtdeGols" ) ); 
                campeonato.setMediaPublico( resultado.getInt( "mediaPublico" ) ); 
                
                campeonato.setPontosCorridos( resultado.getBoolean("pontosCorridos" ) ); 
                campeonato.setTurnoReturno( resultado.getBoolean( "turnoReturno" ) ); 
                campeonato.setFormulaFraga( resultado.getBoolean( "formulaFraga" ) ); 
                campeonato.setFaseGrupos( resultado.getBoolean( "faseGrupos" ) ); 
                campeonato.setEliminatorias( resultado.getBoolean( "eliminatorias" ) ); 
                
                campeonato.setMediaGols( resultado.getDouble("mediaGols" ) ); 
                campeonato.setMediaRenda( resultado.getDouble( "mediaRenda" ) );
                
                campeonato.setDataInicio( resultado.getTimestamp("dataInicio" ) ); 
                campeonato.setDataFinal( resultado.getTimestamp( "dataFinal" ) );

                return campeonato;
            }
            else
            {
                return null;
            }
        } catch ( Exception e ) {
            throw new MyException(e);
        }
        
    }
    
    public static Campeonato buscaCampeonatos( List<String> condicoes ) throws MyException
    {
        StringBuilder sql = new StringBuilder(" SELECT * FROM campeonatos ");
        
        for(int x = 0; x < condicoes.size(); x++)
        {
            if (x == 0)
                sql.append(" WHERE ");
            else
                sql.append(" AND ");
            
            sql.append(condicoes.get(x));
        }
        
        sql.append(" LIMIT 1 ");

        Conexao conexao = Conexao.getInstance();

        try {
            
            PreparedStatement statement = conexao.prepareStatement( sql.toString() );
            ResultSet resultado = statement.executeQuery();
            
            if( resultado.next() )
            {
                Campeonato campeonato = new Campeonato();

                campeonato.setId( resultado.getInt( "id" ) ); 

                campeonato.setNome( resultado.getString("nome" ) ); 
                campeonato.setEdicao( resultado.getString( "edicao" ) ); 
                campeonato.setPatrocinador( resultado.getString( "patrocinador" ) ); 
                campeonato.setCampeao( resultado.getString( "campeao" ) ); 
                campeonato.setViceCampeao( resultado.getString( "viceCampeao" ) ); 

                campeonato.setQtdeParticipantes( resultado.getInt("qtdeParticipantes" ) ); 
                campeonato.setQtdeFases( resultado.getInt( "qtdeFases" ) ); 
                campeonato.setQtdePartidas( resultado.getInt( "qtdePartidas" ) ); 
                campeonato.setQtdeGols( resultado.getInt( "qtdeGols" ) ); 
                campeonato.setMediaPublico( resultado.getInt( "mediaPublico" ) ); 

                campeonato.setPontosCorridos( resultado.getBoolean("pontosCorridos" ) ); 
                campeonato.setTurnoReturno( resultado.getBoolean( "turnoReturno" ) ); 
                campeonato.setFormulaFraga( resultado.getBoolean( "formulaFraga" ) ); 
                campeonato.setFaseGrupos( resultado.getBoolean( "faseGrupos" ) ); 
                campeonato.setEliminatorias( resultado.getBoolean( "eliminatorias" ) ); 

                campeonato.setMediaGols( resultado.getDouble("mediaGols" ) ); 
                campeonato.setMediaRenda( resultado.getDouble( "mediaRenda" ) );

                campeonato.setDataInicio( resultado.getTimestamp("dataInicio" ) ); 
                campeonato.setDataFinal( resultado.getTimestamp( "dataFinal" ) );

                return campeonato;
            }
            else
            {
                return null;
            }
        } catch ( Exception e ) {
            throw new MyException(e);
        }
    }
    
    public static Campeonato buscaCampeonatoPrimeiro() throws MyException
    {
        Campeonato campeonato = null;
        
        try {
            Conexao conexao = Conexao.getInstance();
            
            Statement statement = conexao.createStatement();            
            ResultSet resultado = statement.executeQuery( "SELECT MIN(id) FROM campeonatos;" );            
            resultado.next();
            
            if(resultado.getInt(1) != 0)
            {
                Integer idPrimeiro = resultado.getInt( 1 );
                campeonato = CampeonatoLocalizador.buscaCampeonatoId(idPrimeiro);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
            }
        } catch (Exception e) {
            throw new MyException(e);
        }
        
        return campeonato;
    }
    
    public static Campeonato buscaCampeonatoAnterior(Integer idAtual) throws MyException
    {
        Campeonato campeonato = null;
        
        try {
            Conexao conexao = Conexao.getInstance();
            
            PreparedStatement statement = conexao.prepareStatement("SELECT MAX(id) FROM campeonatos WHERE id < ? ;");
            statement.setInt( 1, idAtual );            
            ResultSet resultado = statement.executeQuery();            
            resultado.next();            
            
            if(resultado.getInt(1) != 0)
            {
                Integer idAnterior = resultado.getInt( 1 );
                campeonato = CampeonatoLocalizador.buscaCampeonatoId(idAnterior);
            }
        } catch (Exception e) {
            throw new MyException(e);
        }
        
        return campeonato;
    }
    
    public static Campeonato buscaCampeonatoProximo(Integer idAtual) throws MyException
    {
        Campeonato campeonato = null;
        
        try {
            Conexao conexao = Conexao.getInstance();
            
            PreparedStatement statement = conexao.prepareStatement("SELECT MIN(id) FROM campeonatos WHERE id > ? ;");
            statement.setInt( 1, idAtual );
            ResultSet resultado = statement.executeQuery(  );
            resultado.next();
            
            if(resultado.getInt(1) != 0)
            {
                Integer idProximo = resultado.getInt( 1 );
                campeonato = CampeonatoLocalizador.buscaCampeonatoId(idProximo);
            }
        } catch (Exception e) {
            throw new MyException(e);
        }
        
        return campeonato;
    }
    
    public static Campeonato buscaCampeonatoUltimo() throws MyException
    {
        Campeonato campeonato = null;
        
        try {
            Conexao conexao = Conexao.getInstance();
            
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery( "SELECT MAX(id) FROM campeonatos;" );
            resultado.next();
            
            if(resultado.getInt(1) != 0)
            {
                Integer idUltimo = resultado.getInt( 1 );
                campeonato = CampeonatoLocalizador.buscaCampeonatoId(idUltimo);
            }
        } catch (Exception e) {
            throw new MyException(e);
        }
        
        return campeonato;
    }
    
    public static Integer buscaIdAtual() throws MyException
    {
        try {
            Conexao conexao = Conexao.getInstance();
            
            Statement statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery( "SELECT MAX(id) FROM campeonatos;" );
            resultado.next();
            
            return ( resultado.getInt(1) );
        } catch (Exception e) {
            throw new MyException(e);
        }
    }
    
}

//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Banco;

import Controle.Conexao;
import Controle.MyException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CampeonatoPersistor
{    
    public static Boolean insereCampeonato(Campeonato campeonato) throws MyException
    {
        StringBuilder sql = new StringBuilder( 500 );
        sql.append( " INSERT INTO campeonatos ( " );
        sql.append( " nome, edicao, patrocinador, campeao, viceCampeao, " ); 
        sql.append( " qtdeParticipantes, qtdeFases, qtdePartidas, qtdeGols, mediaPublico, " ); 
        sql.append( " pontosCorridos, turnoReturno, formulaFraga, faseGrupos, eliminatorias, " ); 
        sql.append( " mediaGols, mediaRenda, " ); 
        sql.append( " dataInicio, dataFinal " ); 
        sql.append( " ) VALUES " );
        sql.append( " ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ) " );

        Conexao conexao = Conexao.getInstance();
        PreparedStatement statement = conexao.prepareStatement( sql.toString() );

        try {
            statement.setString( 1, campeonato.getNome() );
            statement.setString( 2, campeonato.getEdicao() );
            statement.setString( 3, campeonato.getPatrocinador());
            statement.setString( 4, campeonato.getCampeao());
            statement.setString( 5, campeonato.getViceCampeao());
            
            statement.setInt(  6, campeonato.getQtdeParticipantes());
            statement.setInt(  7, campeonato.getQtdeFases());
            statement.setInt(  8, campeonato.getQtdePartidas());
            statement.setInt(  9, campeonato.getQtdeGols());            
            statement.setInt( 10, campeonato.getMediaPublico());
            
            statement.setBoolean( 11, campeonato.isPontosCorridos());
            statement.setBoolean( 12, campeonato.isTurnoReturno());
            statement.setBoolean( 13, campeonato.isFormulaFraga());
            statement.setBoolean( 14, campeonato.isFaseGrupos());
            statement.setBoolean( 15, campeonato.isEliminatorias());
            
            statement.setDouble( 16, campeonato.getMediaGols());
            statement.setDouble( 17, campeonato.getMediaRenda());
            
            statement.setTimestamp( 18, campeonato.getDataInicio());
            statement.setTimestamp( 19, campeonato.getDataFinal());

            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
            
            return true;
        } catch (SQLException e){
            throw new MyException( e );
        }
        
    }
    
    public static Boolean alteraCampeonato(Campeonato campeonato) throws MyException
    {
        StringBuilder sql = new StringBuilder( 500 );
        
        sql.append( " UPDATE campeonatos SET " );
        sql.append( " nome = ?, " ); 
        sql.append( " edicao = ?, " ); 
        sql.append( " patrocinador = ?, " ); 
        sql.append( " campeao = ?, " ); 
        sql.append( " viceCampeao = ?, " ); 
        sql.append( " qtdeParticipantes = ?, " ); 
        sql.append( " qtdeFases = ?, " ); 
        sql.append( " qtdePartidas = ?, " ); 
        sql.append( " qtdeGols = ?, " ); 
        sql.append( " mediaPublico = ?, " ); 
        sql.append( " pontosCorridos = ?, " ); 
        sql.append( " turnoReturno = ?, " ); 
        sql.append( " formulaFraga = ?, " ); 
        sql.append( " faseGrupos = ?, " ); 
        sql.append( " eliminatorias = ?, " ); 
        sql.append( " mediaGols = ?, " ); 
        sql.append( " mediaRenda = ?, " );
        sql.append( " dataInicio = ?, " ); 
        sql.append( " dataFinal = ? " );
        sql.append( " WHERE id = ? " );

        Conexao conexao = Conexao.getInstance();
        PreparedStatement statement = conexao.prepareStatement( sql.toString() );
        
        try {
            statement.setString( 1, campeonato.getNome() );
            statement.setString( 2, campeonato.getEdicao() );
            statement.setString( 3, campeonato.getPatrocinador() );
            statement.setString( 4, campeonato.getCampeao() );
            statement.setString( 5, campeonato.getViceCampeao() );
            
            statement.setInt(  6, campeonato.getQtdeParticipantes() );
            statement.setInt(  7, campeonato.getQtdeFases() );
            statement.setInt(  8, campeonato.getQtdePartidas() );
            statement.setInt(  9, campeonato.getQtdeGols() );            
            statement.setInt( 10, campeonato.getMediaPublico() );
            
            statement.setBoolean( 11, campeonato.isPontosCorridos() );
            statement.setBoolean( 12, campeonato.isTurnoReturno() );
            statement.setBoolean( 13, campeonato.isFormulaFraga() );
            statement.setBoolean( 14, campeonato.isFaseGrupos() );
            statement.setBoolean( 15, campeonato.isEliminatorias() );
            
            statement.setDouble( 16, campeonato.getMediaGols() );
            statement.setDouble( 17, campeonato.getMediaRenda() );
            
            statement.setTimestamp( 18, campeonato.getDataInicio() );
            statement.setTimestamp( 19, campeonato.getDataFinal() );
            
            statement.setInt(20, campeonato.getId() );

            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");
            
            return true;
        } catch (SQLException e){
            throw new MyException( e );
        }
    }
    
    public static Boolean excluiCampeonato(Campeonato campeonato) throws MyException
    {
        StringBuilder sql = new StringBuilder( 50 );
        sql.append( "DELETE FROM campeonatos WHERE id = ?" ); 

        Conexao conexao = Conexao.getInstance();
        PreparedStatement statement = conexao.prepareStatement( sql.toString() );

        try {
            statement.setInt( 1, campeonato.getId() );

            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
            
            return true;
        } catch (SQLException e){
            throw new MyException( e );
        }
    }
    
}

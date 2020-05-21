//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Telas;

import Banco.Campeonato;
import Banco.CampeonatoLocalizador;
import Banco.CampeonatoPersistor;
import Controle.MyException;
import static Telas.Utilidades.formatarCampo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CampeonatoTela extends JFrame implements ActionListener
{ 
    private int linha = 100;
    private int coluna = 40;
    
    private Campeonato campeonatoEmExibicao = new Campeonato();
    private Campeonato campeonatoEmEdicao = new Campeonato();
    
    private JTextField campoId = new JTextField();
    private JTextField campoNome = new JTextField();
    private JTextField campoEdicao = new JTextField();
    private JTextField campoPatrocinador = new JTextField();
    private JTextField campoCampeao = new JTextField();
    private JTextField campoViceCampeao = new JTextField();
    private JTextField campoQtdeParticipantes = new JTextField();
    private JTextField campoQtdeFases = new JTextField();
    private JTextField campoQtdePartidas = new JTextField();
    private JTextField campoQtdeGols = new JTextField();
    private JTextField campoMediaPublico = new JTextField();
    
    private ButtonGroup radioPontosCorridos = new ButtonGroup();
    private ButtonGroup radioTurnoReturno = new ButtonGroup();
    private ButtonGroup radioFormulaFraga = new ButtonGroup();
    private ButtonGroup radioFaseGrupos = new ButtonGroup();
    private ButtonGroup radioEliminatorias = new ButtonGroup();
    
    private JTextField campoMediaGols = new JTextField();
    private JTextField campoMediaRenda = new JTextField();
    
    private JFormattedTextField campoDataInicio = new JFormattedTextField();
    private JFormattedTextField campoDataFinal = new JFormattedTextField();    
    
    private JButton botaoPrimeiro = new JButton();
    private JButton botaoAnterior = new JButton();
    private JButton botaoProximo = new JButton();
    private JButton botaoUltimo = new JButton();
    
    private JButton botaoListar = new JButton();
    private JButton botaoPesquisar = new JButton();
    private JButton botaoIncluir = new JButton();
    private JButton botaoEditar = new JButton();
    private JButton botaoExcluir = new JButton();
    
    public CampeonatoTela() throws MyException
    {
        setTitle( "Sistema de Gerenciamento de Campeonatos" );
        setLayout( null );
        setBounds( 100, 100, 900, 600 );
        
        getContentPane().setBackground( Color.WHITE );
        
        adicionarBotaoAcao("Listar", botaoListar);
        adicionarBotaoAcao("Pesquisar", botaoPesquisar);
        adicionarBotaoAcao("Incluir", botaoIncluir);
        adicionarBotaoAcao("Editar", botaoEditar);
        adicionarBotaoAcao("Excluir", botaoExcluir);
        
        campoId.setEnabled(false);
        
        adicionarCampoEsquerda("Código", campoId, 50);
        adicionarCampoEsquerda("Nome", campoNome, 250);
        adicionarCampoEsquerda("Edição", campoEdicao, 100);
        adicionarCampoEsquerda("Patrocinador", campoPatrocinador, 250);
        adicionarCampoEsquerda("Campeão", campoCampeao, 200);
        adicionarCampoEsquerda("Vice-campeão", campoViceCampeao, 200);
        
        adicionarCampoEsquerda("Qtde. de participantes", campoQtdeParticipantes, 50);
        adicionarCampoEsquerda("Qtde. de fases", campoQtdeFases, 50);
        adicionarCampoEsquerda("Qtde. de partidas", campoQtdePartidas, 50);
        adicionarCampoEsquerda("Qtde. de gols", campoQtdeGols, 50);
        adicionarCampoEsquerda("Média de público", campoMediaPublico, 100);

        campoQtdeParticipantes.addKeyListener(new ListenerInteiro());
        campoQtdeFases.addKeyListener(new ListenerInteiro());
        campoQtdePartidas.addKeyListener(new ListenerInteiro());
        campoQtdeGols.addKeyListener(new ListenerInteiro());
        campoMediaPublico.addKeyListener(new ListenerInteiro());
        
        linha = 100;
        
        adicionarRadios("Foi em pontos corridos?", radioPontosCorridos);
        adicionarRadios("Foi em turno e returno?", radioTurnoReturno);
        adicionarRadios("Foi na Fórmula Fraga?", radioFormulaFraga);
        adicionarRadios("Teve fase de grupos?", radioFaseGrupos);
        adicionarRadios("Teve eliminatórias?", radioEliminatorias);
        
        adicionarCampoDireita("Média de gols", campoMediaGols, 50);
        adicionarCampoDireita("Média de renda", campoMediaRenda, 120);
        
        campoMediaGols.addKeyListener(new ListenerDecimal());
        campoMediaRenda.addKeyListener(new ListenerDecimal());
        
        formatarCampo("##/##/####", campoDataInicio);
        formatarCampo("##/##/####", campoDataFinal);    
        
        adicionarCampoDireita("Data inicial", campoDataInicio, 100);
        adicionarCampoDireita("Data final", campoDataFinal, 100);

        coluna = 40;
        
        adicionarBotaoPercorrer("<<", botaoPrimeiro);
        adicionarBotaoPercorrer("<", botaoAnterior);
        adicionarBotaoPercorrer(">", botaoProximo);
        adicionarBotaoPercorrer(">>", botaoUltimo);

        campoId.setEnabled(false);
        
        prepararFormularioExibir();
        
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setVisible( true );
    }
    
    private void adicionarCampoEsquerda( String legenda, JTextField campo, int largura )
    {
        JLabel label = new JLabel( legenda + ":" );
        label.setBounds( 40, linha, 150, 25 );
        getContentPane().add( label );

        campo.setBounds( 200, linha, largura, 25 );
        campo.setDisabledTextColor(Color.BLACK);
        getContentPane().add( campo );

        linha += 30;
    }
    
    private void adicionarCampoDireita( String legenda, JTextField campo, int largura )
    {
        JLabel label = new JLabel( legenda + ":" );
        label.setBounds( 500, linha, 150, 25 );
        getContentPane().add( label );

        campo.setBounds( 660, linha, largura, 25 );
        campo.setDisabledTextColor(Color.BLACK);
        getContentPane().add( campo );

        linha += 30;
    }
    
    private void adicionarRadios( String legenda, ButtonGroup radios )
    {
        JLabel label = new JLabel( legenda );
        label.setBounds( 500, linha, 150, 25 );
        getContentPane().add( label );
        
        JRadioButton radioSim = new JRadioButton("Sim");
        radioSim.setBounds(660, linha, 50, 25);
        radioSim.setOpaque(false);
        radios.add(radioSim);
        getContentPane().add(radioSim); 
        
        JRadioButton radioNao = new JRadioButton("Não");
        radioNao.setBounds(720, linha, 50, 25);
        radioNao.setOpaque(false);
        radios.add(radioNao);
        getContentPane().add(radioNao); 

        linha += 30;
    }
    
    private void adicionarBotaoPercorrer(String legenda, JButton botao )
    {
        botao.setText(legenda);
        botao.addActionListener(this);
        botao.setBackground(Color.WHITE);
        botao.setBounds(coluna, 450, 50, 30);
        getContentPane().add(botao);
        
        coluna += 60;
    }
    
    private void adicionarBotaoAcao(String legenda, JButton botao )
    {
        botao.setText(legenda);
        botao.addActionListener(this);
        botao.setBackground(Color.WHITE);
        botao.setBounds(coluna, 40, 100, 30);
        getContentPane().add(botao);
        
        coluna += 110;
    }

    private void prepararFormularioExibir()
    {
        campoNome.setEnabled(false);
        campoEdicao.setEnabled(false);
        campoPatrocinador.setEnabled(false);
        campoCampeao.setEnabled(false);
        campoViceCampeao.setEnabled(false);
        campoQtdeParticipantes.setEnabled(false);
        campoQtdeFases.setEnabled(false);
        campoQtdePartidas.setEnabled(false);
        campoQtdeGols.setEnabled(false);
        campoMediaPublico.setEnabled(false);

        Utilidades.desabilitarRadioButton(radioPontosCorridos);
        Utilidades.desabilitarRadioButton(radioTurnoReturno);
        Utilidades.desabilitarRadioButton(radioFormulaFraga);
        Utilidades.desabilitarRadioButton(radioFaseGrupos);
        Utilidades.desabilitarRadioButton(radioEliminatorias);

        campoMediaGols.setEnabled(false);
        campoMediaRenda.setEnabled(false);
        campoDataInicio.setEnabled(false);
        campoDataFinal.setEnabled(false);

        botaoPrimeiro.setEnabled(false);
        botaoAnterior.setEnabled(false);
        botaoProximo.setEnabled(false);
        botaoUltimo.setEnabled(false);

        botaoListar.setEnabled(true);
        botaoPesquisar.setEnabled(true);
        botaoIncluir.setEnabled(true);
        botaoEditar.setEnabled(false);
        botaoExcluir.setEnabled(false);
    }
    
    private void exibirCampeonato(Campeonato campeonato) throws MyException
    {
        if(campeonato != null)
        {
            campeonatoEmExibicao = campeonato;        

            campoId.setText( campeonato.getId().toString() );
            campoNome.setText(campeonato.getNome() );
            campoEdicao.setText(campeonato.getEdicao() );
            campoPatrocinador.setText(campeonato.getPatrocinador() );
            campoCampeao.setText(campeonato.getCampeao() );
            campoViceCampeao.setText(campeonato.getViceCampeao() );

            Utilidades.exibirInteiro(campoQtdeParticipantes, campeonato.getQtdeParticipantes());
            Utilidades.exibirInteiro(campoQtdeFases, campeonato.getQtdeFases());
            Utilidades.exibirInteiro(campoQtdePartidas, campeonato.getQtdePartidas());
            Utilidades.exibirInteiro(campoQtdeGols, campeonato.getQtdeGols());
            Utilidades.exibirInteiro(campoMediaPublico, campeonato.getMediaPublico());

            Utilidades.selecionarRadioButton( radioPontosCorridos, campeonato.isPontosCorridos() );
            Utilidades.selecionarRadioButton( radioTurnoReturno, campeonato.isTurnoReturno() );
            Utilidades.selecionarRadioButton( radioFormulaFraga, campeonato.isFormulaFraga() );
            Utilidades.selecionarRadioButton( radioFaseGrupos, campeonato.isFaseGrupos() );
            Utilidades.selecionarRadioButton( radioEliminatorias, campeonato.isEliminatorias() );
            
            Utilidades.exibirDecimal(campoMediaGols, campeonato.getMediaGols());
            Utilidades.exibirDecimal(campoMediaRenda, campeonato.getMediaRenda());
            
            Utilidades.exibirData(campoDataInicio, campeonato.getDataInicio());
            Utilidades.exibirData(campoDataFinal, campeonato.getDataFinal());

            botaoListar.setEnabled(false); 
            botaoExcluir.setEnabled(true);
            botaoEditar.setEnabled(true);
            
            botaoPrimeiro.setEnabled(true);
            botaoAnterior.setEnabled(true);
            botaoProximo.setEnabled(true);
            botaoUltimo.setEnabled(true);
        }        
    }
    
    public void pesquisarCampeonato() throws MyException
    {
        String[] opcoes = {"Por código", "Por campeonato e edição"};
        
        int pesquisa = JOptionPane.showOptionDialog(
                        null,
                        "Como você quer efetuar a pesquisa?",
                        "Pesquisa de campeonatos", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.PLAIN_MESSAGE,
                        null,                  
                        opcoes,
                        "Cancelar"  
        );
        
        if (pesquisa == 0)
        {
            String codigo;
            do {
                codigo = JOptionPane.showInputDialog("Informe o código:");
            } while (! Utilidades.testaStringNumerica( codigo.trim() ) );
            
            Campeonato campeonato = CampeonatoLocalizador.buscaCampeonatoId( Integer.parseInt(codigo) );
            
            if(campeonato != null)
            {
                campeonatoEmExibicao = campeonato;
                exibirCampeonato(campeonatoEmExibicao);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Não há registro com o código informado");
            }
        }
        else if (pesquisa == 1)
        {
            String condicaoCampeonato;
            String condicaoEdicao;
            do {
                condicaoCampeonato = JOptionPane.showInputDialog("Informe o nome do campeonato:");
                condicaoEdicao = JOptionPane.showInputDialog("Informe a edição da edição:");
            } while (condicaoCampeonato.trim().length() < 1 && condicaoEdicao.trim().length() < 1);
            
            List<String> condicoes = new ArrayList<String>();
            
            if(condicaoCampeonato.trim().length() > 0)
                condicoes.add("nome ILIKE '%"+condicaoCampeonato+"%'");
            if(condicaoEdicao.trim().length() > 0)
                condicoes.add("edicao ILIKE '%"+condicaoEdicao+"%'");
            
            Campeonato campeonato = CampeonatoLocalizador.buscaCampeonatos( condicoes );
            
            if(campeonato != null)
            {
                campeonatoEmExibicao = campeonato;
                exibirCampeonato(campeonatoEmExibicao);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Não há registro com os dados informados");
            }
            
        }
        
    }
    
    public void prepararFormularioIncluir() throws MyException
    {
        limparCampos();
        
        campoId.setText("");

        campoNome.setEnabled(true);
        campoEdicao.setEnabled(true);
        campoPatrocinador.setEnabled(true);
        campoCampeao.setEnabled(true);
        campoViceCampeao.setEnabled(true);
        campoQtdeParticipantes.setEnabled(true);
        campoQtdeFases.setEnabled(true);
        campoQtdePartidas.setEnabled(true);
        campoQtdeGols.setEnabled(true);
        campoMediaPublico.setEnabled(true);

        Utilidades.habilitarRadioButton(radioPontosCorridos);
        Utilidades.habilitarRadioButton(radioTurnoReturno);
        Utilidades.habilitarRadioButton(radioFormulaFraga);
        Utilidades.habilitarRadioButton(radioFaseGrupos);
        Utilidades.habilitarRadioButton(radioEliminatorias);

        campoMediaGols.setEnabled(true);
        campoMediaRenda.setEnabled(true);
        campoDataInicio.setEnabled(true);
        campoDataFinal.setEnabled(true);

        botaoPrimeiro.setEnabled(false);
        botaoAnterior.setEnabled(false);
        botaoProximo.setEnabled(false);
        botaoUltimo.setEnabled(false);

        botaoListar.setEnabled(false);
        botaoPesquisar.setEnabled(false);        
        botaoIncluir.setEnabled(true);
        botaoEditar.setEnabled(false);        
        botaoExcluir.setEnabled(true);
        
        botaoPrimeiro.setEnabled(false);
        botaoAnterior.setEnabled(false);
        botaoProximo.setEnabled(false);
        botaoUltimo.setEnabled(false);
        
        botaoIncluir.setText("Salvar");
        botaoExcluir.setText("Cancelar");
    }
    
    public void incluirCampeonato() throws MyException
    {
        if( validarCampos() )
        {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar as informações?");
        
            if(opcao == 0)
            {
                campeonatoEmEdicao = new Campeonato();
                campeonatoEmEdicao.setNome( Utilidades.limparPrepararTexto( campoNome ) );
                campeonatoEmEdicao.setEdicao( Utilidades.limparPrepararTexto( campoEdicao ) );
                campeonatoEmEdicao.setPatrocinador( Utilidades.limparPrepararTexto( campoPatrocinador ) );
                campeonatoEmEdicao.setCampeao( Utilidades.limparPrepararTexto( campoCampeao ) );
                campeonatoEmEdicao.setViceCampeao( Utilidades.limparPrepararTexto( campoViceCampeao ) );
                campeonatoEmEdicao.setQtdeParticipantes( Utilidades.limparPrepararNumero(campoQtdeParticipantes ) );
                campeonatoEmEdicao.setQtdeFases( Utilidades.limparPrepararNumero( campoQtdeFases ) );
                campeonatoEmEdicao.setQtdePartidas( Utilidades.limparPrepararNumero( campoQtdePartidas ) );
                campeonatoEmEdicao.setQtdeGols( Utilidades.limparPrepararNumero( campoQtdeGols ) );
                campeonatoEmEdicao.setMediaPublico( Utilidades.limparPrepararNumero( campoMediaPublico ) );

                campeonatoEmEdicao.setPontosCorridos( Utilidades.obterRadioButtonSelecionado(radioPontosCorridos) );
                campeonatoEmEdicao.setTurnoReturno( Utilidades.obterRadioButtonSelecionado(radioTurnoReturno) );
                campeonatoEmEdicao.setFormulaFraga( Utilidades.obterRadioButtonSelecionado(radioFormulaFraga) );
                campeonatoEmEdicao.setFaseGrupos( Utilidades.obterRadioButtonSelecionado(radioFaseGrupos) );
                campeonatoEmEdicao.setEliminatorias( Utilidades.obterRadioButtonSelecionado(radioEliminatorias) );

                campeonatoEmEdicao.setMediaGols( Utilidades.limparPrepararDecimal( campoMediaGols ) );
                campeonatoEmEdicao.setMediaRenda( Utilidades.limparPrepararDecimal( campoMediaRenda ) );

                campeonatoEmEdicao.setDataInicio( Utilidades.limparPrepararData( campoDataInicio ) );
                campeonatoEmEdicao.setDataFinal( Utilidades.limparPrepararData( campoDataFinal ) );

                if (CampeonatoPersistor.insereCampeonato(campeonatoEmEdicao))
                {
                    campeonatoEmExibicao = campeonatoEmEdicao;
                    campeonatoEmExibicao.setId( CampeonatoLocalizador.buscaIdAtual() );
                    limparCampos();
                }
            }
        }

    }
    
    public void prepararFormularioEditar()
    {
        campoNome.setEnabled(true);
        campoEdicao.setEnabled(true);
        campoPatrocinador.setEnabled(true);
        campoCampeao.setEnabled(true);
        campoViceCampeao.setEnabled(true);
        campoQtdeParticipantes.setEnabled(true);
        campoQtdeFases.setEnabled(true);
        campoQtdePartidas.setEnabled(true);
        campoQtdeGols.setEnabled(true);
        campoMediaPublico.setEnabled(true);

        Utilidades.habilitarRadioButton(radioPontosCorridos);
        Utilidades.habilitarRadioButton(radioTurnoReturno);
        Utilidades.habilitarRadioButton(radioFormulaFraga);
        Utilidades.habilitarRadioButton(radioFaseGrupos);
        Utilidades.habilitarRadioButton(radioEliminatorias);

        campoMediaGols.setEnabled(true);
        campoMediaRenda.setEnabled(true);
        campoDataInicio.setEnabled(true);
        campoDataFinal.setEnabled(true);

        botaoPrimeiro.setEnabled(false);
        botaoAnterior.setEnabled(false);
        botaoProximo.setEnabled(false);
        botaoUltimo.setEnabled(false);

        botaoListar.setEnabled(false);
        botaoPesquisar.setEnabled(false);        
        botaoIncluir.setEnabled(true);
        botaoEditar.setEnabled(false);        
        botaoExcluir.setEnabled(true);
        
        botaoPrimeiro.setEnabled(false);
        botaoAnterior.setEnabled(false);
        botaoProximo.setEnabled(false);
        botaoUltimo.setEnabled(false);
        
        botaoIncluir.setText("Alterar");
        botaoExcluir.setText("Cancelar");
    }
    
    public void editarCampeonato() throws MyException
    {
        if( validarCampos() )
        {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?");

            if(opcao == 0)
            {
                campeonatoEmEdicao = new Campeonato();
                campeonatoEmEdicao.setId( Integer.parseInt( campoId.getText().toString() ) );
                campeonatoEmEdicao.setNome( Utilidades.limparPrepararTexto( campoNome ) );
                campeonatoEmEdicao.setEdicao( Utilidades.limparPrepararTexto( campoEdicao ) );
                campeonatoEmEdicao.setPatrocinador( Utilidades.limparPrepararTexto( campoPatrocinador ) );
                campeonatoEmEdicao.setCampeao( Utilidades.limparPrepararTexto( campoCampeao ) );
                campeonatoEmEdicao.setViceCampeao( Utilidades.limparPrepararTexto( campoViceCampeao ) );
                campeonatoEmEdicao.setQtdeParticipantes( Utilidades.limparPrepararNumero(campoQtdeParticipantes ) );
                campeonatoEmEdicao.setQtdeFases( Utilidades.limparPrepararNumero( campoQtdeFases ) );
                campeonatoEmEdicao.setQtdePartidas( Utilidades.limparPrepararNumero( campoQtdePartidas ) );
                campeonatoEmEdicao.setQtdeGols( Utilidades.limparPrepararNumero( campoQtdeGols ) );
                campeonatoEmEdicao.setMediaPublico( Utilidades.limparPrepararNumero( campoMediaPublico ) );

                campeonatoEmEdicao.setPontosCorridos( Utilidades.obterRadioButtonSelecionado(radioPontosCorridos) );
                campeonatoEmEdicao.setTurnoReturno( Utilidades.obterRadioButtonSelecionado(radioTurnoReturno) );
                campeonatoEmEdicao.setFormulaFraga( Utilidades.obterRadioButtonSelecionado(radioFormulaFraga) );
                campeonatoEmEdicao.setFaseGrupos( Utilidades.obterRadioButtonSelecionado(radioFaseGrupos) );
                campeonatoEmEdicao.setEliminatorias( Utilidades.obterRadioButtonSelecionado(radioEliminatorias) );

                campeonatoEmEdicao.setMediaGols( Utilidades.limparPrepararDecimal( campoMediaGols ) );
                campeonatoEmEdicao.setMediaRenda( Utilidades.limparPrepararDecimal( campoMediaRenda ) );

                campeonatoEmEdicao.setDataInicio( Utilidades.limparPrepararData( campoDataInicio ) );
                campeonatoEmEdicao.setDataFinal(Utilidades.limparPrepararData( campoDataFinal ) );

                if (CampeonatoPersistor.alteraCampeonato(campeonatoEmEdicao))
                {
                    campeonatoEmExibicao = campeonatoEmEdicao;

                    prepararFormularioExibir();

                    botaoIncluir.setText("Incluir");
                    botaoExcluir.setText("Excluir");

                    exibirCampeonato(campeonatoEmExibicao);
                }
            }
        }

    }

    public void excluirCampeonato() throws MyException
    {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir?");
        
        if(opcao == 0)
        {
            if (CampeonatoPersistor.excluiCampeonato(campeonatoEmExibicao))
            {
                limparCampos();
                exibirCampeonato( CampeonatoLocalizador.buscaCampeonatoPrimeiro() );
            }
        }
    }
    
    public void cancelar() throws MyException
    {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
        
        if(opcao == 0)
        {
            limparCampos();
            prepararFormularioExibir();

            botaoIncluir.setText("Incluir");
            botaoExcluir.setText("Excluir");
            
            exibirCampeonato(campeonatoEmExibicao);
        }
    }
    
    public void limparCampos()
    {     
        campoId.setText("");
        campoNome.setText("");
        campoEdicao.setText("");
        campoPatrocinador.setText("");
        campoCampeao.setText("");
        campoViceCampeao.setText("");
        campoQtdeParticipantes.setText("");
        campoQtdeFases.setText("");
        campoQtdePartidas.setText("");
        campoQtdeGols.setText("");
        campoMediaPublico.setText("");
        
        radioPontosCorridos.clearSelection();
        radioTurnoReturno.clearSelection();
        radioFormulaFraga.clearSelection();
        radioFaseGrupos.clearSelection();
        radioEliminatorias.clearSelection();
        
        campoMediaGols.setText("");
        campoMediaRenda.setText("");
        campoDataInicio.setText("");
        campoDataFinal.setText("");
    }    
    
    public Boolean validarCampos()
    {
        if (! Validacao.validarCampoTexto(campoNome, true, 5, 100, "Nome"))
            return false;
        
        if (! Validacao.validarCampoTexto(campoEdicao, true, 4, 10, "Edição"))
            return false;
        
        if (! Validacao.validarCampoTexto(campoPatrocinador, true, 0, 50, "Patrocinador"))
            return false;
        
        if (! Validacao.validarCampoTexto(campoCampeao, true, 4, 50, "Campeão"))
            return false;
        
        if (! Validacao.validarCampoTexto(campoViceCampeao, true, 4, 50, "Vice-campeão"))
            return false;
        
        if (! Validacao.validarCampoNumerico(campoQtdeParticipantes, true, 2, 200, "Quantidade de participantes"))
            return false;
        
        if (! Validacao.validarCampoNumerico(campoQtdeFases, false, 1, 10, "Quantidade de fases"))
            return false;
        
        if (! Validacao.validarCampoNumerico(campoQtdePartidas, false, 1, 1000, "Quantidade de partidas"))
            return false;
        
        if (! Validacao.validarCampoNumerico(campoQtdeGols, false, 0, 10000, "Quantidade de gols"))
            return false;
        
        if (! Validacao.validarCampoNumerico(campoMediaPublico, false, 0, 100000, "Média de público"))
            return false;

        if (! Validacao.validarCampoRadio(radioPontosCorridos, "Pontos corridos"))
            return false;
        
        if (! Validacao.validarCampoRadio(radioTurnoReturno, "Turno e returno"))
            return false;
        
        if (! Validacao.validarCampoRadio(radioFormulaFraga, "Fórmula Fraga"))
            return false;
        
        if (! Validacao.validarCampoRadio(radioFaseGrupos, "Fase de grupos"))
            return false;
        
        if (! Validacao.validarCampoRadio(radioEliminatorias, "Eliminatórias"))
            return false;

        if (! Validacao.validarCampoDecimal(campoMediaGols, false, 0, 20, "Média de gols"))
            return false;
        
        if (! Validacao.validarCampoDecimal(campoMediaRenda, false, 0, 1000000, "Média de renda"))
            return false;
        
        if (! Validacao.validarCampoData(campoDataInicio, "Data de início"))
            return false;
        
        if (! Validacao.validarCampoData(campoDataFinal, "Data de encerramento"))
            return false;

        return true;
    }

    public static void main(String[] args) throws MyException
    {
        new CampeonatoTela();
    }

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        try {
            JButton botaoClicado = (JButton) ev.getSource();

            if( botaoClicado.getText().equals( "<<" ) )
                exibirCampeonato( CampeonatoLocalizador.buscaCampeonatoPrimeiro() );
            else if( botaoClicado.getText().equals( "<" ) )
                exibirCampeonato( CampeonatoLocalizador.buscaCampeonatoAnterior(campeonatoEmExibicao.getId()) );
            else if( botaoClicado.getText().equals( ">" ) )
                exibirCampeonato( CampeonatoLocalizador.buscaCampeonatoProximo(campeonatoEmExibicao.getId()) );
            else if( botaoClicado.getText().equals( ">>" ) )
                exibirCampeonato( CampeonatoLocalizador.buscaCampeonatoUltimo() );
            else if( botaoClicado.getText().equals( "Listar" ) )
                exibirCampeonato( CampeonatoLocalizador.buscaCampeonatoPrimeiro() );
            else if( botaoClicado.getText().equals( "Pesquisar" ) )
                pesquisarCampeonato();
            else if( botaoClicado.getText().equals( "Incluir" ) )
                prepararFormularioIncluir();
            else if( botaoClicado.getText().equals( "Salvar" ) )
                incluirCampeonato();
            else if( botaoClicado.getText().equals( "Editar" ) )
                prepararFormularioEditar();
            else if( botaoClicado.getText().equals( "Alterar" ) )
                editarCampeonato();            
            else if( botaoClicado.getText().equals( "Excluir" ) )
                excluirCampeonato();
            else if( botaoClicado.getText().equals( "Cancelar" ) )
                cancelar();
        } catch( Exception e ) {

        }
    }

}
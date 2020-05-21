//
// Alunos: Jonatha Cardoso e Márcio Landvoigt
//

package Banco;

import java.sql.Timestamp;

public class Campeonato
{
    private Integer id;
   
    private String nome;
    private String edicao;
    private String patrocinador;
    private String campeao;
    private String viceCampeao;
    
    private Integer qtdeParticipantes;
    private Integer qtdeFases;
    private Integer qtdePartidas;
    private Integer qtdeGols;
    
    private Integer mediaPublico;
    
    private Boolean pontosCorridos;
    private Boolean turnoReturno;
    private Boolean formulaFraga;
    private Boolean faseGrupos;
    private Boolean eliminatorias;
    
    private Double mediaGols;
    private Double mediaRenda;
    
    private Timestamp dataInicio;
    private Timestamp dataFinal; 

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEdicao()
    {
        return edicao;
    }

    public void setEdicao(String edicao)
    {
        this.edicao = edicao;
    }

    public String getPatrocinador()
    {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador)
    {
        this.patrocinador = patrocinador;
    }

    public String getCampeao()
    {
        return campeao;
    }

    public void setCampeao(String campeao)
    {
        this.campeao = campeao;
    }

    public String getViceCampeao()
    {
        return viceCampeao;
    }

    public void setViceCampeao(String viceCampeao)
    {
        this.viceCampeao = viceCampeao;
    }

    public Integer getQtdeParticipantes()
    {
        return qtdeParticipantes;
    }

    public void setQtdeParticipantes(Integer participantes)
    {
        this.qtdeParticipantes = participantes;
    }

    public Integer getQtdeFases()
    {
        return qtdeFases;
    }

    public void setQtdeFases(Integer fases)
    {
        this.qtdeFases = fases;
    }
    
    public Integer getQtdePartidas()
    {
        return qtdePartidas;
    }

    public void setQtdePartidas(Integer partidas)
    {
        this.qtdePartidas = partidas;
    }

    public Integer getQtdeGols()
    {
        return qtdeGols;
    }

    public void setQtdeGols(Integer gols)
    {
        this.qtdeGols = gols;
    }
    
    public Integer getMediaPublico()
    {
        return mediaPublico;
    }

    public void setMediaPublico(Integer mediaPublico)
    {
        this.mediaPublico = mediaPublico;
    }

    public Boolean isPontosCorridos()
    {
        return pontosCorridos;
    }

    public void setPontosCorridos(Boolean pontosCorridos)
    {
        this.pontosCorridos = pontosCorridos;
    }

    public Boolean isTurnoReturno()
    {
        return turnoReturno;
    }

    public void setTurnoReturno(Boolean turnoReturno)
    {
        this.turnoReturno = turnoReturno;
    }

    public Boolean isFormulaFraga()
    {
        return formulaFraga;
    }

    public void setFormulaFraga(Boolean formulaFraga)
    {
        this.formulaFraga = formulaFraga;
    }

    public Boolean isFaseGrupos()
    {
        return faseGrupos;
    }

    public void setFaseGrupos(Boolean faseGrupos)
    {
        this.faseGrupos = faseGrupos;
    }

    public Boolean isEliminatorias()
    {
        return eliminatorias;
    }

    public void setEliminatorias(Boolean eliminatorias)
    {
        this.eliminatorias = eliminatorias;
    }

    public Double getMediaGols()
    {
        return mediaGols;
    }

    public void setMediaGols(Double mediaGols)
    {
        this.mediaGols = mediaGols;
    }

    public Double getMediaRenda()
    {
        return mediaRenda;
    }

    public void setMediaRenda(Double mediaRenda)
    {
        this.mediaRenda = mediaRenda;
    }

    public Timestamp getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio)
    {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFinal()
    {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal)
    {
        this.dataFinal = dataFinal;
    }
    
}
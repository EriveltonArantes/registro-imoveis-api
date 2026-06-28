package com.registroimoveisapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "certidaos")
public class Certidao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String finalidade;
    @Column(nullable = false)
    private String requerente;
    private java.time.LocalDateTime dataEmissao;
    private java.time.LocalDateTime validade;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Imovel getImovel() { return imovel; }
    public void setImovel(Imovel imovel) { this.imovel = imovel; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getFinalidade() { return finalidade; }
    public void setFinalidade(String finalidade) { this.finalidade = finalidade; }
    public String getRequerente() { return requerente; }
    public void setRequerente(String requerente) { this.requerente = requerente; }
    public java.time.LocalDateTime getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(java.time.LocalDateTime dataEmissao) { this.dataEmissao = dataEmissao; }
    public java.time.LocalDateTime getValidade() { return validade; }
    public void setValidade(java.time.LocalDateTime validade) { this.validade = validade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

package com.registroimoveisapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imovels")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matricula;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Double area;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String tipo;
    private java.math.BigDecimal valor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
}

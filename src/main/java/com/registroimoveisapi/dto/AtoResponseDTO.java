package com.registroimoveisapi.dto;

public class AtoResponseDTO {

    private Long id;
    private Long imovelId;
    private String tipo;
    private String numero;
    private String livro;
    private String folha;
    private java.time.LocalDateTime data;
    private java.math.BigDecimal valor;
    private Boolean oficial;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getImovelId() { return imovelId; }
    public void setImovelId(Long imovelId) { this.imovelId = imovelId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getLivro() { return livro; }
    public void setLivro(String livro) { this.livro = livro; }
    public String getFolha() { return folha; }
    public void setFolha(String folha) { this.folha = folha; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public Boolean getOficial() { return oficial; }
    public void setOficial(Boolean oficial) { this.oficial = oficial; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

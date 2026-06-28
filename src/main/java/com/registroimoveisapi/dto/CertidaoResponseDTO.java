package com.registroimoveisapi.dto;

public class CertidaoResponseDTO {

    private Long id;
    private Long imovelId;
    private String tipo;
    private String finalidade;
    private String requerente;
    private java.time.LocalDateTime dataEmissao;
    private java.time.LocalDateTime validade;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getImovelId() { return imovelId; }
    public void setImovelId(Long imovelId) { this.imovelId = imovelId; }
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

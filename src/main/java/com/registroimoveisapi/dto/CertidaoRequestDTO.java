package com.registroimoveisapi.dto;

import jakarta.validation.constraints.*;

public class CertidaoRequestDTO {

    @NotNull(message = "ImovelId é obrigatório")
    @Positive(message = "ImovelId deve ser um ID válido (positivo)")
    private Long imovelId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "finalidade não pode estar em branco")
    private String finalidade;
    @NotBlank(message = "requerente não pode estar em branco")
    private String requerente;
    @NotNull(message = "data emissao não pode ser nulo")
    private java.time.LocalDateTime dataEmissao;
    @NotNull(message = "validade não pode ser nulo")
    private java.time.LocalDateTime validade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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

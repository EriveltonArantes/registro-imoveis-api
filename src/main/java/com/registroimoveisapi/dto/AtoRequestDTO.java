package com.registroimoveisapi.dto;

import jakarta.validation.constraints.*;

public class AtoRequestDTO {

    @NotNull(message = "ImovelId é obrigatório")
    @Positive(message = "ImovelId deve ser um ID válido (positivo)")
    private Long imovelId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "numero não pode estar em branco")
    private String numero;
    @NotBlank(message = "livro não pode estar em branco")
    private String livro;
    @NotBlank(message = "folha não pode estar em branco")
    private String folha;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotNull(message = "oficial não pode ser nulo")
    private Boolean oficial;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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

package com.registroimoveisapi.dto;

import jakarta.validation.constraints.*;

public class ImovelRequestDTO {

    @NotBlank(message = "matricula não pode estar em branco")
    private String matricula;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "area não pode ser nulo")
    private Double area;
    @NotBlank(message = "endereco não pode estar em branco")
    private String endereco;
    @NotBlank(message = "cep não pode estar em branco")
    private String cep;
    @NotBlank(message = "cidade não pode estar em branco")
    private String cidade;
    @NotBlank(message = "uf não pode estar em branco")
    private String uf;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;

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

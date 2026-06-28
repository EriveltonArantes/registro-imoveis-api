package com.registroimoveisapi.dto;

public class ProprietarioResponseDTO {

    private Long id;
    private Long imovelId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private Double participacao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getImovelId() { return imovelId; }
    public void setImovelId(Long imovelId) { this.imovelId = imovelId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public Double getParticipacao() { return participacao; }
    public void setParticipacao(Double participacao) { this.participacao = participacao; }
}

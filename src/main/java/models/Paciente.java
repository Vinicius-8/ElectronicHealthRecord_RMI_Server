package models;

import java.io.Serializable;

/**
 *
 * @author Vinicius
 */
public class Paciente implements Serializable{
    private int id;
    private String nome;
    private String cpf;
    private String dataNasc;
    private String rg;
    private String sexo;
    private String estadoCivil;
    private String endereco;
    private String telefone;
    private String queixa_princial;
    private String alergia;
    private String doenca;
    private String cirurgia;    //já fez alguma cirurgia?
    private String tipo_sanguineo;
    private String gestante;
    private String usa_medicamentos;
    private String diagonstico;
    private String receita;

    public Paciente(){
        
    }
    public Paciente(int id, String nome, String cpf, String dataNasc, String rg, String sexo, String estadoCivil, String endereco, String telefone, String queixa_princial, String alergia, String doenca, String cirurgia, String tipo_sanguineo, String gestante, String usa_medicamentos, String diagonstico, String receita) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.telefone = telefone;
        this.queixa_princial = queixa_princial;
        this.alergia = alergia;
        this.doenca = doenca;
        this.cirurgia = cirurgia;
        this.tipo_sanguineo = tipo_sanguineo;
        this.gestante = gestante;
        this.usa_medicamentos = usa_medicamentos;
        this.diagonstico = diagonstico;
        this.receita = receita;
    }

    public Paciente(String nome, String cpf, String dataNasc, String rg, String sexo, String estadoCivil, String endereco, String telefone, String queixa_princial, String alergia, String doenca, String cirurgia, String tipo_sanguineo, String gestante, String usa_medicamentos, String diagonstico, String receita) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.telefone = telefone;
        this.queixa_princial = queixa_princial;
        this.alergia = alergia;
        this.doenca = doenca;
        this.cirurgia = cirurgia;
        this.tipo_sanguineo = tipo_sanguineo;
        this.gestante = gestante;
        this.usa_medicamentos = usa_medicamentos;
        this.diagonstico = diagonstico;
        this.receita = receita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getQueixa_princial() {
        return queixa_princial;
    }

    public void setQueixa_princial(String queixa_princial) {
        this.queixa_princial = queixa_princial;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getUsa_medicamentos() {
        return usa_medicamentos;
    }

    public void setUsa_medicamentos(String usa_medicamentos) {
        this.usa_medicamentos = usa_medicamentos;
    }

    public String getDiagonstico() {
        return diagonstico;
    }

    public void setDiagonstico(String diagonstico) {
        this.diagonstico = diagonstico;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }


    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", rg=" + rg + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", endereco=" + endereco + ", telefone=" + telefone + ", queixa_princial=" + queixa_princial + ", alergia=" + alergia + ", doenca=" + doenca + ", cirurgia=" + cirurgia + ", tipo_sanguineo=" + tipo_sanguineo + ", gestante=" + gestante + ", usa_medicamentos=" + usa_medicamentos + ", diagonstico=" + diagonstico + ", receita=" + receita + '}';
    }
    
    
    
    
}

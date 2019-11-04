package models;

import java.io.Serializable;

/**
 *
 * @author Vinicius
 */
public class Medico implements Serializable{
    private int id;
    private int crm;
    private String cpf;
    private String nome;
    private String especialidade;
    private String email;
    private String senha;


    public Medico(int id, int crm, String cpf, String nome, String especialidade, String email, String senha) {
        this.id = id;
        this.crm = crm;
        this.cpf = cpf;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }
    
    public Medico(int crm, String cpf, String nome, String especialidade, String email,String senha) {
        this.crm = crm;
        this.cpf = cpf;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }
    public Medico(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", crm=" + crm + ", cpf=" + cpf + ", nome=" + nome + ", especialidade=" + especialidade + ", email=" + email + ", senha=" + senha + '}';
    }
    
                
}

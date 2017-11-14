package barbearia470.br.com.model;
 
/**
 * @author jonascosta
 * @date   03/10/2017
 *
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String sobre_nome;
    private String email;
    private String telefone;
    private boolean enviar_notificacao;
    private String data_nascimento;
    
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobre_nome
     */
    public String getSobre_nome() {
        return sobre_nome;
    }

    /**
     * @param sobre_nome the sobre_nome to set
     */
    public void setSobre_nome(String sobre_nome) {
        this.sobre_nome = sobre_nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the enviar_notificacao
     */
    public boolean isEnviar_notificacao() {
        return enviar_notificacao;
    }

    /**
     * @param enviar_notificacao the enviar_notificacao to set
     */
    public void setEnviar_notificacao(boolean enviar_notificacao) {
        this.enviar_notificacao = enviar_notificacao;
    }

    /**
     * @return the data_nascimento
     */
    public String getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    

}

package barbearia470.br.com.model;

/**
 * @author jonascosta
 * @date   23/08/2017
 *
 */
public class Funcionario {

    private int funcionarioId;
    private String nome;
    private String telefone;
    private String CPF;
    private String CNPJ;
    private String email;
    private String dataContratado;
    private String dataDispensado;
    private boolean ativo;

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
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
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
     * @return the dataContratado
     */
    public String getDataContratado() {
        return dataContratado;
    }

    /**
     * @param dataContratado the dataContratado to set
     */
    public void setDataContratado(String dataContratado) {
        this.dataContratado = dataContratado;
    }

    /**
     * @return the dataDispensado
     */
    public String getDataDispensado() {
        return dataDispensado;
    }

    /**
     * @param dataDispensado the dataDispensado to set
     */
    public void setDataDispensado(String dataDispensado) {
        this.dataDispensado = dataDispensado;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the funcionarioId
     */
    public int getFuncionarioId() {
        return funcionarioId;
    }

    /**
     * @param funcionarioId the funcionarioId to set
     */
    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    /**
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    
    
    
    
    
}

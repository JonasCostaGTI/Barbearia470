package barbearia470.br.com.model;
 
/**
 * @author jonascosta
 * @date   28/08/2017
 *
 */
public class Bebidas {
    
    private int bebidaId;
    private String nome;
    private Double preco;

    /**
     * @return the bebidaId
     */
    public int getBebidaId() {
        return bebidaId;
    }

    /**
     * @param bebidaId the bebidaId to set
     */
    public void setBebidaId(int bebidaId) {
        this.bebidaId = bebidaId;
    }

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
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    

}

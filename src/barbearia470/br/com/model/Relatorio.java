package barbearia470.br.com.model;

import java.math.BigDecimal;

/**
 * @author jonascosta
 * @date 11/09/2017
 *
 */
public class Relatorio {

    private String dataInicial;
    private String dataFinal;
    private String data;
    private String hora;
    private String nomeBarbeiro;
    private BigDecimal soma;
    private int bebidas;
    private int produtos;
    private int outros;
    private int atendimentos;
    private int dinheiro;
    private BigDecimal totalDinheiro;
    private BigDecimal totalServico;
    private BigDecimal totalProdutos;
    private BigDecimal totalBebidas;
    private BigDecimal totalOutros;
    private int cartao;
    private BigDecimal totalCartao;
    private int barba;
    private int cabelo;
    private int barbaCabelo;
    private int degrade;
    private int maquina;
    private int barbeiroId;
    
    

    /**
     * @return the dataInicial
     */
    public String getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    

    /**
     * @return the bebidas
     */
    public int getBebidas() {
        return bebidas;
    }

    /**
     * @param bebidas the bebidas to set
     */
    public void setBebidas(int bebidas) {
        this.bebidas = bebidas;
    }

    /**
     * @return the produtos
     */
    public int getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    /**
     * @return the atendimentos
     */
    public int getAtendimentos() {
        return atendimentos;
    }

    /**
     * @param atendimentos the atendimentos to set
     */
    public void setAtendimentos(int atendimentos) {
        this.atendimentos = atendimentos;
    }

    /**
     * @return the dinheiro
     */
    public int getDinheiro() {
        return dinheiro;
    }

    /**
     * @param dinheiro the dinheiro to set
     */
    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     * @return the cartao
     */
    public int getCartao() {
        return cartao;
    }

    /**
     * @param cartao the cartao to set
     */
    public void setCartao(int cartao) {
        this.cartao = cartao;
    }

    /**
     * @return the barba
     */
    public int getBarba() {
        return barba;
    }

    /**
     * @param barba the barba to set
     */
    public void setBarba(int barba) {
        this.barba = barba;
    }

    /**
     * @return the cabelo
     */
    public int getCabelo() {
        return cabelo;
    }

    /**
     * @param cabelo the cabelo to set
     */
    public void setCabelo(int cabelo) {
        this.cabelo = cabelo;
    }

    /**
     * @return the barbaCabelo
     */
    public int getBarbaCabelo() {
        return barbaCabelo;
    }

    /**
     * @param barbaCabelo the barbaCabelo to set
     */
    public void setBarbaCabelo(int barbaCabelo) {
        this.barbaCabelo = barbaCabelo;
    }

    /**
     * @return the totalDinheiro
     */
    public BigDecimal getTotalDinheiro() {
        return totalDinheiro;
    }

    /**
     * @param totalDinheiro the totalDinheiro to set
     */
    public void setTotalDinheiro(BigDecimal totalDinheiro) {
        this.totalDinheiro = totalDinheiro;
    }

    /**
     * @return the totalCartao
     */
    public BigDecimal getTotalCartao() {
        return totalCartao;
    }

    /**
     * @param totalCartao the totalCartao to set
     */
    public void setTotalCartao(BigDecimal totalCartao) {
        this.totalCartao = totalCartao;
    }

    /**
     * @return the totalServico
     */
    public BigDecimal getTotalServico() {
        return totalServico;
    }

    /**
     * @param totalServico the totalServico to set
     */
    public void setTotalServico(BigDecimal totalServico) {
        this.totalServico = totalServico;
    }

    /**
     * @return the totalProdutos
     */
    public BigDecimal getTotalProdutos() {
        return totalProdutos;
    }

    /**
     * @param totalProdutos the totalProdutos to set
     */
    public void setTotalProdutos(BigDecimal totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    /**
     * @return the totalBebidas
     */
    public BigDecimal getTotalBebidas() {
        return totalBebidas;
    }

    /**
     * @param totalBebidas the totalBebidas to set
     */
    public void setTotalBebidas(BigDecimal totalBebidas) {
        this.totalBebidas = totalBebidas;
    }

    /**
     * @return the dataFinal
     */
    public String getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the barbeiroId
     */
    public int getBarbeiroId() {
        return barbeiroId;
    }

    /**
     * @param barbeiroId the barbeiroId to set
     */
    public void setBarbeiroId(int barbeiroId) {
        this.barbeiroId = barbeiroId;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the nomeBarbeiro
     */
    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }

    /**
     * @param nomeBarbeiro the nomeBarbeiro to set
     */
    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeBarbeiro = nomeBarbeiro;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the soma
     */
    public BigDecimal getSoma() {
        return soma;
    }

    /**
     * @param soma the soma to set
     */
    public void setSoma(BigDecimal soma) {
        this.soma = soma;
    }

    /**
     * @return the outros
     */
    public int getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(int outros) {
        this.outros = outros;
    }

    /**
     * @return the totalOutros
     */
    public BigDecimal getTotalOutros() {
        return totalOutros;
    }

    /**
     * @param totalOutros the totalOutros to set
     */
    public void setTotalOutros(BigDecimal totalOutros) {
        this.totalOutros = totalOutros;
    }

    /**
     * @return the degrade
     */
    public int getDegrade() {
        return degrade;
    }

    /**
     * @param degrade the degrade to set
     */
    public void setDegrade(int degrade) {
        this.degrade = degrade;
    }

    /**
     * @return the maquina
     */
    public int getMaquina() {
        return maquina;
    }

    /**
     * @param maquina the maquina to set
     */
    public void setMaquina(int maquina) {
        this.maquina = maquina;
    }

    
}

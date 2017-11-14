package barbearia470.br.com.model;
 
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jonascosta
 * @date   04/09/2017
 *
 */
public class Venda {
    
    private int idVenda;
    private int idFuncionario;
    private String nomeFuncionario;
    private String dia;
    private int quantidadeBebidas;
    private int quantidadeProdutos;
    private int idServico;
    private String nomeServico;
    private BigDecimal totalVenda;
    private BigDecimal totalProduto;
    private BigDecimal totalBebidas;
    private BigDecimal totalServico;
    private BigDecimal desconto;
    private String pagamento;
    private String hora;
    private int qtd_agua;
    private int qtd_chope;
    private int qtd_refri;
    private int qtd_cerveja;
    private int qtd_oleo;
    private int qtd_pomada;
    private int qtd_gel;
    private int qtd_cera;
    private boolean outros;
    private String descricaoOutros;
    private BigDecimal valorOutros;
    
    

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }


    /**
     * @return the quantidadeBebidas
     */
    public int getQuantidadeBebidas() {
        return quantidadeBebidas;
    }

    /**
     * @param quantidadeBebidas the quantidadeBebidas to set
     */
    public void setQuantidadeBebidas(int quantidadeBebidas) {
        this.quantidadeBebidas = quantidadeBebidas;
    }

    /**
     * @return the quantidadeProdutos
     */
    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    /**
     * @param quantidadeProdutos the quantidadeProdutos to set
     */
    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    /**
     * @return the idServico
     */
    public int getIdServico() {
        return idServico;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    /**
     * @return the nomeServico
     */
    public String getNomeServico() {
        return nomeServico;
    }

    /**
     * @param nomeServico the nomeServico to set
     */
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    /**
     * @return the totalVenda
     */
    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    /**
     * @param totalVenda the totalVenda to set
     */
    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    /**
     * @return the pagamento
     */
    public String getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
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
     * @return the qtd_agua
     */
    public int getQtd_agua() {
        return qtd_agua;
    }

    /**
     * @param qtd_agua the qtd_agua to set
     */
    public void setQtd_agua(int qtd_agua) {
        this.qtd_agua = qtd_agua;
    }

    /**
     * @return the qtd_chope
     */
    public int getQtd_chope() {
        return qtd_chope;
    }

    /**
     * @param qtd_chope the qtd_chope to set
     */
    public void setQtd_chope(int qtd_chope) {
        this.qtd_chope = qtd_chope;
    }

    /**
     * @return the qtd_refri
     */
    public int getQtd_refri() {
        return qtd_refri;
    }

    /**
     * @param qtd_refri the qtd_refri to set
     */
    public void setQtd_refri(int qtd_refri) {
        this.qtd_refri = qtd_refri;
    }

    /**
     * @return the qtd_cerveja
     */
    public int getQtd_cerveja() {
        return qtd_cerveja;
    }

    /**
     * @param qtd_cerveja the qtd_cerveja to set
     */
    public void setQtd_cerveja(int qtd_cerveja) {
        this.qtd_cerveja = qtd_cerveja;
    }

    /**
     * @return the qtd_oleo
     */
    public int getQtd_oleo() {
        return qtd_oleo;
    }

    /**
     * @param qtd_oleo the qtd_oleo to set
     */
    public void setQtd_oleo(int qtd_oleo) {
        this.qtd_oleo = qtd_oleo;
    }

    /**
     * @return the qtd_pomada
     */
    public int getQtd_pomada() {
        return qtd_pomada;
    }

    /**
     * @param qtd_pomada the qtd_pomada to set
     */
    public void setQtd_pomada(int qtd_pomada) {
        this.qtd_pomada = qtd_pomada;
    }

    /**
     * @return the qtd_gel
     */
    public int getQtd_gel() {
        return qtd_gel;
    }

    /**
     * @param qtd_gel the qtd_gel to set
     */
    public void setQtd_gel(int qtd_gel) {
        this.qtd_gel = qtd_gel;
    }

    /**
     * @return the qtd_cera
     */
    public int getQtd_cera() {
        return qtd_cera;
    }

    /**
     * @param qtd_cera the qtd_cera to set
     */
    public void setQtd_cera(int qtd_cera) {
        this.qtd_cera = qtd_cera;
    }

    /**
     * @return the totalProduto
     */
    public BigDecimal getTotalProduto() {
        return totalProduto;
    }

    /**
     * @param totalProduto the totalProduto to set
     */
    public void setTotalProduto(BigDecimal totalProduto) {
        this.totalProduto = totalProduto;
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
     * @return the desconto
     */
    public BigDecimal getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }



    /**
     * @return the valorOutros
     */
    public BigDecimal getValorOutros() {
        return valorOutros;
    }

    /**
     * @param valorOutros the valorOutros to set
     */
    public void setValorOutros(BigDecimal valorOutros) {
        this.valorOutros = valorOutros;
    }

    /**
     * @return the descricaoOutros
     */
    public String getDescricaoOutros() {
        return descricaoOutros;
    }

    /**
     * @param descricaoOutros the descricaoOutros to set
     */
    public void setDescricaoOutros(String descricaoOutros) {
        this.descricaoOutros = descricaoOutros;
    }

    /**
     * @return the outros
     */
    public boolean isOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(boolean outros) {
        this.outros = outros;
    }

 

    
    

    

}

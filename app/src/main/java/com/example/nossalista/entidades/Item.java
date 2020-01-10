package com.example.nossalista.entidades;

/**
 * Classe para "segurar" as informações que vem do banco.
 * É usada como um produto selecionado.
 *
 * @author Diego <diego.santos@hbsis.com.br>
 */


public class Item{

    /**
     * os dois atributos servem para realizar operações no banco.
     * O id é do Item e a fkProduto é a chave estrangeira
     * que faz referencia ao id do Produto.
     *
     */
    private Integer id, fkProduto, fkCarrinho;

    private Produto produto;
    private float qtd;

    public Item(Produto produto, float qtd, Integer id,
                Integer fkProduto){

        this.produto = produto;
        this.qtd = qtd;
        this.id = id;
        this.fkProduto = fkProduto;
    }

    public Item(Produto produto, float qtd, Integer id,
                Integer fkProduto, Integer fkCarrinho){

        this.produto = produto;
        this.qtd = qtd;
        this.id = id;
        this.fkProduto = fkProduto;
        this.fkCarrinho = fkCarrinho;
    }

    public Item(Produto produto){

        this.produto = produto;
        this.fkProduto = produto.getId();
    }

    public Item(){

    }

    public Integer getFkCarrinho() {
        return fkCarrinho;
    }

    public void setFkCarrinho(Integer fkCarrinho) {
        this.fkCarrinho = fkCarrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Integer fkProduto) {
        this.fkProduto = fkProduto;
    }

    /**
     * Apenas criado para testar os selects e inserts nas tabelas
     * (ver classe ItemDAO no pacote dados/systemofaDAO).
     *
     * @author Diego <diego.santos@hbsis.com.br>
     * @return String
     */
    @Override
    public String toString(){

        return getProduto().toString();
    }
}

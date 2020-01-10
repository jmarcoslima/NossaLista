package com.example.nossalista.entidades;

/**
 * Classe criada para "segurar" informações
 * puxadas do banco ou listas.
 *
 * @author Diego <diego.santos@hbsis.com.br></>
 */

public class Produto{

    /**
     * Chave primária no banco,
     * não setar diretamente (o banco usa autoincremento).
     */
    private Integer id;

    /**
     *O nome do produto.
     */
    private String nome;

    /**
     * Atributo categoria é usado para definir para qual
     * lista o produto vai. As categorias do produto são setadas
     * pelo Spinner na activity CadastroProdutoActivity
     *
     * A uri é o caminho da imagem do produto, também setado
     * na activity CadastroProdutoActivity
     */

    private String categoria, uri;

    public Produto(){

    }

    public Produto(String nome, String categoria, String uri){

        this.nome = nome;
        this.categoria = categoria;
        this.uri = uri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Feito para ver se as operações do banco funcionam.
     * (ver classe ProdutoDAO no pacote dados/systemofaDAO).
     *
     * @author Diego <diego.santos@hbsis.com.br>
     * @return String
     */

    @Override
    public String toString(){

        return nome + ", " + id;
    }

}

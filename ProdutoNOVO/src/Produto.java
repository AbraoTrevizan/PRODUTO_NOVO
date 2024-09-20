import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Produto {
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;

    // Esta criando os atributos
    public Produto(String nome, double precoCusto, double precoVenda, LocalDate dataFabricacao, LocalDate dataValidade) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
    }

    // Vai receber nome, preço de compra, preço de venda e data de fabricação
    public Produto(String nome, double precoCusto, double precoVenda, LocalDate dataFabricacao) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataFabricacao.plusMonths(1); // vai adicionar 1 mes
    }

    // Vai receber nome e preço
    public Produto(String nome, double precoCusto) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoCusto * 1.10; // 10% que sera a mais doque custou o produto 
        this.dataFabricacao = LocalDate.now();
        this.dataValidade = dataFabricacao.plusMonths(1); // vai adicionar 1 mes
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // pergunta o nome do produto
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        // pergunta o preço de custo
        System.out.println("Digite o preço de custo:");
        double precoCusto = scanner.nextDouble();
        // pergunta o preço de venda
        System.out.println("Digite o preço de venda:");
        double precoVenda = scanner.nextDouble();
        // pergunta a data de fabricaçao
        System.out.println("Digite a data de fabricação (dd/MM/yyyy):");
        scanner.nextLine(); // vai estar lendo o que o usuario escreveu e tranformar em string
        String dataFabricacaoStr = scanner.nextLine();
        LocalDate dataFabricacao = LocalDate.parse(dataFabricacaoStr, formatter);

        Produto produto = new Produto(nome, precoCusto, precoVenda, dataFabricacao);
        // vai mostrar ao usuario as informaçoes nome do produto, custo dele, preço de venda deele, data de fabricaçao e data de validade
        System.out.println("Produto criado: " + produto.getNome());
        System.out.println("Preço de custo: " + produto.getPrecoCusto());
        System.out.println("Preço de venda: " + produto.getPrecoVenda());
        System.out.println("Data de fabricação: " + produto.getDataFabricacao());
        System.out.println("Data de validade: " + produto.getDataValidade());

        scanner.close();
    }
}

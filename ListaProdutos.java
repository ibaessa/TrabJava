import java.util.Scanner;

public class ListaProdutos {

    public static void inserirProdutos(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarProdutos(matriz, linhas, colunas);
        do {
            System.out.println("Informe onde você deseja inserir o produto com valores de 1 à " + linhas);
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);

        scanner.nextLine(); // Limpar o buffer

        System.out.println("Insira o nome do produto: ");
        matriz[linha - 1][0] = scanner.nextLine();
        System.out.println("Insira a quantidade de produtos: ");
        matriz[linha - 1][1] = scanner.nextLine();
        System.out.println("Insira o valor do produto: ");
        matriz[linha - 1][2] = scanner.nextLine();
        System.out.println("Insira a observação do produto: ");
        matriz[linha - 1][3] = scanner.nextLine();
        System.out.println("Produto adicionado.");
    }

    public static void mostrarProdutos(String[][] matriz, int linhas, int colunas) {
        System.out.println("Produto | Quantidade | Valor | Observação");
        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null) {
                for (int j = 0; j < colunas; j++) {
                    System.out.print(matriz[i][j] + " | ");
                }
                System.out.println();
            }
        }
    }

    public static void calcularValor(String[][] matriz, int linhas) {
        float valorFinal = 0.0f;
        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null) {
                valorFinal += Float.parseFloat(matriz[i][1]) * Float.parseFloat(matriz[i][2]);
            }
        }
        System.out.println("Valor final da lista de compras: " + valorFinal + " R$");
    }

    public static void removerProduto(String[][] matriz, int linhas, String nomeProduto) {
        boolean encontrado = false;
        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null && matriz[i][0].equals(nomeProduto)) {
                encontrado = true;
                matriz[i][0] = null;
                matriz[i][1] = null;
                matriz[i][2] = null;
                matriz[i][3] = null;
            }
        }
        if (encontrado) {
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void main(String[] args) {
        String[][] lista;
        int produtos, opcao;
        int colunas = 4;
        Scanner scanner = new Scanner(System.in);
        String nomeProduto;

        System.out.println("Insira a quantidade de produtos que serão inseridos na sua lista de compras:");
        produtos = scanner.nextInt();
        lista = new String[produtos][colunas];

        do {
            System.out.println("Escolha uma opção: \n 1 - Mostrar lista de compras. \n 2 - Inserir produtos na lista de compras. \n 3 - Calcular valor dos produtos da lista de compras. \n 4

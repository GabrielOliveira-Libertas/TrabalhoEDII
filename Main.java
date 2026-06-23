package trabalhoedii;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreLivros arvore = new ArvoreLivros();
        Scanner inseridor = new Scanner(System.in);

        arvore.inserir(new Livro("Freddie Mercury: A Biografia Definitiva", "Lesley-Ann Jones", 2011));
        arvore.inserir(new Livro("Rita Lee: Uma Autobiografia", "Rita Lee", 2016));
        arvore.inserir(new Livro("Bob Dylan: Cronicas", "Bob Dylan", 2004));
        arvore.inserir(new Livro("Michael Jackson: A Magia e a Loucura", "J. Randy Taraborrelli", 2003));
        arvore.inserir(new Livro("David Bowie: Uma Biografia", "Marc Spitz", 2009));
        arvore.inserir(new Livro("Kurt Cobain: Mais Pesado que o Ceu", "Charles R. Cross", 2001));
        arvore.inserir(new Livro("Elton John: Eu", "Elton John", 2019));
        arvore.inserir(new Livro("Tim Maia: Vale Tudo", "Nelson Motta", 2007));

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU DO CATALOGO ===");
            System.out.println("1 - Inserir Livro");
            System.out.println("2 - Buscar por Titulo");
            System.out.println("3 - Remover Livro");
            System.out.println("4 - Exibir Em-Ordem");
            System.out.println("5 - Exibir Pre-Ordem");
            System.out.println("6 - Exibir Pos-Ordem");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = inseridor.nextInt();
            inseridor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o titulo: ");
                    String titulo = inseridor.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = inseridor.nextLine();
                    System.out.print("Digite o ano: ");
                    int ano = inseridor.nextInt();
                    inseridor.nextLine();
                    
                    arvore.inserir(new Livro(titulo, autor, ano));
                    System.out.println("Livro inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o titulo para buscar: ");
                    String buscaTitulo = inseridor.nextLine();
                    arvore.buscar(buscaTitulo);
                    break;

                case 3:
                    System.out.print("Digite o titulo para remover: ");
                    String removeTitulo = inseridor.nextLine();
                    arvore.remover(removeTitulo);
                    break;

                case 4:
                    System.out.println("\n--- Exibindo Em-Ordem (Alfabetica) ---");
                    arvore.exibirEmOrdem();
                    break;

                case 5:
                    System.out.println("\n--- Exibindo Pre-Ordem ---");
                    arvore.exibirPreOrdem();
                    break;

                case 6:
                    System.out.println("\n--- Exibindo Pos-Ordem ---");
                    arvore.exibirPosOrdem();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }

        inseridor.close();
    }
}
package trabalhoedii;

public class ArvoreLivros {
    private No raiz;

    public ArvoreLivros() {
        this.raiz = null;
    }

    public void inserir(Livro livro) {
        this.raiz = inserirRecursivo(this.raiz, livro);
    }

    private No inserirRecursivo(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }

        int comparacao = livro.compareTo(atual.livro);

        if (comparacao < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, livro);
        } else if (comparacao > 0) {
            atual.direita = inserirRecursivo(atual.direita, livro);
        }

        return atual;
    }

    public void buscar(String titulo) {
        No resultado = buscarRecursivo(this.raiz, titulo);
        if (resultado != null) {
            System.out.println("Livro encontrado: " + resultado.livro);
        } else {
            System.out.println("Livro não encontrado: " + titulo);
        }
    }

    private No buscarRecursivo(No atual, String titulo) {
        if (atual == null || atual.livro.getTitulo().equalsIgnoreCase(titulo)) {
            return atual;
        }

        int comparacao = titulo.compareToIgnoreCase(atual.livro.getTitulo());

        if (comparacao < 0) {
            return buscarRecursivo(atual.esquerda, titulo);
        } else {
            return buscarRecursivo(atual.direita, titulo);
        }
    }

    public void exibirEmOrdem() {
        emOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void emOrdemRecursivo(No atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda);
            System.out.println(atual.livro);
            emOrdemRecursivo(atual.direita);
        }
    }

    public void exibirPreOrdem() {
        preOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void preOrdemRecursivo(No atual) {
        if (atual != null) {
            System.out.print(atual.livro.getTitulo() + " -> ");
            preOrdemRecursivo(atual.esquerda);
            preOrdemRecursivo(atual.direita);
        }
    }

    public void exibirPosOrdem() {
        posOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void posOrdemRecursivo(No atual) {
        if (atual != null) {
            posOrdemRecursivo(atual.esquerda);
            posOrdemRecursivo(atual.direita);
            System.out.print(atual.livro.getTitulo() + " -> ");
        }
    }

    public void remover(String titulo) {
        this.raiz = removerRecursivo(this.raiz, titulo);
    }

    private No removerRecursivo(No atual, String titulo) {
        if (atual == null) {
            System.out.println("Livro não encontrado para remoção.");
            return null;
        }

        int comparacao = titulo.compareToIgnoreCase(atual.livro.getTitulo());

        if (comparacao < 0) {
            atual.esquerda = removerRecursivo(atual.esquerda, titulo);
        } else if (comparacao > 0) {
            atual.direita = removerRecursivo(atual.direita, titulo);
        } else {
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }

            No sucessor = encontrarMenor(atual.direita);
            atual.livro = sucessor.livro;
            atual.direita = removerRecursivo(atual.direita, sucessor.livro.getTitulo());
        }

        return atual;
    }

    private No encontrarMenor(No atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }
}
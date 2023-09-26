package projeto.livraria.ufpb.br;

import java.io.Serializable;
import java.util.Objects;

public class Autor implements Serializable {
    private String nome;
    private int anoDoLancamento;

    public Autor(String nome, int anoDoLancamento) {
        this.nome = nome;
        this.anoDoLancamento = anoDoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDoLancamento() {
        return anoDoLancamento;
    }

    public void setAnoDoLancamento(int anoDoLancamento) {
        this.anoDoLancamento = anoDoLancamento;
    }

    @Override
    public String toString() {
        return "Contato: " +
                "\nnome: " + nome +
                "\nanoDoLancamento: " + anoDoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return anoDoLancamento == autor.anoDoLancamento && nome.equals(autor.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDoLancamento);
    }
}

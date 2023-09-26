package projeto.livraria.ufpb.br;

import br.ufpb.dcx.agenda.Contato;

import java.util.Collection;

public interface Livraria {

    public boolean cadastraContato(String nome, int dia, int mes);
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes);
    public boolean removeContato(String nome);
}

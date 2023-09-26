package projeto.livraria.ufpb.br;

import br.ufpb.dcx.agenda.Contato;
import br.ufpb.dcx.agenda.GravadorDeDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LivrariaRapha implements Livraria {
    private Map<String, Contato> contatos;
    private GravadorDeDados gravador = new GravadorDeDados();

    public LivrariaRapha(){
        this.contatos = new HashMap<>();
        recuperaDados();
    }

    public void salvarDados(){
        try {
            this.gravador.salvarContatos(this.contatos);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void recuperaDados(){
        try {
            this.contatos = this.gravador.recuperarContatos();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (!contatos.containsKey(nome)){
            this.contatos.put(nome, new Contato(nome, dia, mes));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> contatosAchados = new ArrayList<>();
        for (Contato c: this.contatos.values()){
            if (c.getDiaAniversario()==dia && c.getMesAniversario()==mes){
                contatosAchados.add(c);
            }
        }
        return contatosAchados;
    }

    @Override
    public boolean removeContato(String nome) {
        if (this.contatos.containsKey(nome)){
            this.contatos.remove(nome);
            return true;
        } else{
            return false;
        }
    }
}

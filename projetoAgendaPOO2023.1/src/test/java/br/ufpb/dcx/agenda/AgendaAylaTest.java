package br.ufpb.dcx.agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;

class AgendaAylaTest {
    @Test
    public void testaCadastro(){
        AgendaAyla agenda = new AgendaAyla();
        assertTrue(agenda.pesquisaAniversariantes(3,3).size()==0);
        agenda.cadastraContato("Juliana",3,3);
        assertEquals(1, agenda.pesquisaAniversariantes(3,3).size());
        assertTrue(agenda.pesquisaAniversariantes(3,3).contains(new Contato("Juliana",3,3)));
    }

    @Test
    public void testaGravacao(){
        File f = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if (f.exists()){
            f.delete();
        }
        AgendaAyla agenda = new AgendaAyla();
        agenda.cadastraContato("Ana",1,1);
        agenda.salvarDados();
        assertEquals(1, agenda.pesquisaAniversariantes(1,1).size());
        assertTrue(f.exists());
        f.delete();
    }
}
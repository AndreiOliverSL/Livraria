package projeto.livraria.ufpb.br;

import br.ufpb.dcx.agenda.Agenda;
import br.ufpb.dcx.agenda.Contato;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class LivrariaSearchController implements ActionListener {
    private br.ufpb.dcx.agenda.Agenda agenda;
    private JFrame janelaPrincipal;

    public LivrariaSearchController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o dia do mês a pesquisar? [1-31]"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o mês a pesquisar?[1-12]" ));
        Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(dia, mes);
        if (aniversariantes.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariantes encontrados:");
            for (Contato c: aniversariantes){
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrado nenhum aniversariante nesta data");
        }
    }
}

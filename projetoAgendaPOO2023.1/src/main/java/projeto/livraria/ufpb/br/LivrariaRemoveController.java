package projeto.livraria.ufpb.br;

import br.ufpb.dcx.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LivrariaRemoveController implements ActionListener {
    private br.ufpb.dcx.agenda.Agenda agenda;
    private JFrame janelaPrincipal;
    public LivrariaRemoveController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o nome do aniversariante a remover?");
        boolean removeu = agenda.removeContato(nome);
        if (removeu){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante não foi encontrado. "+
                            "Operação não realizada");
        }
    }
}

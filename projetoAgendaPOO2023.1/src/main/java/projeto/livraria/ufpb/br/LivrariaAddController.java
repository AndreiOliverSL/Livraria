package projeto.livraria.ufpb.br;

import br.ufpb.dcx.agenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivrariaAddController implements ActionListener {
    private Livraria livraria;
    private JFrame janelaPrincipal;

    public LivrariaAddController(Livraria livraria, JFrame janela) {
        this.livraria = livraria;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o nome do livro está buscando?");
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o ano do livro? "));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o mês em que nasceu?[1-12]" ));
        boolean cadastrou = livraria.cadastraLivro(nome,  );
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante cadastrado");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante não foi cadastrado. " +
                            "Verifique se já não existia");
        }
    }

}

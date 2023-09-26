package projeto.livraria.ufpb.br;

import br.ufpb.dcx.agenda.Contato;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDadosLivros {
    public static final String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, br.ufpb.dcx.agenda.Contato> recuperarContatos() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS));
            return (HashMap<String, br.ufpb.dcx.agenda.Contato>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os contatos");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CONTATOS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }

    public void salvarContatos(Map<String, Contato> contatos) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS));
            out.writeObject(contatos);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os contatos no arquivo "+ARQUIVO_CONTATOS);
        }
    }
}

package domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private String descricao;
    private boolean visibilidade;
    private List<Questao> questoes;

    public Biblioteca() {
        questoes = new ArrayList<>();
    }

    public Biblioteca(String nome) {
        this.nome = nome;
        this.questoes = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        texto.append("Nome: " + this.nome + "\n");
        texto.append("Descricao: " + this.descricao + "\n");
        texto.append("Questoes: " + "\n");

        for (int i = 0; !questoes.isEmpty(); i++) {
            texto.append("Questao " + (i + 1));
            texto.append(questoes.get(i).toString());
        }

        return texto.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public void novaQuestao(Questao questao) {
        questoes.add(questao);
    }

    public void apagarQuestao(Questao questao) {
        questoes.remove(questao);
    }

    public void compartilhar(boolean permitirEdicao) {
        // Lógica para compartilhar a biblioteca com outro usuário
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
}

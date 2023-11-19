package domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Questao {
    private String enunciado;
    private String observacao;
    private boolean visibilidade;
    private List<Fonte> fontes;
    private List<Tag> tags;
    private List<Alternativa> alternativas;

    public Questao(String enunciado, List<Alternativa> alternativas) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.tags = new ArrayList<>();
        this.fontes = new ArrayList<>();
        this.visibilidade = false;
    }

    public Questao() {
        this.fontes = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.alternativas = new ArrayList<>();
        this.visibilidade = false;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public void novaFonte(Fonte fonte) {
        fontes.add(fonte);
    }

    public void apagarFonte(Fonte fonte) {
        fontes.remove(fonte);
    }

    public void novaTag(Tag tag) {
        tags.add(tag);
    }

    public void apagarTag(Tag tag) {
        tags.remove(tag);
    }

    public void novaAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }

    public void apagarAlternativa(Alternativa alternativa) {
        alternativas.remove(alternativa);
    }

    public List<Fonte> getFontes() {
        return fontes;
    }

    public void setFontes(List<Fonte> fontes) {
        this.fontes = fontes;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setTags(String stringTags) {
        // Quebra a string por espaços em branco
        String[] conjuntoTags = stringTags.split("\\s+");
        for (String tag : conjuntoTags) {
            this.tags.add(new Tag(tag));
        }
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
}

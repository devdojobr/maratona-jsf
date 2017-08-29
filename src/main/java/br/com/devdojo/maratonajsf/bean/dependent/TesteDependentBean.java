package br.com.devdojo.maratonajsf.bean.dependent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

/**
 * Created by William on 4/6/2017.
 */
@Named
@Dependent
public class TesteDependentBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    private List<String> categoriasList = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println(" Entrou no PostConstruct do @Dependent");
        personagens = asList("Naruto", "Hinata", "Yondaime");
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }

    public List<String> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<String> categoriasList) {
        this.categoriasList = categoriasList;
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}

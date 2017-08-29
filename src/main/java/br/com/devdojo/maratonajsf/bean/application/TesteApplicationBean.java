package br.com.devdojo.maratonajsf.bean.application;

import br.com.devdojo.maratonajsf.bean.dependent.TesteDependentBean;
import br.com.devdojo.maratonajsf.bean.session.TesteSessionBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by William on 3/27/2017.
 */
@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;
    private final TesteDependentBean dependentBean;
    private final TesteSessionBean sessionBean;
    @Inject
    public TesteApplicationBean(TesteDependentBean dependentBean,
                                TesteSessionBean sessionBean) {
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }


    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ApplicationScoped ");
        categoriaList = asList("RPG","SCI-FI","Terror");
        dependentBean.getCategoriasList().addAll(asList("Comdia","Romance"));
        sessionBean.selecionarPersonagem();
    }

    public TesteSessionBean getSessionBean() {
        return sessionBean;
    }

    public void mudarLista(){
        categoriaList = asList("RPG","SCI-FI","Terror","Porn");

    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}

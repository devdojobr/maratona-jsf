package br.com.devdojo.maratonajsf.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by William on 4/12/2017.
 */
@Named
@ViewScoped
public class ComunicacaoTeste2Bean implements Serializable {
    @Inject @Param(name = "nome")
    private String nome;
    @Inject @Param(name = "sobrenome")
    private String sobrenome;

    @PostConstruct
    public void init(){
        System.out.println("criou comunicacao 2");
//        Map<String, String> paramsMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        nome = paramsMap.get("nome");
//        sobrenome = paramsMap.get("sobrenome");
        System.out.println(nome);
        System.out.println(sobrenome);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}

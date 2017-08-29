package br.com.devdojo.maratonajsf.bean.login;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

/**
 * Created by William on 4/10/2017.
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String nome;
    private String senha;
    private Estudante estudante;
    private List<Locale> localeList = asList(new Locale("en"), new Locale("pt"));
    private String language;
    private int qtdeMensagens;
    public String logar() {
        //Faz uma busca no banco
        if (nome.equals("w") && senha.equals("1")){
            estudante = new Estudante();
            qtdeMensagens++;
            return "/restricted/iniciosistema.xhtml?faces-redirect=true";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new
                FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario e/ou senha invalidos",""));
        return null;
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        estudante = null;
        return "/login?faces-redirect=true";
    }

    public int getQtdeMensagens() {
        return qtdeMensagens;
    }

    public void setQtdeMensagens(int qtdeMensagens) {
        this.qtdeMensagens = qtdeMensagens;
    }

    public List<Locale> getLocaleList() {
        return localeList;
    }

    public void setLocaleList(List<Locale> localeList) {
        this.localeList = localeList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}

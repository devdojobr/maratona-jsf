package br.com.devdojo.maratonajsf.bean.html5;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author William Suane on 5/30/2017.
 */
@Named
@ViewScoped
public class Html5TesteBean implements Serializable{
    private String email;
    private String nome;
    private String url;
    private int numero;

    private Map<String,String> attributes = new HashMap<>();
    public void init(){
        attributes.put("type","email");
        attributes.put("placeholder","Digite seu email");
    }

    public void salvar(){
        System.out.println(email);
        System.out.println(url);
        System.out.println(numero);
    }
    public void toUpperCaseNome() {
        this.nome = this.nome.toUpperCase();
    }
    public String getUrl() {
        return url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}

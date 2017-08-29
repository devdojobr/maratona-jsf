package br.com.devdojo.maratonajsf.bean.flowbuilder;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by William on 4/4/2017.
 */
@Named
@FlowScoped(value = "newpendencies")
public class TesteFlowBuilderNestedBean implements Serializable {
    private String userName;
    private String userSurname;

    public String validarUser(){
        System.out.println("Fazendo consulta no SERASA");
        System.out.println("Fazendo consulta no SPC");
        System.out.println("Pedindo a permissao de Deus");
        System.out.println("Sacrificando um bode");
//        if(true){
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Usuario nao passou nas pendencias","Algum detalhe util"));
//            return null;
//        }
        return "proceedToNewRegistration3";
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}

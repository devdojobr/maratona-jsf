package br.com.devdojo.maratonajsf.bean.validator;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author William Suane on 5/3/2017.
 */
@Named
@ViewScoped
public class ValidatorTesteBean implements Serializable {
    private Estudante estudante = new Estudante();

    public void save(){
        System.out.println("Salvando");
        System.out.println(estudante.getEmail());
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}

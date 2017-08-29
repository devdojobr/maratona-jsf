package br.com.devdojo.maratonajsf.bean.converter;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author William Suane on 5/3/2017.
 */
@Named
@ViewScoped
public class ConverterTesteBean implements Serializable {
    private List<Estudante> estudanteList = Estudante.estudanteList();
    private Estudante estudante;

    public void save(){
        System.out.println("Salvando");
        System.out.println(estudante);
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}

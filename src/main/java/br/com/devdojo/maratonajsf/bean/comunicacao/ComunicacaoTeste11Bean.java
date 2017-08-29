package br.com.devdojo.maratonajsf.bean.comunicacao;

import br.com.devdojo.maratonajsf.model.Estudante;
import br.com.devdojo.maratonajsf.util.ApplicationMapUtil;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author William Suane on 4/20/2017.
 */
@Named
@ViewScoped
public class ComunicacaoTeste11Bean implements Serializable {
   private List<Estudante> estudanteList = Estudante.estudanteList();

   public String editar(Estudante estudante){
       ApplicationMapUtil.setValueInApplicationMap("estudante",estudante);
       return "comunicacao12?faces-redirect=true";
   }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}

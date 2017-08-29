package br.com.devdojo.maratonajsf.bean.datatable;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author William Suane on 5/5/2017.
 */
@Named
@ViewScoped
public class DataTableTesteBean implements Serializable {
    private List<Estudante> estudanteList = Estudante.estudanteList();
    private Set<Estudante> estudanteSet = new HashSet<>(Estudante.estudanteList());
    private List<Estudante> estudanteLinkedList = new LinkedList<>(Estudante.estudanteList());
    private Map<String, Estudante> mapEstudanteList = new HashMap<>();

    public void init() {
        mapEstudanteList.put("Estudante 1", new Estudante(1, "Ikki", "Fenix", 10));
        mapEstudanteList.put("Estudante 2", new Estudante(2, "Shiryu", "Dragao", 10));
        mapEstudanteList.put("Estudante 3", new Estudante(3, "Seiya", "Pegasus", 10));
    }

    public void orderByNome(String ordem) {
        if (ordem.equals("asc"))
            estudanteList.sort(Comparator.comparing(Estudante::getNome));
        else
            estudanteList.sort(Comparator.comparing(Estudante::getNome).reversed());
    }

    public void orderBySobrenome(String ordem) {
        if (ordem.equals("asc"))
            estudanteList.sort(Comparator.comparing(Estudante::getSobrenome));
        else
            estudanteList.sort(Comparator.comparing(Estudante::getSobrenome).reversed());
    }

    public void remove(Estudante estudante) {
        //Faz uma chamada para o banco
        estudanteList.remove(estudante);
    }

    public void edit(Estudante estudante) {
        estudante.setEditing(true);
    }

    public void save() {
        estudanteList.forEach(estudante -> {
                    if (estudante.isEditing())
                        System.out.println(estudante);
                    estudante.setEditing(false);
                });
    }

    public Map<String, Estudante> getMapEstudanteList() {
        return mapEstudanteList;
    }

    public void setMapEstudanteList(Map<String, Estudante> mapEstudanteList) {
        this.mapEstudanteList = mapEstudanteList;
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public Set<Estudante> getEstudanteSet() {
        return estudanteSet;
    }

    public void setEstudanteSet(Set<Estudante> estudanteSet) {
        this.estudanteSet = estudanteSet;
    }

    public List<Estudante> getEstudanteLinkedList() {
        return estudanteLinkedList;
    }

    public void setEstudanteLinkedList(List<Estudante> estudanteLinkedList) {
        this.estudanteLinkedList = estudanteLinkedList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }
}

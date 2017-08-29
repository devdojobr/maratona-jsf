package br.com.devdojo.maratonajsf.model;

import br.com.devdojo.maratonajsf.model.enums.Turno;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by William on 3/9/2017.
 */
public class Estudante implements Serializable {
    private Integer id;
    private String nome = "William";
    private String sobrenome = "Suane";
    private double nota1 = 20;
    private double nota2;
    private double nota3 = 10;
    private Turno turno = Turno.MATUTINO;
    private String email;
    private transient boolean editing;
    public Estudante() {
    }

    public Estudante(String nome, String sobrenome, double nota1) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nota1 = nota1;
    }
    public Estudante(Integer id, String nome, String sobrenome, double nota1) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nota1 = nota1;
    }


    public static List<Estudante> estudanteList() {
        return new ArrayList<>(asList(new Estudante(1,"Ikki", "Fenix", 10),
                new Estudante(2,"Shiryu", "Dragao", 10),
                new Estudante(2,"Shiryu", "Dragao", 10),
                new Estudante(3,"Seiya", "Pegasus", 10)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudante estudante = (Estudante) o;

        return id != null ? id.equals(estudante.id) : estudante.id == null;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", turno=" + turno +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
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

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
}

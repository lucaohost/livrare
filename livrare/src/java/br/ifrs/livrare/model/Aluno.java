package br.ifrs.livrare.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(
        name = "aluno",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "nome")}
)
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}

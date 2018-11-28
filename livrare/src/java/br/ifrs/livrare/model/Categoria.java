package br.ifrs.livrare.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}

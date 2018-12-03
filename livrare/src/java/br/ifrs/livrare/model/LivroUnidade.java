package br.ifrs.livrare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "livro_unidade")
public class LivroUnidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "livro_didatico_id")
    @ManyToOne
    private LivroDidatico livro = new LivroDidatico();  
    @Column(nullable = false, length = 250)
    private String codigoDeBarras;
    @OneToMany(mappedBy = "livro_unidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprestimo> emprestimosEnvolvidos = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LivroDidatico getLivro() {
        return livro;
    }

    public void setLivro(LivroDidatico livro) {
        this.livro = livro;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroUnidade other = (LivroUnidade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.codigoDeBarras, other.codigoDeBarras)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LivroUnidade{" + "id=" + id + ", livro=" + livro + ", codigoDeBarras=" + codigoDeBarras + ", emprestimosEnvolvidos=" + emprestimosEnvolvidos + '}';
    }
    
}

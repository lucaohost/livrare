package br.ifrs.livrare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "livro_didatico")
public class LivroDidatico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "categoria_id")
    @ManyToOne
    private Categoria categoria = new Categoria();
    @Column(nullable = false, length = 100)
    private String fotoCapa;
    @Column(nullable = false, length = 100)
    private String isbn;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 10)
    private String volume;
    @Column(nullable = false, length = 100)
    private String autor;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LivroUnidade> livros = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(String fotoCapa) {
        this.fotoCapa = fotoCapa;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<LivroUnidade> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroUnidade> livros) {
        this.livros = livros;
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
        final LivroDidatico other = (LivroDidatico) obj;
        if (!Objects.equals(this.fotoCapa, other.fotoCapa)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.volume, other.volume)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LivroDidatico{" + "id=" + id + ", categoria=" + categoria + ", fotoCapa=" + fotoCapa + ", isbn=" + isbn + ", nome=" + nome + ", volume=" + volume + ", autor=" + autor + '}';
    }

}

package br.ifrs.livrare.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "livro_unidade_id")
    @ManyToOne
    private LivroUnidade livroAlocado = new LivroUnidade();
    @JoinColumn(name = "aluno_id")
    @ManyToOne
    private Aluno aluno = new Aluno();
    @Column(nullable = false, length = 10)
    String estado;
    @Column
    boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LivroUnidade getLivroAlocado() {
        return livroAlocado;
    }

    public void setLivroAlocado(LivroUnidade livroAlocado) {
        this.livroAlocado = livroAlocado;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
        final Emprestimo other = (Emprestimo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.livroAlocado, other.livroAlocado)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", livroAlocado=" + livroAlocado + ", aluno=" + aluno + ", estado=" + estado + ", ativo=" + ativo + '}';
    }
    
}

package br.ifrs.livrare.dao;

import br.ifrs.livrare.model.Categoria;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CategoriaDAO {

    private EntityManager em;

    public void salvar(Categoria categoria) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(categoria);
        this.em.getTransaction().commit();
        this.em.close();
    }
    
    public void atualizar(Categoria categoria) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(categoria);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Categoria entity = this.em.find(Categoria.class, id);
        if (entity != null) {
            this.em.remove(entity);
        }
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<Categoria> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Categoria> query = this.em.createQuery(" Select c from Categoria c where lower(c.nome) like :nome order by c.nome", Categoria.class);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");
        List<Categoria> categorias = query.getResultList();
        this.em.close();
        // preenche livros com null para biblioteca GSON conseguir converter
        for (Categoria categoria : categorias) {
            categoria.setLivros(null);
        }
        return categorias;
    }

}

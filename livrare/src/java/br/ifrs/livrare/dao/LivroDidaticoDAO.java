package br.ifrs.livrare.dao;

import br.ifrs.livrare.model.LivroDidatico;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LivroDidaticoDAO {

    private EntityManager em;

    public void salvar(LivroDidatico livro) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(livro);
        this.em.getTransaction().commit();
        this.em.close();
    }
    
    public void atualizar(LivroDidatico livro) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(livro);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        LivroDidatico entity = this.em.find(LivroDidatico.class, id);
        if (entity != null) {
            this.em.remove(entity);
        }
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<LivroDidatico> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<LivroDidatico> query = this.em.createQuery(" Select c from LivroDidatico c where lower(c.nome) like :nome order by c.nome", LivroDidatico.class);
        query.setParameter("nome", "%" + nome.toLowerCase() + "%");
        List<LivroDidatico> livros = query.getResultList();
        this.em.close();
        return livros;
    }

}

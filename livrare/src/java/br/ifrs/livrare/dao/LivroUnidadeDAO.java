package br.ifrs.livrare.dao;

import br.ifrs.livrare.model.LivroUnidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LivroUnidadeDAO {

    private EntityManager em;

    public void salvar(LivroUnidade livro) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(livro);
        this.em.getTransaction().commit();
        this.em.close();
    }
    
    public void atualizar(LivroUnidade livro) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(livro);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(long id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        LivroUnidade entity = this.em.find(LivroUnidade.class, id);
        if (entity != null) {
            this.em.remove(entity);
        }
        this.em.getTransaction().commit();
        this.em.close();
    }

    public LivroUnidade obterPorCodigo(String codigo) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<LivroUnidade> query = this.em.createQuery(" Select c from LivroUnidade c where lower(c.codigoDeBarras) like :codigo order by c.id", LivroUnidade.class);
        query.setParameter("codigo", "%" + codigo.toLowerCase() + "%");
        List<LivroUnidade> livros = query.getResultList();
        this.em.close();
        return livros.get(0);
    }

}

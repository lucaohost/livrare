package br.ifrs.livrare.dao;

import br.ifrs.livrare.model.Emprestimo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmprestimoDAO {
    
    private EntityManager em;
    
     public void salvar(Emprestimo emprestimo) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(emprestimo);
        this.em.getTransaction().commit();
        this.em.close();
    }
 
    public void atualizar(Emprestimo emprestimo) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(emprestimo);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Emprestimo entity = this.em.find(Emprestimo.class, id);
        if (entity != null) {
            this.em.remove(entity);
        } 
        this.em.getTransaction().commit();
        this.em.close();
    }

    public Emprestimo obter(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        Emprestimo emprestimo = this.em.find(Emprestimo.class, id);
        this.em.close();
        return emprestimo;
    }
    
    public List<Emprestimo> pesquisar() throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Emprestimo> query = this.em.createQuery("Select c from Emprestimo c order by c.nome", Emprestimo.class);
        List<Emprestimo> emprestimos = query.getResultList();
        this.em.close();
        return emprestimos;
    }
    
    public List<Emprestimo> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Emprestimo> query = this.em.createQuery(" Select c from Emprestimo c where lower(c.nome) like :nome order by c.nome",Emprestimo.class);
        query.setParameter("nome", "%"+nome.toLowerCase()+"%");        
        List<Emprestimo> emprestimos = query.getResultList();
        this.em.close();
        return emprestimos;
    }
    
}

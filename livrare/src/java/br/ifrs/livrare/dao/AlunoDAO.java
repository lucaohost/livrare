package br.ifrs.livrare.dao;

import br.ifrs.livrare.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AlunoDAO {
    
    private EntityManager em;
    
     public void salvar(Aluno aluno) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(aluno);
        this.em.getTransaction().commit();
        this.em.close();
    }
 
    public void atualizar(Aluno aluno) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(aluno);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Aluno entity = this.em.find(Aluno.class, id);
        if (entity != null) {
            this.em.remove(entity);
        } 
        this.em.getTransaction().commit();
        this.em.close();
    }

    public Aluno obter(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        Aluno aluno = this.em.find(Aluno.class, id);
        this.em.close();
        return aluno;
    }
    
    public List<Aluno> pesquisar() throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Aluno> query = this.em.createQuery("Select c from Aluno c order by c.nome", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        this.em.close();
        return alunos;
    }
    
    public List<Aluno> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Aluno> query = this.em.createQuery(" Select c from Aluno c where lower(c.nome) like :nome order by c.nome",Aluno.class);
        query.setParameter("nome", "%"+nome.toLowerCase()+"%");        
        List<Aluno> alunos = query.getResultList();
        this.em.close();
        return alunos;
    }
    
}

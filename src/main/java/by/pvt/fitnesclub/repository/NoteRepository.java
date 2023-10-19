package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.Note;
import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.repository.dao.DaoNote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

import java.util.List;
@Component
public class NoteRepository implements DaoNote {
    private final SessionFactory sessionFactory;

    public NoteRepository() {
        this.sessionFactory =  HibernateConfig.getSessionFactory();
    }

    @Override
    public void add(Note note) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(note);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Note findById(Long id) {
        Session session = sessionFactory.openSession();
        Note note = session.get(Note.class, id);
        return note;
    }

    @Override
    public void deleteNote(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Note> getAllNote() {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("Select s from Note s");
        return (List<Note>)query.getResultList();
    }
}

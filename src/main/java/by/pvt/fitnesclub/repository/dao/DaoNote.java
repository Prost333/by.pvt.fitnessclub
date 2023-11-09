package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Note;
import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DaoNote extends JpaRepository<Note,Long> {

    List<Note> findByVisitor_id(Long id);

}

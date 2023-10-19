package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Note;
import by.pvt.fitnesclub.entity.Visitor;

import java.util.List;

public interface DaoNote {
    void add(Note note);
    Note findById(Long id);
    void deleteNote(Long id);
    List<Note> getAllNote();
}

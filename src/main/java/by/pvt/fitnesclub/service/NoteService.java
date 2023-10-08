package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.Note;
import by.pvt.fitnesclub.repository.dao.DaoNote;

import java.util.List;

public class NoteService {
    private final DaoNote dao;

    public NoteService(DaoNote dao) {
        this.dao = dao;
    }
    public void add(Note note){
        dao.add(note);
    }
    public Note findById(Long id){
       return dao.findById(id);
    }
    public void deleteNote(Long id){
        dao.deleteNote(id);
    }
    public List<Note> getAllNote(){
        return dao.getAllNote();
    }
}

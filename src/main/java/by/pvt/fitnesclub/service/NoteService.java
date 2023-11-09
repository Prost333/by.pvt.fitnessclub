package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {
    Note add (Note note);
    void delete (Note note);
    Note findID (Long id);
    List<Note> getAll();
}

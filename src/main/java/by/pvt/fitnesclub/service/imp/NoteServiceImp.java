package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.entity.Note;
import by.pvt.fitnesclub.entity.Status;
import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.repository.dao.DaoNote;
import by.pvt.fitnesclub.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImp implements NoteService {
    @Autowired
    private DaoNote daoNote;
    @Autowired
    OfficeServiceImp officeServiceImp;
    @Autowired
    VisitorServiceImp visitorService;

    public Note add (Note note){
        List<Note> visitorNote=daoNote.findByVisitor_id(note.getVisitor().getId());
        if (visitorNote.stream().count()>=5 && !note.getVisitor().getStatuss().equals(Status.VIP)){
            Visitor visitor= visitorService.findID(note.getVisitor().getId());
            visitor.setStatuss(Status.VIP);
            visitorService.add(visitor);
        }

        return daoNote.save(note);
    }

    public void delete (Note note){
        daoNote.delete(note);
    }

    public Note findID (Long id){
        Optional<Note> sale= Optional.of(daoNote.findById(id).orElseThrow());
        return  sale.get();
    }

    public List<Note> getAll(){
        return daoNote.findAll();
    }



}

package com.example.notes_api.controller;

import com.example.notes_api.model.Note;
import com.example.notes_api.repo.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteRepository repo;

    public NoteController(NoteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Note> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Note> getOne(@PathVariable Long id) {
        return repo.findById(id);

    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return repo.save(note);
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id,@RequestBody Note note) {
        note.setId(id);
        return repo.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

}

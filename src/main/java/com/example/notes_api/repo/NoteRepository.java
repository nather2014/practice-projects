package com.example.notes_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notes_api.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}

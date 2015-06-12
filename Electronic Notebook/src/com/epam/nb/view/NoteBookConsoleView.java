package com.epam.nb.view;

import java.util.List;

import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class NoteBookConsoleView {
	
	private void print(Note note){
		System.out.println(note);
	}
	
	private void print(List<Note> notes){
		System.out.println(notes);
	}
	
	private void print(NoteBook notebook){
		System.out.println(notebook);
	}
	
	private void print (Note...notes){
		System.out.println(notes);
	}
}

package com.epam.nb.dao.memory;

import com.epam.nb.entity.NoteBook;

public class NoteBookProvider {
	private static NoteBookProvider notebookprovider = null;
	private NoteBook notebook = new NoteBook();
	
	private NoteBookProvider getInstance(){
		if(notebookprovider==null){
			notebookprovider = new NoteBookProvider();
		}
		return notebookprovider;
	}
	
	private NoteBook getNoteBook(){
		return notebook;
	}

}

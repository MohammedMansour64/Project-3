package com.barmej.notesapp;

import android.net.Uri;
import android.widget.EditText;

import androidx.cardview.widget.CardView;

public class Notes {
    private String noteTextShow;
    private Uri image;


    public Notes(String noteTextShow , Uri image  ) {
        this.noteTextShow = noteTextShow;
        this.image = image;
    }

    public String getNoteTextShow() {
        return noteTextShow;
    }

    public void setNoteTextShow(String noteTextShow) {
        this.noteTextShow = noteTextShow;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

}

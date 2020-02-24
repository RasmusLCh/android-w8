package com.example.updadtednotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;


public class NoteView extends AppCompatActivity {
    private String headline;
    private String body;
    private EditText noteHeadline;
    private EditText noteBody;
    private Note note;
    private Note editNote;
    private ArrayList<String> notes = Data.getInstance().notes;
    private ArrayList<Note> noteObjects = Data.getInstance().noteObjects;
    private Boolean edit_state = false;

    private EditText editText_Headline;
    private EditText editText_Body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteHeadline = findViewById(R.id.editText);
        noteBody = findViewById(R.id.editText2);
        editText_Headline = findViewById(R.id.editText);
        editText_Body = findViewById(R.id.editText2);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        if(bundle != null){
            try{
                edit_state = true;
                System.out.println("TEST 1111"+i.getExtras());
                editNote = (Note)bundle.getSerializable("noteKey");
                System.out.println("TEST 2222"+editNote);
                editText_Headline.setText(editNote.getHeadline());
                System.out.println("TEST 3333"+editText_Headline);
                editText_Body.setText(editNote.getNote());
                System.out.println("TEST 4444"+editNote);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void saveClick(View view) {
        headline = noteHeadline.getText().toString();
        body = noteBody.getText().toString();
        note = new Note(headline,body);
        if(edit_state == true){
            noteObjects.set(editNote.getPosition(),note);
            notes.set(editNote.getPosition(),note.getHeadline());
            edit_state = false;
        }else{
            noteObjects.add(note);
            notes.add(note.getHeadline());
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

package com.example.mynotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNotes = findViewById(R.id.rvNotes);

        rvNotes.setHasFixedSize(true);

        // use a linear layout manager
        rvNotes.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter with the list to show
        NotesAdapter mAdapter = new NotesAdapter(getData());
        rvNotes.setAdapter(mAdapter);

    }

    private List<NotesModel> getData(){
        NotesModel note1 = new NotesModel();
        note1.setTitulo("Dentista");
        note1.setSubtitulo("Hoy a las 17h");


        NotesModel note2 = new NotesModel();
        note2.setTitulo("Cena");
        note2.setSubtitulo("Miercoles a las 20h");

        NotesModel note3 = new NotesModel();
        note3.setTitulo("Cine");
        note3.setSubtitulo("Viernes a las 22h");

        NotesModel note4 = new NotesModel();
        note4.setTitulo("Avion");
        note4.setSubtitulo("4 Julio 12:45");

        List<NotesModel> listaNotes = new ArrayList<>();
        listaNotes.add(note1);
        listaNotes.add(note2);
        listaNotes.add(note3);
        listaNotes.add(note4);

        return listaNotes;
    }
}

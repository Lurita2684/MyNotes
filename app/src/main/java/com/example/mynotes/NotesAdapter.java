package com.example.mynotes;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyNoteRow> {

    private List<NotesModel> userModelList;

    public NotesAdapter(List<NotesModel> notesModelList) {  // Constructor
        this.userModelList = notesModelList;
    }

    @Override
    public MyNoteRow onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes, parent, false);
        MyNoteRow viewHolder = new MyNoteRow(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyNoteRow holder, int position) {  // Pinta celda
        String receivedTitle = userModelList.get(position).getTitulo();  // Obtengo el String que quiero pintar en la celda
        holder.tvTituloNote.setText(receivedTitle);

        String receivedSub = userModelList.get(position).getSubtitulo();
        holder.tvSubtituloNote.setText(receivedSub);

    }


    @Override
    public int getItemCount() {  // Tamaño de la Lista (RecyclerView)
        return userModelList.size();
    }

    static class MyNoteRow extends RecyclerView.ViewHolder {  // Crea mi vista celda, la cual tiene un TextView
        private TextView tvTituloNote;
        private TextView tvSubtituloNote;


        MyNoteRow(View v) {
            super(v);
            tvTituloNote = v.findViewById(R.id.tvTitle);
            tvSubtituloNote = v.findViewById(R.id.tvSubTitle);


        }
    }
}

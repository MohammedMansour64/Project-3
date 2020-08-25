package com.barmej.notesapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.barmej.notesapp.Listener.ItemClickListener;
import com.barmej.notesapp.Listener.ItemLongClickListener;
import com.barmej.notesapp.Notes;
import com.barmej.notesapp.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    List<Notes> notesArray;
     ItemLongClickListener mItemLongClickListener;
     ItemClickListener mItemClickListener;

    public NotesAdapter(List<Notes> notesList , ItemLongClickListener mItemLongClickListener , ItemClickListener mItemClickListener) {
        notesArray = notesList;
        this.mItemLongClickListener = mItemLongClickListener;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_note_photo , parent , false);
        NotesViewHolder notesViewHolder = new NotesViewHolder( view , mItemLongClickListener , mItemClickListener);

        return notesViewHolder ;
    }



    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Notes notesItem = notesArray.get(position);
        holder.test.setText(notesItem.getNoteTextShow());
        holder.newNotePhoto.setImageURI(notesItem.getImage());

        holder.position = position;

    }

    @Override
    public int getItemCount() {
        return notesArray.size();
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView test;
        ImageView newNotePhoto;
        int position;

        public NotesViewHolder(@NonNull View itemView, final ItemLongClickListener mItemLongClickListener , final ItemClickListener mItemClickListener) {
            super(itemView);

            test = itemView.findViewById(R.id.textView3);
            newNotePhoto = itemView.findViewById(R.id.imageView);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mItemLongClickListener.onLongClickItem(position);
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onClickListener(position);
                }
            });
        }
    }

    static class NotesViewHolderCheck extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView checkBoxText;
        int position;
        public NotesViewHolderCheck(@NonNull View itemView , final ItemLongClickListener mItemLongClickListener , final ItemClickListener mItemClickListener) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkBox);
            checkBoxText = itemView.findViewById(R.id.textView2);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mItemLongClickListener.onLongClickItem(position);
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onClickListener(position);
                }
            });

        }
    }
}

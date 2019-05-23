package com.example.mvvmtodo;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//before  extends RecyclerView.Adapter<NoteAdapter.NoteHolder
public class NoteAdapter extends ListAdapter<Note,NoteAdapter.NoteHolder> {
   // private List<Note> notes = new ArrayList<>();
    private OnItemClickLIstener lIstener;

    public NoteAdapter() {
        super(DIFF_CALLBACK);
    }
private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
    @Override
    public boolean areItemsTheSame(@NonNull Note note, @NonNull Note t1) {
        return note.getId() == t1.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Note note, @NonNull Note t1) {
        return note.getTitle().equals(t1.getTitle())&&
                note.getDescription().equals(t1.getDescription())&&
                note.getPriority()==t1.getPriority();


    }
};

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemmView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.note_item, viewGroup, false);
        return new NoteHolder(itemmView);


    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
//this method is implemented to take every single note into the views of note holder.
// Note currentNote = notes.get(i); previous
        Note currentNote = getItem(i);
//here i is the position of notes arrayList

        noteHolder.textViewTitle.setText(currentNote.getTitle());
        noteHolder.textViewDescrption.setText(currentNote.getDescription());
        noteHolder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));

    }

 /*   @Override
    public int getItemCount() {
        //defines how many items to be desplayed in our recycler view
        //as we display every single item in our arraylist

        return notes.size();
    }*/

/*
    public void setNotes(List<Note> notes) {
        //this method is used to set the data in the arrayList
        this.notes = notes;
//to tell our recycler view to redraw the layout
        notifyDataSetChanged();
        //   Log.d("Size of an arrayList","="+notes.size());
    }
*/

    public Note getNoteAt(int position) {
        return getItem(position);
    }


    //create a view holder t ohold a view in adapter
    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescrption;
        private TextView textViewPriority;


        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescrption = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);


            //set listener for each item here
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (lIstener != null && position != RecyclerView.NO_POSITION) {
                        lIstener.onItemClick(getItem(position));
                    }
                }
            });

        }
    }


    public interface OnItemClickLIstener {
        void onItemClick(Note note);

    }

    public void setOnItemClickListener(OnItemClickLIstener listener) {
        this.lIstener = listener;

    }

}

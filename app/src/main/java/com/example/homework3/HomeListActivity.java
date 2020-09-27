package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework3.model.WordItem;

public class HomeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview_word_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);

    }
    //---------------------------------

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private WordItem [] wordItem ;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public  class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView text;
            public ImageView image;
            public MyViewHolder(View v) {
                super(v);
                text = v.findViewById(R.id.textView_word);
                image = v.findViewById(R.id.imageView_pic);
            }

        }


        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter() {
            wordItem = new WordItem[10];
            wordItem[0] = new  WordItem(R.drawable.boom,"Boom");
            wordItem[1] = new  WordItem(R.drawable.bathroom,"Bathroom");
            wordItem[2] = new  WordItem(R.drawable.door,"Door");
            wordItem[3] = new  WordItem(R.drawable.home,"Home");
            wordItem[4] = new  WordItem(R.drawable.kitchen,"Kitchen");
            wordItem[5] = new  WordItem(R.drawable.living_room,"Livingroom");
            wordItem[6] = new  WordItem(R.drawable.map,"Mop");
            wordItem[7] = new  WordItem(R.drawable.sofar,"Sofa");
            wordItem[8] = new  WordItem(R.drawable.window2,"Window");
            wordItem[9] = new  WordItem(R.drawable.box,"Box");


        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_word, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.image.setImageResource(wordItem[position].imageResId);
            holder.text.setText(wordItem[position].word);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return wordItem.length;
        }
    }




}
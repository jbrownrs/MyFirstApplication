package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapplication.ViewModel.MainViewModel;
import com.example.myfirstapplication.database.ItemEntity;
import com.example.myfirstapplication.ui.ItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<ItemEntity> itemList = new ArrayList<ItemEntity>();
    public static final String EXTRA_MESSAGE = "com.example.myfirstapplication.MESSAGE";
    // specify an adapter (see also next example)
    private ItemRecyclerViewAdapter mAdapter;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initRecyclerView();
        initViewModel();
//        itemList.addAll(mViewModel.mItems);
//        for (ItemEntity itemEntity : itemList) {
//            Log.i("ToDoList", itemEntity.toString());
//        }
    }

    private void initViewModel() {

        final Observer<List<ItemEntity>> itemObserver = new Observer<List<ItemEntity>>() {
            @Override
            public void onChanged(List<ItemEntity> itemEntities) {
                itemList.clear();
                itemList.addAll(itemEntities);

                if (mAdapter == null) {
                    mAdapter = new ItemRecyclerViewAdapter(itemList, MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    mAdapter.notifyDataSetChanged();
                }
            }
        };

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.mItems.observe(this, itemObserver);
    }

    private void initRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        //        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        addData();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void addData() {
        mViewModel.addData();
    }
}

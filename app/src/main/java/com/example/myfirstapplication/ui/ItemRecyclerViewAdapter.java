package com.example.myfirstapplication.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapplication.ItemFragment.OnListFragmentInteractionListener;
import com.example.myfirstapplication.R;
import com.example.myfirstapplication.database.ItemEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ItemEntity} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private final List<ItemEntity> mItems;
    private final Context mContext;

    //    private final OnListFragmentInteractionListener mListener;

    //previously also contained parameter , OnListFragmentInteractionListener mListener,
    public ItemRecyclerViewAdapter(List<ItemEntity> mItems, Context mContext) {
        this.mItems = mItems;
//        this.mListener = mListener;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemEntity itemEntity = mItems.get(position);
        holder.mTextView.setText(itemEntity.getText());
//        holder.mItem = mItems.get(position);
//        holder.mIdView.setText(mItems.get(position).id);
//        holder.mContentView.setText(mItems.get(position).content);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an itemEntity has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.add_item_text) //add_item_text editText
        TextView mTextView;
//        TextView mIdView;
//        TextView mContentView;
//        ItemEntity mItem;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.item_number);
//            mContentView = (TextView) view.findViewById(R.id.content);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}

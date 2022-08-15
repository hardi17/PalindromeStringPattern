package com.example.stringpatternmatching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stringpatternmatching.databinding.RawStrLayoutBinding;

import java.util.ArrayList;

/*
* Used this adapter class for bind list of string in a recyclerview
* */

public class ValidStringPatternAdapter extends RecyclerView.Adapter<ValidStringPatternAdapter.ViewHolder>{

    Context context;
    ArrayList<String> list;


    public ValidStringPatternAdapter(Context context,ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ValidStringPatternAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_str_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ValidStringPatternAdapter.ViewHolder holder, int position) {
        if(!list.isEmpty()){
            holder.binding.tvPatternStr.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RawStrLayoutBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}

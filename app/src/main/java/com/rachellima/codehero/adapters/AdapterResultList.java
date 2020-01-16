package com.rachellima.codehero.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rachellima.codehero.R;
import com.rachellima.codehero.model.Result;
import com.rachellima.codehero.model.Thumbnail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterResultList extends RecyclerView.Adapter<AdapterResultList.ViewHolderRepository> {

    private List<Result> mResult;
    private List<Integer> mIndices;
    private Context mContext;

    public static class ViewHolderRepository extends RecyclerView.ViewHolder {

        @BindView(R.id.name_character)
        TextView mNameCharacter;

        @BindView(R.id.photo_character)
        ImageView mPhotoCharacter;

        Result result;


        public ViewHolderRepository(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void getResults(Result result) {
            this.result = result;
        }
    }

    public AdapterResultList(Context context, List<Result> mResult, List<Integer> mIndices) {
        this.mIndices = mIndices;
        this.mResult = mResult;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolderRepository onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character_list, parent, false);
        return new ViewHolderRepository(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRepository holder, int position) {
        final Result result = mResult.get(position);
        final Thumbnail thumbnail = result.getThumbnail();
        final String aspectRatio = "/portrait_medium.";

        holder.mNameCharacter.setText(result.getNameHero());
        Glide.with(mContext)
                .load(thumbnail.getPathImage() + aspectRatio + thumbnail.getExtensionImage())
                .into(holder.mPhotoCharacter);

        holder.getResults(result);
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

/*

    package com.tutorials.hp.recyclerpagination.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tutorials.hp.recyclerpagination.R;

import java.util.ArrayList;

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {
        Context c;
        ArrayList<String> spacecrafts;
        public MyAdapter(Context c, ArrayList<String> spacecrafts) {
            this.c = c;
            this.spacecrafts = spacecrafts;
        }

        //INITIALIZE VH
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
            return new MyViewHolder(v);
        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //BIND DATA
            holder.nametxt.setText(spacecrafts.get(position));
        }
        //TOTAL NUM
        @Override
        public int getItemCount() {
            return spacecrafts.size();
        }
    }
*/


}

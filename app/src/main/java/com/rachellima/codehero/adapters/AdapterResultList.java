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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterResultList extends RecyclerView.Adapter<AdapterResultList.ViewHolderRepository> {

    List<Result> mResult;
    Context mContext;

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

    public AdapterResultList(List<Result> mResult, Context context) {
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

        holder.mNameCharacter.setText(result.getNameHero());
        Glide.with(mContext)
                .load(result.getThumbnail().getPathImage() + "/portrait_medium." + result.getThumbnail().getExtensionImage())
                .into(holder.mPhotoCharacter);

        holder.getResults(result);
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

}

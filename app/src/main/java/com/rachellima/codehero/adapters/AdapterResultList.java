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
import butterknife.OnClick;

public class AdapterResultList extends RecyclerView.Adapter<AdapterResultList.ViewHolderHeroes> {

    private List<Result> mResult;
    private Context mContext;
    private final View.OnClickListener mOnClickListener = null;
    int selectedPos = 0;

    public class ViewHolderHeroes extends RecyclerView.ViewHolder {

        @BindView(R.id.name_character)
        TextView mNameCharacter;

        @BindView(R.id.photo_character)
        ImageView mPhotoCharacter;

        Result result;

        @OnClick(R.id.item)
        void onClick(View view) {

        }

        public ViewHolderHeroes(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        private void getResults(Result result) {
            this.result = result;
        }


    }

    public AdapterResultList(Context context, List<Result> mResult) {
        this.mResult = mResult;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolderHeroes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character_list, parent, false);

        return new ViewHolderHeroes(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHeroes holder, int position) {
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

}

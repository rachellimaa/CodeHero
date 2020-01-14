package com.rachellima.codehero.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachellima.codehero.R;
import com.rachellima.codehero.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterHeroList extends RecyclerView.Adapter<AdapterHeroList.ViewHolderRepository> {

    List<Hero> mHeroes;
    private Context mContext;

    public static class ViewHolderRepository extends RecyclerView.ViewHolder {

        @BindView(R.id.name_character)
        TextView mNameCharacter;

        @BindView(R.id.photo_character)
        ImageView mPhotoCharacter;

        Hero hero;


        public ViewHolderRepository(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void getRepository(Hero hero) {
            this.hero = hero;
        }
    }

    public AdapterHeroList(List<Hero> mHeroes, Context context) {
        this.mHeroes = mHeroes;
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
        final Hero hero = mHeroes.get(position);

        holder.mNameCharacter.setText(hero.getHeroName());
       /* Picasso.get().load(hero.getHeroImage()).into(holder.mPhotoCharacter);*/

    }

    @Override
    public int getItemCount() {
        return mHeroes.size();
    }

}

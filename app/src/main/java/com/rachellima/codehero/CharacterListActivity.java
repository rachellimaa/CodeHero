package com.rachellima.codehero;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rachellima.codehero.adapters.AdapterHeroList;
import com.rachellima.codehero.apicodehero.APIClientCodeHero;
import com.rachellima.codehero.apicodehero.service.IHero;
import com.rachellima.codehero.apicodehero.service.ServiceGenerator;
import com.rachellima.codehero.events.HeroListEvent;
import com.rachellima.codehero.model.Hero;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterListActivity extends AppCompatActivity {
    private TextView mTitle;
    private APIClientCodeHero mApiClientCodeHero;
    private List<Hero> mHerosList;
    private AdapterHeroList mAdapterRepositoryList;

    @BindView(R.id.recyclerView_character)
    RecyclerView mRecyclerViewHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setStyleTitle();
        configRetrofit();
        initView();
    }

    private void setStyleTitle() {
        mTitle = findViewById(R.id.text_title);
        Typeface typefaceRobotoBold = Typeface.create(ResourcesCompat.getFont(this, R.font.robotoblack),
                Typeface.NORMAL);
        Typeface typefaceRobotoLight = Typeface.create(ResourcesCompat.getFont(this, R.font.robotolight),
                Typeface.NORMAL);
        SpannableString string = new SpannableString(mTitle.getText().toString());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            string.setSpan(new TypefaceSpan(typefaceRobotoBold), 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            string.setSpan(new TypefaceSpan(typefaceRobotoLight), 13, 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            mTitle.setText(string);
        }
    }

    private void initView() {
        mHerosList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewHero.setLayoutManager(linearLayoutManager);
        mAdapterRepositoryList = new AdapterHeroList(mHerosList, getApplicationContext());
        mRecyclerViewHero.setAdapter(mAdapterRepositoryList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHeroListEvent(HeroListEvent event) {
        if (event != null) {
            mHerosList.addAll(event.getHeroes());
            mAdapterRepositoryList.notifyDataSetChanged();
        }
    }

    private void configRetrofit() {
        IHero mService = ServiceGenerator.createService(IHero.class);
        mApiClientCodeHero = new APIClientCodeHero(mService);
        mApiClientCodeHero.getHeroList("iron man", 4, 0, generateTimestamp(),generateMd5());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private String generateTimestamp(){
        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        return ts;
    }

    private String generateMd5() {
        String s = generateTimestamp() + BuildConfig.API_PRIVATE_KEY + BuildConfig.API_PUBLIC_KEY;
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

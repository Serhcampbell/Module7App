package com.example.module7app;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private int id1,id2,id3;

    public MainFragment() {
        // Required empty public constructor
    }

    private int getDrawableId(ImageView iv){
        return (Integer) iv.getTag();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            id1 = 0;
            id2 = 0;
            id3 = 0;
        }
        else{
            id1 = savedInstanceState.getInt("imageARes", 0);
            id2 = savedInstanceState.getInt("imageBRes", 0);
            id3 = savedInstanceState.getInt("imageCRes", 0);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("imageARes", id1);
        outState.putInt("imageBRes", id2);
        outState.putInt("ImageCRes", id3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        Button btnA = view.findViewById(R.id.btnFragA);
        ImageView imgA = view.findViewById(R.id.imageA);
        final int imageA_id= imgA.getId();
        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainFragmentDirections.ActionMainFragmentToFragmentAlpha action = MainFragmentDirections.actionMainFragmentToFragmentAlpha(imageA_id);
                ImageView image1 = getView().findViewById(R.id.imageA);
                image1.setTag(R.drawable.letter_a);
                id1 = getDrawableId(image1);
                action.setImgRes(id1);
                navController.navigate(action);
            }
        });
        Button btnB = view.findViewById(R.id.btnFragB);
        ImageView imgB = view.findViewById(R.id.imageB);
        final int imageB_id= imgB.getId();
        btnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainFragmentDirections.ActionMainFragmentToFragmentBeta action = MainFragmentDirections.actionMainFragmentToFragmentBeta(imageB_id);
                ImageView image2 = getView().findViewById(R.id.imageB);
                image2.setTag(R.drawable.letter_b);
                id2 = getDrawableId(image2);
                action.setImgRes(id2);
                navController.navigate(action);
            }
        });
        Button btnC = view.findViewById(R.id.btnFragC);
        ImageView imgC = view.findViewById(R.id.imageC);
        final int imageC_id= imgC.getId();
        btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainFragmentDirections.ActionMainFragmentToFragmentCharlie action = MainFragmentDirections.actionMainFragmentToFragmentCharlie(imageC_id);
                ImageView image3 = getView().findViewById(R.id.imageC);
                image3.setTag(R.drawable.letter_c);
                id3 = getDrawableId(image3);
                action.setImgRes(id3);
                navController.navigate(action);
            }
        });
    }
}

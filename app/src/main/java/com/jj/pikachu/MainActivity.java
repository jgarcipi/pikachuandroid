package com.jj.pikachu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jj.pikachu.Views.saveGame.SaveGame;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUptView();
    }

    private void setUptView() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.create_game)
    public void goToNewGame(){
        Intent intent = SaveGame.getCallIntent(this);
        this.startActivity(intent);

    }
}

package com.example.roberto.actiandroid;

import android.content.Intent;
import android.view.View;
import com.example.roberto.actiandroid.firebase.FireBaseAdminListener;
import com.google.firebase.database.DataSnapshot;

/**
 * Created by roberto on 23/1/18.
 */

public class MainActivityEvents implements FireBaseAdminListener, View.OnClickListener {
    MainActivity mainActivity;
    SecondActivity secondActivity;

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;



    }

    @Override
    public void logInOk(boolean ok) {
        Intent myIntent = new Intent(mainActivity, SecondActivity.class);
        mainActivity.startActivity(myIntent);
        mainActivity.finish();
    }


    @Override
    public void signOutOk(boolean ok) {

    }

    @Override
    public void fireBaseDownloadBranch(String branch, DataSnapshot dataSnapshot) {

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGo) {
            this.mainActivity.fireBaseAdmin.singInWithEmailAndPassword(this.mainActivity.txtUser.getText().toString(),this.mainActivity.txtPass.getText().toString());
        }
    }
}

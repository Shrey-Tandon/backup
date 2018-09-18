package com.example.user.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements android.support.v7.widget.PopupMenu.OnMenuItemClickListener {
    Button popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popup = findViewById(R.id.popup);

    }

    public void showPopup(View v) {

        android.support.v7.widget.PopupMenu popupMenu = new android.support.v7.widget.PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu);
        popupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            default:

                return false;
        }
    }
}


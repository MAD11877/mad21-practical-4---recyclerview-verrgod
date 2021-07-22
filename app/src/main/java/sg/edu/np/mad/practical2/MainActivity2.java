package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<User> data = new ArrayList<User>();
        Random r1 = new Random();
        for (int i = 0; i < 20; i++){
            int x = r1.nextInt(2000000000 - 1000000000) + 1000000000;
            String name = String.valueOf(x);
            int y = r1.nextInt(2000000000 - 1000000000) + 1000000000;
            String description = String.valueOf(y);
            User u = new User();
            u.setDescription("Description " + description);
            u.setName("Name" + name);
            u.setAge(x);
            data.add(u);
        }
        RecyclerView rv = findViewById(R.id.rv);
        UsersAdapter adapter = new UsersAdapter(this, data);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
    protected void onStart(){
        super.onStart();
        Log.d("debug","start");
    }
    protected void onResume(){
        super.onResume();
        Log.d("debug","resume");
    }
    protected void onRestart(){
        super.onRestart();
        Log.d("debug","restart");
    }
}
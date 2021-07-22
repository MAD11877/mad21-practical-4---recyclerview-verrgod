package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("debug","create");

        Intent profile = getIntent();
        TextView nameText = findViewById(R.id.textView2);
        TextView descriptionText = findViewById(R.id.textView);
        nameText.setText(profile.getStringExtra("Name"));
        descriptionText.setText(profile.getStringExtra("Description"));

        User user = new User();

        Button followBtn = findViewById(R.id.follow);
        followBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                String followString = followBtn.getText().toString();
                if (!user.isFollowed()){
                    followBtn.setText("Unfollow");
                    user.setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else {
                    followBtn.setText(("Follow"));
                    user.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
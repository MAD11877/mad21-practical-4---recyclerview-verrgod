package sg.edu.np.mad.practical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    Context context;
    ArrayList<User> data;

    public UsersAdapter(Context c, ArrayList<User> d) {
        context = c;
        data = d;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if (viewType == 0) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_logo, parent, false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent, false);
        }
        return new UserViewHolder(item);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        User u = data.get(position);

        if (holder.getItemViewType() == 0) {
            holder.name7.setText(u.getName());
            holder.description7.setText(u.getDescription());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Profile")
                            .setMessage(u.getName())
                            .setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent profile = new Intent(context, MainActivity.class);
                                    profile.putExtra("Name", u.getName());
                                    profile.putExtra("Description", u.getDescription());
                                    context.startActivity(profile);
                                }
                            })
                            .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public int getItemViewType(int position) {
        User u = data.get(position);
        if (u.getName().endsWith("7")) {
            return 0;
        }
        else {
            return 1;
        }
    }
}

package sg.edu.np.mad.practical2;

import android.media.Image;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{

    //declare as global variable for codes later
    public TextView name;
    public TextView description;
    public View view;
    public View pfp;

    public UserViewHolder(View itemView) {
        super(itemView);
        pfp = itemView.findViewById(R.id.roundLogo);
        name = itemView.findViewById(R.id.txtName);
        description = itemView.findViewById(R.id.txtDescription);
        view = itemView;
    }
}

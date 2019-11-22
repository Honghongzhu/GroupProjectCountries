//package com.example.groupprojectcountries.profile;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.groupprojectcountries.R;
//
//import java.util.ArrayList;
//
//public class BadgesAdapter extends RecyclerView.Adapter <BadgesAdapter.BadgeViewHolder>{
//    private ArrayList<Badges> badgesToAdapter;
//
//    public void setData(ArrayList<Badges> badgesToAdapter) {
//        this.badgesToAdapter = badgesToAdapter;
//    }
//
//    @NonNull
//    @Override
//    public BadgesAdapter.BadgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.badges,parent,false);
//
//        BadgeViewHolder badgeViewHolder = new BadgeViewHolder(view);
//        return badgeViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull BadgesAdapter.BadgeViewHolder holder, int position) {
//        final Badges badgesAtPosition = badgesToAdapter.get(position);
//
//        holder.badgeImage.setImageResource(badgesAtPosition.getBadge_image());
//        holder.badgeNmae.setText(badgesAtPosition.getBadge_name());
//
//        holder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Context context = view.getContext();
//                CharSequence text = "You Should finish the "+badgesAtPosition.getBadge_name()+" to Unlock this Badges";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return badgesToAdapter.size();
//    }
//
//    public class BadgeViewHolder extends RecyclerView.ViewHolder {
//        public View view;
//        public ImageView badgeImage;
//        public TextView badgeNmae;
//
//        public BadgeViewHolder(@NonNull View itemView) {
//            super(itemView);
//            view=itemView;
//            badgeImage= view.findViewById(R.id.badgeImage);
//            badgeNmae=view.findViewById(R.id.badge_name);
//        }
//    }
//}

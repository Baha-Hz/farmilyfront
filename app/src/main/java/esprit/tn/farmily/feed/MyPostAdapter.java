package esprit.tn.farmily.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Downvote;
import esprit.tn.farmily.models.Notification;
import esprit.tn.farmily.models.Post;
import esprit.tn.farmily.models.Upvote;
import esprit.tn.farmily.notification.notification;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Color.*;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder>  {


    public static List<Post> postdata;
    public Context context;
    Notification notification = new Notification();

    public MyPostAdapter(Context context , List<Post> data) {
        this.context = context;
        this.postdata = data;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.postscards, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        holder.textViewname.setText(postdata.get(position).getUser());
        holder.textViewrole.setText(postdata.get(position).getTopic());
        String id = postdata.get(position).getId();
        String postowner= postdata.get(position).getUser();
        Glide.with(context).load(APIclient.base_url+ postdata.get(position).getProfileimage()).into(holder.profilepic);
        holder.textViewpost.setText(postdata.get(position).getQuestion());

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), com_display.class);
                intent.putExtra("Postid",id);
                intent.putExtra("User",postowner);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        Call<String> getnumberofposts = APIclient.apIinterface().getnumberofposts(id);
        getnumberofposts.enqueue(new Callback <String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                holder.numberofcomments.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

            //Log.d("dfdfdfdf",posts.toString());
        });
        Call<String> getnumberofupvotes = APIclient.apIinterface().getnumberofupvotes(id);
        getnumberofupvotes.enqueue(new Callback <String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                holder.upvotecount.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

            //Log.d("dfdfdfdf",posts.toString());
        });
        Call<String> getnumberofdownvotes = APIclient.apIinterface().getnumberofupvotes(id);
        getnumberofdownvotes.enqueue(new Callback <String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                holder.downvotecount.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

            //Log.d("dfdfdfdf",posts.toString());
        });
        holder.upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Upvote> addupvote = APIclient.apIinterface().addupvote(id,CurrentSession.CurrentUser.getUsername());
                addupvote.enqueue(new Callback <Upvote>() {
                    @Override
                    public void onResponse(Call<Upvote> call, Response<Upvote> response) {
                        Call<String> getnumberofupvotes = APIclient.apIinterface().getnumberofupvotes(id);
                        getnumberofupvotes.enqueue(new Callback <String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                holder.upvotecount.setText(response.body());
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }

                            //Log.d("dfdfdfdf",posts.toString());
                        });
                    }

                    @Override
                    public void onFailure(Call<Upvote> call, Throwable t) {

                    }



                    //Log.d("dfdfdfdf",posts.toString());
                });

                notification.setProfileimage(CurrentSession.CurrentUser.getProfileimage());
                notification.setSender(CurrentSession.CurrentUser.getUsername());
                notification.setReceiver(postdata.get(position).getUser());
                notification.setAction(CurrentSession.CurrentUser.getUsername()+"Upvoted your Post");
                Call<Notification> addnotification = APIclient.apIinterface().addnotification(notification);
                addnotification.enqueue(new Callback <Notification>() {
                    @Override
                    public void onResponse(Call<Notification> call, Response<Notification> response) {

                    }

                    @Override
                    public void onFailure(Call<Notification> call, Throwable t) {

                    }


                    //Log.d("dfdfdfdf",posts.toString());
                });


            }
        });


        holder.downvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Downvote> adddownvote = APIclient.apIinterface().adddownvote(id,CurrentSession.CurrentUser.getUsername());
                adddownvote.enqueue(new Callback <Downvote>() {
                    @Override
                    public void onResponse(Call<Downvote> call, Response<Downvote> response) {
                        Call<String> getnumberofdownvotes = APIclient.apIinterface().getnumberofdownvotes(id);
                        getnumberofdownvotes.enqueue(new Callback <String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                holder.downvotecount.setText(response.body());
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }

                            //Log.d("dfdfdfdf",posts.toString());
                        });
                    }

                    @Override
                    public void onFailure(Call<Downvote> call, Throwable t) {

                    }


                    //Log.d("dfdfdfdf",posts.toString());
                });

                notification.setProfileimage(CurrentSession.CurrentUser.getProfileimage());
                notification.setSender(CurrentSession.CurrentUser.getUsername());
                notification.setReceiver(postdata.get(position).getUser());
                notification.setAction(CurrentSession.CurrentUser.getUsername()+"Downvoted your Post");

                Call<Notification> addnotification = APIclient.apIinterface().addnotification(notification);
                addnotification.enqueue(new Callback <Notification>() {
                    @Override
                    public void onResponse(Call<Notification> call, Response<Notification> response) {


                    }

                    @Override
                    public void onFailure(Call<Notification> call, Throwable t) {

                    }


                    //Log.d("things",posts.toString());
                });
            }
        });




    }

    @Override
    public int getItemCount() {
        return postdata.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profilepic;
        TextView  textViewname;
        TextView  textViewrole;
        TextView  textViewpost;
        Button  comment ;
        Button upvote;
        Button downvote;
        TextView numberofcomments;
        TextView upvotecount;
        TextView downvotecount;
        // ImageView comments;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            profilepic = itemView.findViewById(R.id.profilepic);
            textViewname = itemView.findViewById(R.id.userpost);
            textViewrole= itemView.findViewById(R.id.topic);
            textViewpost= itemView.findViewById(R.id.Question);
            comment= itemView.findViewById((R.id.commentsButton));
            numberofcomments = itemView.findViewById(R.id.numberofcomments);
            upvotecount = itemView.findViewById(R.id.upvotecount);
            downvotecount = itemView.findViewById(R.id.downvotecount);
            upvote = itemView.findViewById(R.id.upvote);
            downvote = itemView.findViewById(R.id.downvote);







        }


    }

}

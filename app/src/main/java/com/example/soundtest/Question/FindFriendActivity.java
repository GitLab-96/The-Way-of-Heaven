package com.example.soundtest.Question;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.soundtest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class FindFriendActivity extends AppCompatActivity {

    private Toolbar mtoolbar;
    private RecyclerView FindFriendsRecyclerList;
    private DatabaseReference UserRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);

        UserRef = FirebaseDatabase.getInstance().getReference().child("Users");
        FindFriendsRecyclerList = findViewById(R.id.find_friend_recycler_list);
        FindFriendsRecyclerList.setLayoutManager(new LinearLayoutManager(this));

        mtoolbar = findViewById(R.id.find_friends_toolBar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Find Friends");
    }


}

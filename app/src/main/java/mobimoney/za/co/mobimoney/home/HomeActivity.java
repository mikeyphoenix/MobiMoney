package mobimoney.za.co.mobimoney.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mobimoney.za.co.mobimoney.R;
import mobimoney.za.co.mobimoney.navigationdraw.DrawerActivity;

public class HomeActivity extends DrawerActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_home, contentMain);

        setTitle("Home Activity");
        /*setContentView(R.layout.activity_home);*/
    }
}

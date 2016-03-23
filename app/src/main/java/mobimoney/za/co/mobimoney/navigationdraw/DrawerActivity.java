package mobimoney.za.co.mobimoney.navigationdraw;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import mobimoney.za.co.mobimoney.R;
import mobimoney.za.co.mobimoney.home.view.HomeFragment;
import mobimoney.za.co.mobimoney.transaction.sms.NewSmsTransactionFragment;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    protected FrameLayout contentMain;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        contentMain = (FrameLayout) findViewById(R.id.content_main);
        fragmentManager = getFragmentManager();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //setNewSmsFragment();
        setHomeFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_item_home) {
            displayFragment(HomeFragment.class, getString(R.string.home_fragment), getString(R.string.title_home));
        } else if (id == R.id.nav_item_expenses) {

        } else if (id == R.id.nav_item_income) {

        } else if (id == R.id.nav_item_transactions) {
            displayFragment(NewSmsTransactionFragment.class, getString(R.string.new_sms_transaction_fragment) , getString(R.string.title_new_sms));
        } else if (id == R.id.nav_item_budget) {

        } else if (id == R.id.nav_item_logout) {

        } else if (id == R.id.nav_item_settings) {

        } else if (id == R.id.nav_item_help) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setHomeFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment =
                (HomeFragment) fragmentManager.findFragmentByTag(getString(R.string.home_fragment));
        contentMain.removeAllViews();
        if (homeFragment == null) {
            fragmentTransaction.add(R.id.content_main, new HomeFragment()
                    , getString(R.string.home_fragment));
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.remove(homeFragment);
            fragmentTransaction.add(R.id.content_main, homeFragment
                    , getString(R.string.home_fragment));
            fragmentTransaction.commit();
        }
    }

    private void setNewSmsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewSmsTransactionFragment newSmsTransactionFragment =
                (NewSmsTransactionFragment) fragmentManager.findFragmentByTag(getString(R.string.new_sms_transaction_fragment));


        if (newSmsTransactionFragment == null) {
            contentMain.removeAllViews();
            fragmentTransaction.add(R.id.content_main, new NewSmsTransactionFragment(), getString(R.string.new_sms_transaction_fragment));
            fragmentTransaction.commit();

        } else if (!newSmsTransactionFragment.isVisible()) {
            contentMain.removeAllViews();
            fragmentTransaction.remove(newSmsTransactionFragment);
            fragmentTransaction.commit();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.content_main, newSmsTransactionFragment, getString(R.string.new_sms_transaction_fragment));
            transaction.commit();

        }
    }

    protected <T extends Fragment> void displayFragment(Class<T> fragmentType, String tag, String title) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentManager.findFragmentByTag(getString(R.string.new_sms_transaction_fragment));

        Fragment fragment = fragmentType.cast(fragmentManager.findFragmentByTag(tag));
        setTitle(title);
        try {
            if (fragment == null) {
                contentMain.removeAllViews();
                fragmentTransaction.add(R.id.content_main, fragmentType.newInstance(), tag);
                fragmentTransaction.commit();
            } else if (!fragment.isVisible()) {
                contentMain.removeAllViews();
                fragmentTransaction.remove(fragment);
                fragmentTransaction.commit();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.content_main, fragmentType.newInstance(), tag);
                transaction.commit();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

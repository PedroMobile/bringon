package br.com.pedrosousa.bringon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.pedrosousa.bringon.fragment.CartsFragment;
import br.com.pedrosousa.bringon.fragment.MapMarketsFragment;
import br.com.pedrosousa.bringon.fragment.MyAccountFragment;
import br.com.pedrosousa.bringon.fragment.MyMarketFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "NAV_ACTIVITY";
    private static int menuItemId = 0;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
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
        getMenuInflater().inflate(R.menu.navigation, menu);
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

        if (menuItemId == item.getItemId()) {
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }

        selectItem(item.getItemId());

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void selectItem(int id){

        if (id == R.id.nav_map) {
            menuItemId = id;
            replaceFragment(new MapMarketsFragment());
        } else if (id == R.id.nav_carts) {
            menuItemId = id;
            replaceFragment(new CartsFragment());
        } else if (id == R.id.nav_market) {
            menuItemId = id;
            replaceFragment(new MyMarketFragment());
        } else if (id == R.id.nav_account) {
            menuItemId = id;
            replaceFragment(new MyAccountFragment());
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_sign_out) {

        }

    }

    public void replaceFragment(Fragment fragment){
        Bundle args = new Bundle();
        fragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, fragment);

        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}

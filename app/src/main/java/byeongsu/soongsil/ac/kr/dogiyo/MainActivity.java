package byeongsu.soongsil.ac.kr.dogiyo;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("지도"));
        tabLayout.addTab(tabLayout.newTab().setText("목록"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Using PagerAdapter to manage page views in fragments.
        final ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        final PagerAdapter pagerAdapter = new byeongsu.soongsil.ac.kr.dogiyo.PagerAdapter(
                getSupportFragmentManager(), tabLayout.getTabCount()
        );

        viewPager.setAdapter(pagerAdapter);

        // Setting a listener for clicks
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        Toast.makeText(this, "문의사항을 이메일로 보냅니다.", Toast.LENGTH_LONG).show();

        composeAskEmail();


        return super.onOptionsItemSelected(item);
    }

    public void composeAskEmail(){

        String uriText = "mailto:" + getString(R.string.developer_email)
                + "?subject=" + Uri.encode(getString(R.string.ask_email_title))
                + "&body=" + Uri.encode(getString(R.string.ask_email_text));

        Uri uri = Uri.parse(uriText);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        if( intent.resolveActivity(getPackageManager()) != null ){
            startActivity(intent);
        }


    }
}

package sg.edu.rp.soi.demoswiper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<Fragment> al;

    FragmentPagerAdapter adapter;

    ViewPager viewPager;



    Button btnBack, btnNext;







    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager1);

        btnBack = findViewById(R.id.btnBack);

        btnNext = findViewById(R.id.btnNext);





        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if(viewPager.getCurrentItem() > 0){

                    int previousPage = viewPager.getCurrentItem() - 1;

                    viewPager.setCurrentItem(previousPage, true);

                }

            }

        });



        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                int max = viewPager.getChildCount();

                if(viewPager.getCurrentItem() < max-1){

                    int nextPage  = viewPager.getCurrentItem() + 1;

                    viewPager.setCurrentItem(nextPage, true);

                }

            }

        });



        FragmentManager fm = getSupportFragmentManager();



        al = new ArrayList<Fragment>();

        al.add(new Frag1());

        al.add(new Frag2());

        adapter = new MyFragmentPagerAdapter(fm, al);

        viewPager.setAdapter(adapter);

    }

}
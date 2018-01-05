package com.example.android.funguangzhou;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link ImageView} in the toolbar
     */
    private ImageView toolbarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Update action bar title to app full name
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_full_name);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Only when device is in portrait mode, show the toolbar image
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            toolbarImageView = findViewById(R.id.toolbar_image);
            // Display the top spots image because the top spots tab is the default tab
            toolbarImageView.setImageResource(R.drawable.top_spots);
            // Use tab selected listener to decide which images displaced in toolbar
            tabLayout.addOnTabSelectedListener(mOnTabSelectedListener);

            AppBarLayout appBarLayout = findViewById(R.id.appbar);
            // Control toolbar image's transparency according to app bar's vertical offset
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    float percentage = ((float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange());
                    toolbarImageView.setAlpha(1 - percentage);
                }
            });
        }
    }

    /**
     * This listener gets triggered when the tabs of {@link TabLayout} were selected.
     */
    private TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            fadeOutAndInImage(toolbarImageView, tab);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    /**
     * Provide fade out and fade in animation for toolbar image switch.
     *
     * @param img is {@link ImageView} that should be displayed in the toolbar.
     * @param tab is the tab of {@link TabLayout} is currently selected.
     */
    private void fadeOutAndInImage(final ImageView img, final TabLayout.Tab tab) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(200);

        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(300);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                // Display different images in each fragment when tab is selected
                switch (tab.getPosition()) {
                    case CategoryAdapter.TAB_SPOTS:
                        toolbarImageView.setImageResource(R.drawable.top_spots);
                        return;
                    case CategoryAdapter.TAB_RESTAURANTS:
                        toolbarImageView.setImageResource(R.drawable.restaurants);
                        return;
                    case CategoryAdapter.TAB_HOTELS:
                        toolbarImageView.setImageResource(R.drawable.hotels);
                        return;
                    case CategoryAdapter.TAB_THINGS:
                        toolbarImageView.setImageResource(R.drawable.shopping);
                }
                // After fade out and switch image, start fade in animation
                img.startAnimation(fadeIn);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });

        img.startAnimation(fadeOut);
    }
}
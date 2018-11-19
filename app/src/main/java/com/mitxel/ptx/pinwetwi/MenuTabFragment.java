package com.mitxel.ptx.pinwetwi;



import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuTabFragment extends Fragment {


    private AppBarLayout appB;
    private TabLayout tabL;
    private ViewPager viewP;

    public MenuTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_tab, container, false);


        View contenedor = (View) container.getParent();
        appB=(AppBarLayout) contenedor.findViewById(R.id.appbar);
        tabL = new TabLayout(getActivity());
        tabL.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
        appB.addView(tabL);

        viewP = (ViewPager)view.findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewP.setAdapter(viewPagerAdapter);
        tabL.setupWithViewPager(viewP);

        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        appB.removeView(tabL);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter (FragmentManager fragmentManager){
            super(fragmentManager);
        }

        String titulos[] = {"Pinterest", "WeHeartIt", "Twitter"};

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0: return new Menu2Fragment();
                case 1: return new Menu3Fragment();
                case 2: return new Menu1Fragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulos[position];
        }
    }
}

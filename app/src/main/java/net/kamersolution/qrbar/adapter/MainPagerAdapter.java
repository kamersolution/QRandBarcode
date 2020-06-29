package net.kamersolution.qrbar.adapter;




import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Ashiq on 18/4/17.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> mFragmentItems;

    public <FragmentManager> MainPagerAdapter(FragmentManager fm, ArrayList<String> fragmentItems) {
        super((androidx.fragment.app.FragmentManager) fm);
        this.mFragmentItems = fragmentItems;
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;

        if(i == 0) {
            fragment = new Fragment();
        } else if(i == 1){
            fragment = new Fragment();
        } else if(i == 2){
            fragment = new Fragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mFragmentItems.size();
    }

}

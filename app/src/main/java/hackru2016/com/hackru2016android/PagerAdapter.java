package hackru2016.com.hackru2016android;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * Created by Ramaseshan on 10/22/2016.
 */



public class PagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.numTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Browse b = new Browse();
                return b;
            case 1:
                Create c = new Create();
                return c;
            case 2:
                MyRank rank = new MyRank();
                return rank;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}

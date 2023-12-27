package dev.n3shemmy3.kutamba.fragment;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.AppBarLayout;
import dev.n3shemmy3.kutamba.R;

public class BaseFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        setAppBarExpanded(true);
        super.onAttach(context);
    
    }
    
    public void setAppBarExpanded(boolean expanded){
        AppBarLayout appBarLayout = getActivity().findViewById(R.id.appbar);
        if (appBarLayout != null) {
            appBarLayout.setExpanded(expanded);
            appBarLayout.setLifted(false);
        }
    }
}

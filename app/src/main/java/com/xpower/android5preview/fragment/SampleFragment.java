package com.xpower.android5preview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xpower.android5preview.R;

/**
 * Created by 4399-3040 on 2016/7/25.
 */
public class SampleFragment extends Fragment {

    private View mBaseView;
    private TextView mTextView;

    private static String BUNDLE_TAG = "title";

    public static Fragment newInstance(String title) {
        SampleFragment fragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TAG, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.frag_sample, container, false);
        mTextView = (TextView) mBaseView.findViewById(R.id.frag_sample_tv);

        mTextView.setText(getArguments().getString(BUNDLE_TAG));

        return mBaseView;
    }
}

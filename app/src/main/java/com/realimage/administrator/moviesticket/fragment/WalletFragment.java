package com.realimage.administrator.moviesticket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realimage.administrator.moviesticket.R;
import com.realimage.administrator.moviesticket.activity.WalletActivity;

public class WalletFragment extends Fragment implements View.OnClickListener {
    TextView w_login;
    // Button w_login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View drawer = inflater.inflate(R.layout.wallet_fragment, container, false);
        //intialize the button
        //  w_login= (Button) drawer.findViewById(R.id.btn_wallet);
        w_login = (TextView) drawer.findViewById(R.id.btn_wallet);
        w_login.setOnClickListener(this);
        return drawer;
    }
    @Override
    public void onClick(View view) {

        Intent wallet = new Intent(getActivity(), WalletActivity.class);
        getActivity().startActivity(wallet);
    }
}

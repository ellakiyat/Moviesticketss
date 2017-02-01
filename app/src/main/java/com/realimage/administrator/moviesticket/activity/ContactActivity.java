package com.realimage.administrator.moviesticket.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.widget.TextView;
import com.realimage.administrator.moviesticket.R;

public class ContactActivity extends Activity {
    TextView jt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont);
        jt= (TextView) findViewById(R.id.tv_cont3);
        //paragraphspan one of the class allignspan
        String allignspan = getResources().getString(R.string.jt);
        SpannableString alspan = new SpannableString(allignspan);
        alspan.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),0,allignspan.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        jt.setText(alspan);
    }
}

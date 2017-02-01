package com.realimage.administrator.moviesticket.activity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AlignmentSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.realimage.administrator.moviesticket.R;
public class AboutActivity extends Activity {
    ////Span is used for grouping and appliying styles to inline text
    //spannable is a Spanned , adding in the ability to modify the spans (to add or remove formatting), but not to modify the text itself

    LinearLayout p_layout, pr_layout, t_layout;
    TextView tv_aboutver, tv_aboutjt, tv_aboutmt, tv_aboutoff, tv_aboutshare, tv_aboutlock, tv_aboutcond, tv_aboutcopyr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tv_aboutver = (TextView) findViewById(R.id.tv_aboutver);
        tv_aboutjt = (TextView) findViewById(R.id.tv_aboutjt);
        tv_aboutmt = (TextView) findViewById(R.id.tv_aboutmt);
        tv_aboutoff = (TextView) findViewById(R.id.tv_aboutoff);
        tv_aboutshare = (TextView) findViewById(R.id.txt_abouutshare);
        tv_aboutlock = (TextView) findViewById(R.id.tv_aboutlock);
        tv_aboutcond = (TextView) findViewById(R.id.tv_aboutcond);
        tv_aboutcopyr = (TextView) findViewById(R.id.tv_aboutcopyr);
        p_layout = (LinearLayout) findViewById(R.id.abt);
        pr_layout = (LinearLayout) findViewById(R.id.abt1);
        t_layout = (LinearLayout) findViewById(R.id.abt2);

        String aboutver=getResources().getString(R.string.aboutver);
        SpannableString rlsizespan = new SpannableString(aboutver);

        //Relativesizespan
        RelativeSizeSpan relativesmallSizeSpan = new RelativeSizeSpan(1f);

        //Foregroundcolorspan
        ForegroundColorSpan foregroundColorSpan= new ForegroundColorSpan(Color.CYAN);
        //span exclusive_exclusive means do not extend the included text at either their starting point and ending point
        rlsizespan.setSpan(relativesmallSizeSpan,0,rlsizespan.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        rlsizespan.setSpan(foregroundColorSpan,0,rlsizespan.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_aboutver.setText(rlsizespan);

        String aboutjt=getResources().getString(R.string.aboutjt);
        SpannableString span1 = new SpannableString(aboutjt);
        span1.setSpan(new RelativeSizeSpan(1f),0,aboutjt.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span1.setSpan(new URLSpan("https://www.justickets.in/chennai"),0,aboutjt.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span1.setSpan(new ForegroundColorSpan(Color.BLUE),0,aboutjt.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ////make our clickable and urlspans work, we have to call setmovement method
        tv_aboutjt.setMovementMethod(LinkMovementMethod.getInstance());
        tv_aboutjt.setText(span1);

        String aboutmt=getResources().getString(R.string.aboutmt);
        SpannableString span2 = new SpannableString(aboutmt);
        span2.setSpan(new RelativeSizeSpan(1.3f),0,aboutmt.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_aboutmt.setText(span2);

        //ALIGNMENT SPAN
        String aboutoff=getResources().getString(R.string.aboutoff);
        SpannableString span3 = new SpannableString(aboutoff);
        span3.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),0,aboutoff.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new RelativeSizeSpan(1.1f),0,aboutoff.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new StyleSpan(Typeface.ITALIC),46,52,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new SuperscriptSpan(),11,16,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(new SubscriptSpan(),63,66,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

                Toast.makeText(getApplicationContext(),"Cities Clicked",Toast.LENGTH_SHORT).show();
            }
        };

        span3.setSpan(clickableSpan,112,118,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //make our clickable and urlspans work, we have to call setmovement method
        tv_aboutoff.setMovementMethod(LinkMovementMethod.getInstance());
        tv_aboutoff.setText(span3);

        String aboutshare=getResources().getString(R.string.aboutshare);
        SpannableString span4 = new SpannableString(aboutshare);
        span4.setSpan(new UnderlineSpan(),0,aboutshare.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span4.setSpan(new RelativeSizeSpan(1.1f),0,aboutshare.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_aboutshare.setText(span4);

        String aboutlock=getResources().getString(R.string.abtlock);
        SpannableString span5 = new SpannableString(aboutlock);
        span5.setSpan(new UnderlineSpan(),0,aboutlock.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span5.setSpan(new RelativeSizeSpan(1.1f),0,aboutlock.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_aboutlock.setText(span5);

        String aboutcond=getResources().getString(R.string.aboutcond);
        SpannableString span6 = new SpannableString(aboutcond);
        span6.setSpan(new UnderlineSpan(),0,aboutcond.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span6.setSpan(new RelativeSizeSpan(1.1f),0,aboutcond.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_aboutcond.setText(span6);

        String aboutcopyr=getResources().getString(R.string.aboutcopyr);
        SpannableString span7 = new SpannableString(aboutcopyr);
        span7.setSpan(new ForegroundColorSpan(Color.GRAY),0,aboutcopyr.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span7.setSpan(new RelativeSizeSpan(1f),0,aboutcopyr.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_aboutcopyr.setText(span7);

        p_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lay = new Intent(AboutActivity.this, PpolicyActivity.class);
                startActivity(lay);

            }
        });

        pr_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pri_lay = new Intent(AboutActivity.this, PripolicyActivity.class);
                startActivity(pri_lay);
            }
        });

        t_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ter_lay = new Intent(AboutActivity.this, TermActivity.class);
                startActivity(ter_lay);
            }
        });
    }
}

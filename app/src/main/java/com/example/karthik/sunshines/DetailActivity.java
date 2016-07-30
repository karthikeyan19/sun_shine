package com.example.karthik.sunshines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
public static final String FORECAT_HASTAG="#SunShine";
    String detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent extra=getIntent();
        detail=extra.getStringExtra(Intent.EXTRA_TEXT);
        TextView detailTextView= (TextView) findViewById(R.id.details);
        detailTextView.setText(detail);
        //ImageView imageView=(ImageView)findViewById(R.id.image_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=new MenuInflater(getApplicationContext());
                inflater.inflate(R.menu.detail_fragment,menu);
        MenuItem item = menu.findItem(R.id.action_share1);
        ShareActionProvider mShareActionProvider = new ShareActionProvider(this);
        mShareActionProvider.setShareIntent(createShareIntent());
        MenuItemCompat.setActionProvider(item, mShareActionProvider);
/*      if(mShareActionProvider!=null)
        {

        }
        else
        {
            Log.e("Sunshine","error");
        }*/
        return true;
    }


    private Intent createShareIntent() {
     Intent shareIntent=new Intent(Intent.ACTION_SEND)
             .addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
             .setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,detail+FORECAT_HASTAG);
        return shareIntent;

    }
}

package sg.edu.rp.c346.id20018318.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);

        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);

        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == tvDBS) {
            wordClicked = "DBS";
        }
        else if (v == tvOCBC) {
            wordClicked = "OCBC";
        }
        else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_2, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.webSelection) {
                Intent dbsWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(dbsWeb);
            } else if (id == R.id.contactSelection) {
                Intent callDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111L));
                startActivity(callDBS);
            } else if (id == R.id.toggleFav) {
                if (tvDBS.getCurrentTextColor() == Color.BLACK){
                    tvDBS.setTextColor(Color.RED);
                } else if (tvDBS.getCurrentTextColor() == Color.RED) {
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
            return true; //menu item successfully handled
        }

        if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (id == R.id.webSelection) {
                Intent ocbcWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(ocbcWeb);
            } else if (id == R.id.contactSelection) {
                Intent callOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333L));
                startActivity(callOCBC);
            } else if (id == R.id.toggleFav) {
                tvOCBC.setTextColor(Color.parseColor("#FF0000"));
            } } else if (id == R.id.toggleFav) {
            if (tvDBS.getCurrentTextColor() == Color.BLACK){
                tvDBS.setTextColor(Color.RED);
            } else if (tvDBS.getCurrentTextColor() == Color.RED) {
                tvDBS.setTextColor(Color.BLACK);
            }
            return true; //menu item successfully handled
        }

        if (wordClicked.equalsIgnoreCase("UOB")) {
            if(id == R.id.webSelection) {
                Intent uobWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(uobWeb);
            } else if(id == R.id.contactSelection) {
                Intent callUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002222121L));
                startActivity(callUOB);
            } else if (id == R.id.toggleFav) {
                tvUOB.setTextColor(Color.parseColor("#FF0000"));
            }} else if (id == R.id.toggleFav) {
            if (tvDBS.getCurrentTextColor() == Color.BLACK){
                tvDBS.setTextColor(Color.RED);
            } else if (tvDBS.getCurrentTextColor() == Color.RED) {
                tvDBS.setTextColor(Color.BLACK);
            }
            return true; //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}
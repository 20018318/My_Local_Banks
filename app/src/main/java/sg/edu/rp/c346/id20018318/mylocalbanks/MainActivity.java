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

        if (wordClicked.equalsIgnoreCase(getString(R.string.dbs))) {
            if (id == R.id.webSelection) {
                Intent dbsWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(dbsWeb);
            } else if (id == R.id.contactSelection) {
                Intent callDBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111L));
                startActivity(callDBS);
            } else if (id == R.id.toggleFav) {
                if (tvDBS.getCurrentTextColor() == Color.BLACK) {
                    tvDBS.setTextColor(Color.RED);
                } else if (tvDBS.getCurrentTextColor() == Color.RED) {
                    tvDBS.setTextColor(Color.BLACK);
                }
                return true; //menu item successfully handled
            }
        } // end

        if (wordClicked.equalsIgnoreCase(getString(R.string.ocbc))) {
            if (id == R.id.webSelection) {
                Intent ocbcWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(ocbcWeb);
            } else if (id == R.id.contactSelection) {
                Intent callOCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333L));
                startActivity(callOCBC);
            } else if (id == R.id.toggleFav) {
                if (tvDBS.getCurrentTextColor() == Color.BLACK) {
                    tvDBS.setTextColor(Color.RED);
                } else if (tvDBS.getCurrentTextColor() == Color.RED) {
                    tvDBS.setTextColor(Color.BLACK);
                }
                return true; //menu item successfully handled
            }
        }
        if (wordClicked.equalsIgnoreCase(getString(R.string.uob))) {
            if (id == R.id.webSelection) {
                Intent uobWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(uobWeb);
            } else if (id == R.id.contactSelection) {
                Intent callUOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121L));
                startActivity(callUOB);
            } else if (id == R.id.toggleFav) {
                if (tvDBS.getCurrentTextColor() == Color.BLACK) {
                    tvDBS.setTextColor(Color.RED);
                } else if (tvDBS.getCurrentTextColor() == Color.RED) {
                    tvDBS.setTextColor(Color.BLACK);
                }
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
            tvDBS.setText(R.string.dbs);
            tvOCBC.setText(R.string.ocbc);
            tvUOB.setText(R.string.uob);
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(R.string.dbsChi);
            tvOCBC.setText(R.string.ocbcChi);
            tvUOB.setText(R.string.uobChi);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
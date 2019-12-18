package d2.hu.searchdialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SimpleSearchDialogCompat(MainActivity.this, "Search...", "What are you looking for...?",
                        null, initData(), new SearchResultListener<Searchable>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        Toast.makeText(MainActivity.this,""+searchable.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();
                    }
                }).show();
            }
        });
    }

    private ArrayList<SearchModel> initData(){
        ArrayList<SearchModel> items = new ArrayList<>();

        items.add(new SearchModel("CA"));
        items.add(new SearchModel("CE"));
        items.add(new SearchModel("AA"));
        items.add(new SearchModel("ACE"));
        items.add(new SearchModel("PD"));
        items.add(new SearchModel("PDF"));
        items.add(new SearchModel("Captain"));


        return items;

    }
}

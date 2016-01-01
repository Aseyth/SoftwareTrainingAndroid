package com.example.ung.food;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ung on 29/12/2015.
 */
public class MainPage extends AppCompatActivity {

    /*ArrayAdapter<String> adapter;
    EditText et;
    Button createButton;
    ListView listView;
    ArrayList<String> strArr;
    //String[]RecipesArray = {"Food", "DogFood", "CatFood", "InuFood", "NekoFood", "ToriFood", "Birdfood", "NingenFood", "KamiFood", "JunkFood", "TrashFood", "FastFood", "KumaFood", "KoreanFood", "FrenchFood", "ChineseFood",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = (Button) findViewById(R.id.createButton);
        listView = (ListView) findViewById(R.id.FoodList);
        et = (EditText) findViewById(R.id.editText);

        strArr = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            strArr.add("Food Name " + i);
        }





        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, strArr);

        // Assign adapter to ListView
        listView.setAdapter(adapter);


        // Function will create the new Intent
        createButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //Create New Intent
                                                // Intent intent = new Intent(MainActivity.this, AddNewRowForm.class);
                                                String input = et.getText().toString();
                                                strArr.add(et.getText().toString());
                                                adapter.notifyDataSetChanged();
                                                Toast.makeText(getApplicationContext(),
                                                        input + " Created", Toast.LENGTH_LONG)
                                                        .show();
                                                //based on item add info to intent
                                                //  startActivity(intent);
                                            }
                                        }
        );

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

                //Create New Intent
                Intent intent = new Intent(MainActivity.this, RecipesActivity.class);

                intent.putExtra("position", position);

                //based on item add info to intent
                startActivity(intent);

            }

        });
    }*/







    public class codeLeanChapter {
        String chapterName;
        String chapterDescription;
    }

    CodeLearnAdapter chapterListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_simple_adapter);


        chapterListAdapter = new CodeLearnAdapter();

        ListView codeLearnLessons = (ListView) findViewById(R.id.listView1);
        codeLearnLessons.setAdapter(chapterListAdapter);

        codeLearnLessons.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                codeLeanChapter chapter = chapterListAdapter.getCodeLearnChapter(arg2);

                //Create New Intent
                Intent intent = new Intent(MainPage.this, RecipesActivity.class);
                intent.putExtra("foodName", chapter.chapterName);
                intent.putExtra("foodDesc", chapter.chapterDescription);
                //based on item add info to intent
                startActivity(intent);

                Toast.makeText(MainPage.this, chapter.chapterName, Toast.LENGTH_LONG).show();

            }
        });
    }


    public class CodeLearnAdapter extends BaseAdapter {

        List<codeLeanChapter> codeLeanChapterList = getDataForListView();
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return codeLeanChapterList.size();
        }

        @Override
        public codeLeanChapter getItem(int arg0) {
            // TODO Auto-generated method stub
            return codeLeanChapterList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            if(arg1==null)
            {
                LayoutInflater inflater = (LayoutInflater) MainPage.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.listitem, arg2,false);
            }

            TextView chapterName = (TextView)arg1.findViewById(R.id.textView1);
            TextView chapterDesc = (TextView)arg1.findViewById(R.id.textView2);

            codeLeanChapter chapter = codeLeanChapterList.get(arg0);

            chapterName.setText(chapter.chapterName);
            chapterDesc.setText(chapter.chapterDescription);

            return arg1;
        }

        public codeLeanChapter getCodeLearnChapter(int position)
        {
            return codeLeanChapterList.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.list_view_with_simple_adapter, menu);
        return true;
    }

    public List<codeLeanChapter> getDataForListView()
    {
        List<codeLeanChapter> codeLeanChaptersList = new ArrayList<codeLeanChapter>();

        for(int i=0;i<20;i++)
        {

            codeLeanChapter chapter = new codeLeanChapter();
            chapter.chapterName = "Dish "+i;
            chapter.chapterDescription = "This is the recipe for the dish "+i;
            codeLeanChaptersList.add(chapter);
        }

        return codeLeanChaptersList;

    }
}

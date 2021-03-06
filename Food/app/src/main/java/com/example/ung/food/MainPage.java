package com.example.ung.food;

import android.app.SearchManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
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
import android.widget.ImageView;
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
public class MainPage extends ActionBarActivity{ //extends AppCompatActivity{

    static List<Recipe> recipeList = new ArrayList<Recipe>();
    static User user = new User();

    OnTaskCompleted taskCompleted = new OnTaskCompleted() {
        @Override
        public void onAllReceipesReceived() {

            updateViewList();
            System.out.println("CALLBACK CALLED");
        }

        @Override
        public void onTryLoggin(Boolean isAccepted) {

        }

    };


    public class codeLeanChapter {
        String chapterName;
        String chapterDescription;
        Bitmap image;
        String idRecipe;
    }

    CodeLearnAdapter chapterListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_simple_adapter);

        RestRequestRecipes requestRecipes = new RestRequestRecipes(taskCompleted);

        requestRecipes.execute();

        updateViewList();

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
            ImageView chapterImg = (ImageView)arg1.findViewById(R.id.imageView1);
            codeLeanChapter chapter = codeLeanChapterList.get(arg0);

            chapterName.setText(chapter.chapterName);
            chapterDesc.setText(chapter.chapterDescription);
            chapterImg.setImageBitmap(chapter.image);

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


        for(int i=0;i < recipeList.size(); i++)
        {
            codeLeanChapter chapter = new codeLeanChapter();
            chapter.chapterName = recipeList.get(i).getName();
            chapter.chapterDescription = recipeList.get(i).getDescription();
            chapter.idRecipe = recipeList.get(i).getId();
            if (recipeList.get(i).getImage() != null)
                chapter.image = recipeList.get(i).getImage();
            codeLeanChaptersList.add(chapter);
        }


        return codeLeanChaptersList;

    }

    public void updateViewList()
    {
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
                intent.putExtra("recipeID", chapter.idRecipe);
                //based on item add info to intent
                startActivity(intent);

            }
        });
    }
}

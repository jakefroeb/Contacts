package com.theironyard.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{
    ListView list;
    EditText text;
    EditText text2;
    Button addButton;
    ArrayAdapter<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        text2 = (EditText) findViewById(R.id.editText2) ;
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        list.setAdapter(items);


        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String item = text.getText().toString() + ",  (" + text2.getText().toString() + ")";
        items.add(item);
        text.setText("");
        text2.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);

        return true;
    }
}

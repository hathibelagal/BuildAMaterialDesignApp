package com.github.hathibelagal.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.UUID;

import io.realm.Realm;

public class ItemActivity extends AppCompatActivity {

    private EditText inputItemName;
    private EditText inputItemQuantity;
    private Realm realm;

    private boolean editMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        if(getIntent().hasExtra("TITLE")) {
            setTitle(getIntent().getStringExtra("TITLE"));
        }

        inputItemName = (EditText)findViewById(R.id.input_item_name);
        inputItemQuantity = (EditText)findViewById(R.id.input_item_quantity);

        realm = Realm.getDefaultInstance();

        if(getIntent().hasExtra("ITEM_NAME")) {
            inputItemName.setText(getIntent().getStringExtra("ITEM_NAME"));
            inputItemQuantity.setText(getIntent().getStringExtra("ITEM_QUANTITY"));
            editMode = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.save_action && !editMode) {
            realm.beginTransaction();
            ShoppingItem shoppingItem = realm.createObject(ShoppingItem.class);
            shoppingItem.setName(inputItemName.getText().toString());
            shoppingItem.setQuantity(inputItemQuantity.getText().toString());
            shoppingItem.setCompleted(false);
            shoppingItem.setId(UUID.randomUUID().toString());
            shoppingItem.setTimestamp(System.currentTimeMillis());
            realm.commitTransaction();

            setResult(RESULT_OK);
            finish();
        }

        if(item.getItemId()==R.id.save_action && editMode) {
            realm.beginTransaction();
            ShoppingItem shoppingItem =
                    realm.where(ShoppingItem.class).equalTo("id", getIntent().getStringExtra("ITEM_ID")).findFirst();
            shoppingItem.setName(inputItemName.getText().toString());
            shoppingItem.setQuantity(inputItemQuantity.getText().toString());
            shoppingItem.setTimestamp(System.currentTimeMillis());
            realm.commitTransaction();

            setResult(RESULT_OK);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

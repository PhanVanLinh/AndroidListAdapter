package toong.com.androidlistadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ContactAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.submitList(getData());

        findViewById(R.id.button_update_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.submitList(getUpdatedData());
            }
        });


        findViewById(R.id.button_add_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo update
            }
        });
    }

    public static ArrayList<Contact> getData() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("A", "0"));
        contacts.add(new Contact("B", "1"));
        contacts.add(new Contact("C", "2"));
        contacts.add(new Contact("D", "3"));
        contacts.add(new Contact("E", "4"));
        contacts.add(new Contact("F", "5"));
        contacts.add(new Contact("G", "6"));
        contacts.add(new Contact("H", "7"));
        contacts.add(new Contact("I", "8"));
        contacts.add(new Contact("J", "9"));
        contacts.add(new Contact("K", "10"));
        return contacts;
    }

    public static ArrayList<Contact> getUpdatedData() {
        ArrayList<Contact> contacts = getData();
        contacts.get(0).setPhoneNumber("00");
        contacts.get(0).setName("AA");

        contacts.get(2).setPhoneNumber("22");
        contacts.get(3).setPhoneNumber("33");
        return contacts;
    }


}

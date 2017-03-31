package ganesh.com.adaptercursor;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {


    //  This example of cursor adapter using extends ListActivity of this class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Cursor cursor = getContentResolver().query(Contacts.People.CONTENT_URI, new String[] {Contacts.People._ID, Contacts.People.NAME, Contacts.People.NUMBER}, null, null, null);
        startManagingCursor(cursor);

        // the desired columns to be bound
        String[] columns = new String[] { Contacts.People.NAME, Contacts.People.NUMBER };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.name_entry, R.id.number_entry };

        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list, cursor, columns, to);

        // set this adapter as your ListActivity's adapter
        this.setListAdapter(mAdapter);

    }

}

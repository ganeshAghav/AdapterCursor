package ganesh.com.adaptercursor;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {


    //This coursor adapter example is without ListActivity extends example

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Cursor cursor = getContentResolver().query(Contacts.People.CONTENT_URI, new String[] {Contacts.People._ID, Contacts.People.NAME, Contacts.People.NUMBER}, null, null, null);
        startManagingCursor(cursor);

        // the desired columns to be bound
        String[] columns = new String[] { Contacts.People.NAME, Contacts.People.NUMBER };

        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.title2};
        
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list2, cursor, columns, to);

        ListView lv = (ListView)findViewById(R.id.contactListView);
        lv.setAdapter(adapter);
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

                cursor.moveToPosition(pos);
                int rowId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                Uri outURI = Uri.parse(data.toString() + rowId);
                Intent outData = new Intent();
                outData.setData(outURI);
                setResult(Activity.RESULT_OK, outData);
                finish();
            }

        });*/
    }

}
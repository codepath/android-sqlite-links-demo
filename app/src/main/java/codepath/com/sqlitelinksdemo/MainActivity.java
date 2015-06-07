package codepath.com.sqlitelinksdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageLinksCountDatabase imageLinkCountDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        String url = "http://newsfunstyle.com/wp-content/uploads/2014/12/Jello-Jigglers.jpg";
        new ImageLoaderLibrary().load(url, imageView);

        imageLinkCountDatabase = new ImageLinksCountDatabase(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View view) {
        TextView etURL = (TextView) findViewById(R.id.etURL);
        String url = etURL.getText().toString();
        if(!TextUtils.isEmpty(url)) {
            ImageLoaderLibrary.load(url, imageView);
            ImageLinkCount row = imageLinkCountDatabase.getRecord(url);
            Toast.makeText(this, String.valueOf(row.getTimesSeen()), Toast.LENGTH_SHORT).show();
        }
    }
}

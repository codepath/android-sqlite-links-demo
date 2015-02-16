package codepath.com.sqlitelinksdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ImageLinksCountDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "abc";

    private static final String TABLE_LINKS = "link_items";

    private static final String KEY_ID = "id";
    private static final String KEY_URL = "url";
    private static final String KEY_TIMES_SEEN = "times_seen";

    ImageLinksCountDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEMS_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)",
                TABLE_LINKS, KEY_ID, KEY_URL, KEY_TIMES_SEEN);
        Log.d("DEBUG", CREATE_ITEMS_TABLE);
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_LINKS);
            onCreate(db);
        }
    }

    public ImageLinkCount getRecord(String url) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LINKS,
                     new String[] { KEY_ID, KEY_URL, KEY_TIMES_SEEN}, // SELECT
                     String.format("%s= ?", KEY_URL), new String[] {url},
                     null, null, null, null);

        if (cursor != null) {
            if (!cursor.moveToFirst()) {
                return null;
            }
            ImageLinkCount item = new ImageLinkCount(cursor.getString(1), cursor.getInt(2));
            item.setId(cursor.getInt(0));
            return item;
        }
        return null;
    }

    public ImageLinkCount createRecord(String url) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_URL, url);
        values.put(KEY_TIMES_SEEN, 0);

        long row = db.insertOrThrow(TABLE_LINKS, null, values);
        db.close();

        if (row != -1) {
            ImageLinkCount item = new ImageLinkCount(url, 0);
            item.setId(row);
            return item;
        }
        return null;
    }

    public int updateItem(ImageLinkCount item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_URL, item.getURL());
        values.put(KEY_TIMES_SEEN, item.getTimesSeen());

        int result = db.update(TABLE_LINKS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(item.getId()) });

        db.close();
        return result;
    }

    public ImageLinkCount getOrCreate(String url) {
        SQLiteDatabase db = this.getWritableDatabase();

        ImageLinkCount imageLinkCount = getRecord(url);

        if (imageLinkCount == null) {
            return createRecord(url);
        } else {
        }
        db.close();
        return imageLinkCount;
    }

}


# Demo app for SQLiteOpenHelper

This is a demo of how to build a basic image loading app that keeps track of the number of times each image is loaded using SQLite. This app is a useful demo of the following topics:

 * How to perform networking using `HttpURLConnection` to load remote images and turn them into `Bitmap`
 * How to create a database using `SQLiteOpenHelper` and create the database schema
 * How to query and update data from tables within a database using `Cursor`

You can review the following key files below:

 * [ImageLinksCount](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/ImageLinkCount.java) - This is the model representing the table storing the links and the open counts.
 * [ImageLinksCountDatabase](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/ImageLinksCountDatabase.java) - The `SQLiteOpenHelper` that creates and opens a connection to the underlying database.
 * [ImageLoaderLibrary](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/ImageLoaderLibrary.java) - Simple image loader library built from scratch on top of basic. `HttpURLConnection`
 * [MainActivity](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/MainActivity.java) - The activity which brings this app together.

Check the following guides for more details:

 * [Sending-and-Managing-Network-Requests](http://guides.codepath.com/android/Sending-and-Managing-Network-Requests#displaying-remote-images-the-hard-way)
 * [Local Databases with SQLiteOpenHelper](http://guides.codepath.com/android/Local-Databases-with-SQLiteOpenHelper)

![Screenshot](http://imgur.com/mfxDMcZ.png)

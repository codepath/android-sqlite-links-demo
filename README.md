# Demo app for SQLiteOpenHelper

This is a demo of how to build a basic image loading app that keeps track of the number of times each image is loaded using SQLite. This app is a useful demo of the following topics:

 * How to perform networking using `HttpURLConnection` to load remote images and turn them into `Bitmap`
 * How to create a database using `SQLiteOpenHelper` and create the database schema
 * How to query and update data from tables within a database using `Cursor`

You can review the following key files below:

 * [ImageLinksCount](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/ImageLinkCount.java) - Model representing the table storing links and open counts.
 * [ImageLinksCountDatabase](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/ImageLinksCountDatabase.java) - The `SQLiteOpenHelper` that enables a database connection.
 * [ImageLoaderLibrary](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/ImageLoaderLibrary.java) - Simple image loader library built on top of `HttpURLConnection`
 * [MainActivity](https://github.com/codepath/android-sqlite-links-demo/blob/master/app/src/main/java/codepath/com/sqlitelinksdemo/MainActivity.java) - The activity which brings this whole app together.

Check the following Android guides for more details:

 * [Sending and Managing Network Requests](http://guides.codepath.com/android/Sending-and-Managing-Network-Requests#displaying-remote-images-the-hard-way)
 * [Local Databases with SQLiteOpenHelper](http://guides.codepath.com/android/Local-Databases-with-SQLiteOpenHelper)

<img src="http://imgur.com/mfxDMcZ.png" width="400" alt="demo" />

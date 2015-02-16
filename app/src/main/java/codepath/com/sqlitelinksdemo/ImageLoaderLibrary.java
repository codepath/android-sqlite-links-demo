package codepath.com.sqlitelinksdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoaderLibrary {

    public static ImageLoaderLibrary imageLoaderLibrary;

    public static void load(String url, ImageView imageView) {
        if (imageLoaderLibrary == null) {
            imageLoaderLibrary = new ImageLoaderLibrary();
        }
        imageLoaderLibrary.loadPrivate(url, imageView);
        ImageLinksCountDatabase imageLinkCountDatabase = new ImageLinksCountDatabase(imageView.getContext());
        ImageLinkCount imageLinkCount = imageLinkCountDatabase.getOrCreate(url);
        imageLinkCount.incrementTimesSeen();
        imageLinkCountDatabase.updateItem(imageLinkCount);
    }

    protected void loadPrivate(String url, ImageView imageView) {
        new ImageLoader(imageView).execute(url);
    }

    public class ImageLoader extends AsyncTask<String, Void, Bitmap> {

        // make a URL connection
        // open a stream
        // convert the bytes

        private ImageView imageView;

        public ImageLoader(ImageView imageView) {
            this.imageView = imageView;
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                in.close();
                return bitmap;
            } catch (IOException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }
}

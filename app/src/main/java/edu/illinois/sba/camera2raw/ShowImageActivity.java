package edu.illinois.sba.camera2raw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShowImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        Button button = (Button) findViewById(R.id.show_image_done);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        String path = getIntent().getStringExtra("JPEG_PATH");
        Log.d("TAG", path);
        Bitmap bitmap = decodeIMG(path);
        imageView.setImageBitmap(bitmap);
    }

    private static Bitmap decodeIMG(String img) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap bitmap = BitmapFactory.decodeFile(img, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }



}

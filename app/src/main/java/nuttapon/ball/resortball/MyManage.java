package nuttapon.ball.resortball;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sssssssss on 31/3/2559.
 */
public class MyManage {

    // Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;


    public MyManage(Context context) {


        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    } // Constructor
} // Main Class

package nuttapon.ball.resortball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ShowServiceActivity extends AppCompatActivity {

    //
    private TextView showNameTextView;
    private ListView serviceListView;
    private String namestring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service);

        bindWidget();

        showView();
    }// Main Method

    private void showView() {
        namestring = getIntent().getStringExtra("NameUser");
        showNameTextView.setText(namestring);

    }

    private void bindWidget() {
        showNameTextView = (TextView) findViewById(R.id.textView7);
        serviceListView = (ListView) findViewById(R.id.listView);
    }

    public void clickReadOrder(View view) {

    } // clicik


} // Main class

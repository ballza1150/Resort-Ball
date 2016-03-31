package nuttapon.ball.resortball;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class SingUpActiviity extends AppCompatActivity {

    // Explicit
    private EditText userEditText, passwordEditText,
            nameEditText, idCardEditText;
    private String userString, passwordString,
            nameString, idcardString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_activiity);

        // bindwidget
        bindwidget();
    } // Main Method

    private void bindwidget() {
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
        nameEditText = (EditText) findViewById(R.id.editText3);
        idCardEditText = (EditText) findViewById(R.id.editText4);
    }

    public void clickSignUpSign(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        nameString = nameEditText.getText().toString().trim();
        idcardString = idCardEditText.getText().toString().trim();

        // Check Space
        if (checkSpace()) {
            // Have Space
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง");


        } else {
            // No Space
            updateToMySQL();
        }

    } // ClickSing

    private void updateToMySQL() {

        // Connected Http
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("isAdd", "true"));
            nameValuePairs.add(new BasicNameValuePair("User", userString));
            nameValuePairs.add(new BasicNameValuePair("Password", passwordString));
            nameValuePairs.add(new BasicNameValuePair("Name", nameString));
            nameValuePairs.add(new BasicNameValuePair("IDcard", idcardString));

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/ball/php_add_data_user.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            httpClient.execute(httpPost);

            Toast.makeText(this, "บันทึกได้เรียบร้อย ขอบคุณครับ", Toast.LENGTH_SHORT).show();
            finish();

        } catch (Exception e) {
            Toast.makeText(this, "ไม่สามารถบันทึกข้อมูลได้", Toast.LENGTH_SHORT).show();
        }

    } // update

    private boolean checkSpace() {

        boolean bolResult = true;

        bolResult = userString.equals("") ||
                passwordString.equals("") ||
                nameString.equals("") ||
                idcardString.equals("");

        Log.d("test", "bol=" + bolResult);

        return bolResult;
    }

}  // Main Class

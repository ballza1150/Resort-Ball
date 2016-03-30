package nuttapon.ball.resortball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        } else {
            // No Space
        }

    } // ClickSing

    private boolean checkSpace() {

        boolean bolResult = true;

        bolResult = userString.endsWith("") ||
                passwordString.equals("") ||
                nameString.equals("") ||
                idcardString.equals("");
        return bolResult;
    }

}  // Main Class

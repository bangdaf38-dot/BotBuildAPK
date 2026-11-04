import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.text.InputType;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        final EditText et1 = new EditText(this);
        et1.setHint("Operand 1");
        et1.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(et1);

        final EditText et2 = new EditText(this);
        et2.setHint("Operand 2");
        et2.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(et2);

        Button btnAdd = new Button(this);
        btnAdd.setText("+");
        btnAdd.setOnClickListener(v -> calculate(et1, et2, "+"));
        layout.addView(btnAdd);

        Button btnSub = new Button(this);
        btnSub.setText("-");
        btnSub.setOnClickListener(v -> calculate(et1, et2, "-"));
        layout.addView(btnSub);

        Button btnMul = new Button(this);
        btnMul.setText("*");
        btnMul.setOnClickListener(v -> calculate(et1, et2, "*"));
        layout.addView(btnMul);

        Button btnDiv = new Button(this);
        btnDiv.setText("/");
        btnDiv.setOnClickListener(v -> calculate(et1, et2, "/"));
        layout.addView(btnDiv);

        setContentView(layout);
    }

    private void calculate(EditText et1, EditText et2, String op) {
        try {
            double a = Double.parseDouble(et1.getText().toString());
            double b = Double.parseDouble(et2.getText().toString());
            double result;
            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/":
                    if (b == 0) {
                        Toast.makeText(this, "Division by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = a / b;
                    break;
                default: return;
            }
            Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }
}
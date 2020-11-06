package com.example.question1ass2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3;
    Button btn1;
    TextView t1;
    double root1, root2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.num1);
        e2=(EditText)findViewById(R.id.num2);
        e3=(EditText)findViewById(R.id.num3);
        btn1=(Button)findViewById(R.id.btn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String a=e1.getText().toString();
                String b=e2.getText().toString();
                String c=e3.getText().toString();

                int a1=Integer.parseInt(a);
                int b1=Integer.parseInt(b);
                int c1=Integer.parseInt(c);

                if((a1>='a' && a1<='z') || (a1>='A' && a1<='Z') || (b1>='a' && b1<='z') || (b1>='A' && b1<='Z') || (c1>='a' && c1<='z') || (c1>='A' && c1<='Z'))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Enter integer value " ,Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();

                }
                else if ((String.valueOf(a1).matches("[^a-zA-Z0-9]")) || (String.valueOf(b1).matches("[^a-zA-Z0-9]")) || (String.valueOf(c1).matches("[^a-zA-Z0-9]")))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Enter integer value " ,Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                }



                double determinant = b1 * b1 - 4 * a1 * c1;

                // condition for real and different roots
                if(determinant > 0) {
                    root1 = (-b1 + Math.sqrt(determinant)) / (2 * a1);
                    root2 = (-b1 - Math.sqrt(determinant)) / (2 * a1);
                    t1.setText(String.valueOf(root1));
                    t1.setText(String.valueOf(root2));
                    //System.out.format("root1 = %.2f and root2 = %.2f", root1 , root2);
                }
                // Condition for real and equal roots
                else if(determinant == 0) {
                    root1 = root2 = -b1 / (2 * a1);
                    t1.setText(String.valueOf(root1));

                    //System.out.format("root1 = root2 = %.2f;", root1);
                }
                // If roots are not real
                else {
                    double realPart = -b1 / (2 *a1);
                    double imaginaryPart = Math.sqrt(-determinant) / (2 * a1);
                    t1.setText(String.valueOf(root1+'i'));
                    t1.setText(String.valueOf(root2+'i'));

                    //System.out.format("root1 = %.2f+%.2fi and root2 = %.2f-%.2fi", realPart, imaginaryPart, realPart, imaginaryPart);
                }
            }
        });
    }
}




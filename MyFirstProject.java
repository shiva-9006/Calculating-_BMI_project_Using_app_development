package com.android.myfirstproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;


public class MyFirstProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first_project);

        TextView result;
        EditText Edtwt ,EdtHeightFt ,editHeight_In;
        Button CalculateBMI;


        LinearLayout LL;


        LL=findViewById(R.id.LL);

        result=findViewById(R.id.result);
        Edtwt=findViewById(R.id.Editwt);
        EdtHeightFt=findViewById(R.id.EdtHeightFt);
        editHeight_In=findViewById(R.id.editHeight_In);

        CalculateBMI=findViewById(R.id.CalculateBMI);


    CalculateBMI.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//             int wt=Integer.parseInt(Editwt.getText().toString());
//              int ft=Integer.parseInt(EdtHeightFt.getText().toString());
//              int in=Integer.parseInt(editHeight_In.getText().toString());

            String EdtWt = Edtwt.getText().toString();
            String EditFt = EdtHeightFt.getText().toString();

            String EditIn = editHeight_In.getText().toString();

            if (EdtWt.isEmpty() || EditFt.isEmpty() || EditIn.isEmpty()) {
                result.setText("Kindly fill in your weight and height to calculate BMI.\n");

                return;
            }

            try {
                int wt = Integer.parseInt(EdtWt);
                int ft = Integer.parseInt(EditFt);
                int in = Integer.parseInt(EditIn);


                int totalIn = ft * 12 + in;

                double totalCm = totalIn * 2.54;

                double totalM = totalCm * 0.01; // total Height in Meter !!!!!!


                double BMI = wt / (totalM * totalM);  // Height  takes in meter !!!!!!

                if (BMI >= 24.9) {
                    result.setText("You are OverWeight");
                    LL.setBackgroundColor(ContextCompat.getColor(MyFirstProject.this, R.color.OverWeight));

                } else if (BMI < 18.5) {

                    result.setText("You are UnderWeight");

                    LL.setBackgroundColor(ContextCompat.getColor(MyFirstProject.this, R.color.UnderWeight));
                } else {
                    result.setText("You are Healthy");

                    LL.setBackgroundColor(ContextCompat.getColor(MyFirstProject.this, R.color.Healthy));
                }
            }

            catch (NumberFormatException e){
                result.setText("Enter valid input");
            }


        }
    });

}




    }

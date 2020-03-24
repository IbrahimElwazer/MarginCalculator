package my.margin.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView answer;
    EditText principal, annualInterest, period;
    Button button;

    int principalValue, annualInterestValue, periodValue, monthlyInterestRate, numberOfPayments;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer =  (TextView)findViewById(R.id.answer);

        principal = (EditText)findViewById(R.id.principal_input);

        annualInterest = (EditText)findViewById(R.id.annual_interest_input);

        period = (EditText)findViewById(R.id.period_input);

        button = (Button)findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                // The amount to be loaned, Example: 10000 dollars
                principalValue = Integer.parseInt(principal.getText().toString());

                // Annual Interest Rate, Example: 3.29%. It is converted to a decimal out of 100 and converted to monthly rate
                annualInterestValue = Integer.parseInt(annualInterest.getText().toString());
                monthlyInterestRate = (annualInterestValue/100) / 12;

                // The period of the mortgage (in Years), Example: 25
                periodValue = Integer.parseInt(period.getText().toString());
                numberOfPayments = periodValue * 12;

                //The equation for calculating the mortgage:
                result = (principalValue * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments)) / Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1;


                String resultAsCurrency = NumberFormat.getCurrencyInstance().format(result);

                answer.setText(resultAsCurrency);


            }
        });

    }
}

package my.margin.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView answer;
    EditText principal, annualIncome, period;
    Button button;

    float result;
    int principalValue, annualIncomeValue, periodValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer =  (TextView)findViewById(R.id.answer);

        principal = (EditText)findViewById(R.id.principal_input);

        annualIncome = (EditText)findViewById(R.id.annual_interest_input);

        period = (EditText)findViewById(R.id.period_input);

        button = (Button)findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                principalValue = Integer.parseInt(principal.getText().toString());

                annualIncomeValue = Integer.parseInt(annualIncome.getText().toString());

                periodValue = Integer.parseInt(period.getText().toString());


                result = principalValue + annualIncomeValue + periodValue;

                answer.setText(String.valueOf(result));

            }
        });

    }
}

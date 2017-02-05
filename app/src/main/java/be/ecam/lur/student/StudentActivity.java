package be.ecam.lur.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        TextView name = (TextView) findViewById(R.id.name);
        TextView matricule = (TextView) findViewById(R.id.matricule);
        TextView division = (TextView) findViewById(R.id.division);

        Intent intent = getIntent();
        Student student = Student.find(intent.getIntExtra(Intent.EXTRA_INDEX, 0));

        name.setText(student.getName());
        matricule.setText(student.getMatricule());
        division.setText(student.getDivision());
    }
}

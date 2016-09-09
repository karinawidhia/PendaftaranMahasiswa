package id.sch.smktelkom_mlg.tugas01.xirpl1015.pendaftaranmahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    RadioGroup rgJenis;
    Spinner spFakultas, spJurusan;
    String[][] arJurusan = {
            {"International Business Management", "International Business Accounting",},
            {"Information & Multimedia Technology", "Interior Architecture", "Visual Communication Design",
                    "Business Information Systems", "Fashion Design and Business"},
            {"Integrated Psychology & Entrepreneurship"},
            {"International Hospitality & Tourism Business", "Culinary Business"}
    };
    ArrayList<String> listJurusan = new ArrayList<>();
    ArrayAdapter<String> adapter;
    CheckBox cbSen, cbSel, cbRab, cbKam, cbJum, cbSab, cbMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        rgJenis = (RadioGroup) findViewById(R.id.jeniskel);
        spFakultas = (Spinner) findViewById(R.id.spinnerFakultas);
        spJurusan = (Spinner) findViewById(R.id.spinnerJurusan);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listJurusan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJurusan.setAdapter(adapter);

        cbSen = (CheckBox) findViewById(R.id.checkBoxSen);
        cbSel = (CheckBox) findViewById(R.id.checkBoxSel);
        cbRab = (CheckBox) findViewById(R.id.checkBoxRab);
        cbKam = (CheckBox) findViewById(R.id.checkBoxKam);
        cbJum = (CheckBox) findViewById(R.id.checkBoxJum);
        cbSab = (CheckBox) findViewById(R.id.checkBoxSab);
        cbMin = (CheckBox) findViewById(R.id.checkBoxMin);

        spFakultas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listJurusan.clear();
                listJurusan.addAll(Arrays.asList(arJurusan[pos]));
                adapter.notifyDataSetChanged();
                spJurusan.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

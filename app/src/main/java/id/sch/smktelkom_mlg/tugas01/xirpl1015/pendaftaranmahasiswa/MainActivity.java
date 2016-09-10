package id.sch.smktelkom_mlg.tugas01.xirpl1015.pendaftaranmahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etUmur;
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
    Button bOK;
    TextView tvNama, tvUmur, tvJK, tvfk, tvjr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etUmur = (EditText) findViewById(R.id.editTextUmur);
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

        bOK = (Button) findViewById(R.id.buttonOK);

        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvUmur = (TextView) findViewById(R.id.textViewUmur);
        tvJK = (TextView) findViewById(R.id.textViewJK);
        tvfk = (TextView) findViewById(R.id.textViewFakultas);
        tvjr = (TextView) findViewById(R.id.textViewJurusan);

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

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();
                doTekan();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int umur = Integer.parseInt(etUmur.getText().toString());
            tvNama.setText("Nama Lengkap    : " + nama);
            tvUmur.setText("Umur                : " + umur + " tahun");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String umur = etUmur.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (umur.isEmpty()) {
            etUmur.setError("Umur belum diisi");
            valid = false;
        } else if (umur.length() != 2) {
            etUmur.setError("Umur harus berisi 2 karakter");
            valid = false;
        } else {
            etUmur.setError(null);
        }

        return valid;
    }

    private void doClick() {
        String hasiljk = null;

        if (rgJenis.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgJenis.getCheckedRadioButtonId());
            hasiljk = rb.getText().toString();
        }

        if (hasiljk == null) {
            tvJK.setText("Jenis Kelamin     : Belum Dipilih");
        } else {
            tvJK.setText("Jenis Kelamin     : " + hasiljk);
        }
    }

    private void doTekan() {
        tvfk.setText("Fakultas              : " + spFakultas.getSelectedItem().toString());
        tvjr.setText("Jurusan               : " + spJurusan.getSelectedItem().toString());
    }
}

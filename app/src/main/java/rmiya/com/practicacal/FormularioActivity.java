package rmiya.com.practicacal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private String masa;
    private RadioGroup radioGroup;
    private int precio;
    private int incremento;
    private Spinner spinner1;
    private CheckBox checkBox, checkBox1;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        radioGroup = findViewById(R.id.radioGroup);

        spinner1 = findViewById(R.id.spinner);

        checkBox = findViewById(R.id.checkBox);

        checkBox1 = findViewById(R.id.checkBox1);

        edit = findViewById(R.id.direccion_1);


    }

    private int PrecioSpinner(){

        String text = spinner1.getSelectedItem().toString();

        switch (text) {
            case "Americana":
                precio = 38;
                break;
            case "Pepperoni":
                precio = 42;
                break;
            case "Hawaiana":
                precio = 36;
                break;
            case "Meat Lover":
                precio = 56;
                break;
        }

        return precio;
    }

    private int PrecioCheck() {

        if (checkBox.isChecked()) {
            incremento = 4;
        }
        if (checkBox1.isChecked()) {
            incremento = 8;
        }
        if (checkBox.isChecked() && checkBox1.isChecked()) {
            incremento = 12;
        }
        if (!checkBox.isChecked() && !checkBox1.isChecked()) {
            incremento = 0;
        }

        return incremento;
    }

    private String ValorRadio() {

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId == -1){
            masa = null;
        }
        else
        {
            RadioButton radioButton = findViewById(radioButtonId);
            masa = radioButton.getText().toString();
        }

        return masa;

    }


    public void enviar(View view) {

        int precio1 = PrecioSpinner();
        int incremento1 = PrecioCheck();
        String masa1 = ValorRadio();
        String direccion1 = edit.getText().toString();

        if(masa == null ){
            Toast.makeText(getApplicationContext(), "No seleccionó el tipo de masa", Toast.LENGTH_SHORT).show();
        } else {
            int suma = incremento1 + precio1;
            String text = spinner1.getSelectedItem().toString();

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Confirmacion");
            alertDialog.setMessage("Su pedido se está procensado:  " + "Una pizza " + text + ", con el tipo de masa: " + masa1 +
                    " con el precio añadido de " + incremento1 + " dando un total de: " + suma + ", que se sera enviada a: " + direccion1 );


            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            alertDialog.show();
        }

    }

}
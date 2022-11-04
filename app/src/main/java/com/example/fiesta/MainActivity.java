package com.example.fiesta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText jetpersonas,jetbotellas;
    TextView jtvvalor,jtvneto,jtvpropina;
    RadioButton jchvip,jchpalco,jchlaterales,jchaguardiente,jchron,jchwhisky,jchgeneral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        jetpersonas=findViewById(R.id.etpersonas);
        jetbotellas=findViewById(R.id.etbotellas);
        jtvpropina=findViewById(R.id.tvpropina);
        jtvvalor=findViewById(R.id.tvvalor);
        jtvneto=findViewById(R.id.tvneto);
        jchvip=findViewById(R.id.chvip);
        jchgeneral=findViewById(R.id.chgeneral);
        jchpalco=findViewById(R.id.chpalco);
        jchaguardiente=findViewById(R.id.chaguardiente);
        jchlaterales=findViewById(R.id.chlaterales);
        jchron=findViewById(R.id.chron);
        jchwhisky=findViewById(R.id.chwhisky);

    }
    public void Calcular_valor_neto(View view){
        String cantidad_personas=jetpersonas.getText().toString(),cantidad_botellas=jetbotellas.getText().toString();

        if (cantidad_personas.isEmpty()){
            Toast.makeText(this, "La cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
            jetpersonas.requestFocus();
        }
        else{
            int cantidad,botellas,entrada=0,propina,valor_neto,valor_botellas;
            cantidad=Integer.parseInt(cantidad_personas);
            botellas=Integer.parseInt(cantidad_botellas);
            if (cantidad <1){
                Toast.makeText(this, "La cantidad de personas debe ser mayor a 1", Toast.LENGTH_SHORT).show();
            }
            else{
                if (jchvip.isChecked()){
                    jtvvalor.setText("50000");
                    entrada=50000;

                }
                else{
                    if (jchpalco.isChecked()){
                        jtvvalor.setText("35000");
                        entrada=35000;
                    }
                    if(jchlaterales.isChecked()){
                       jtvvalor.setText("20000");
                       entrada=20000;
                    }
                    if (jchgeneral.isChecked()){
                        jtvvalor.setText("25000");
                        entrada=25000;
                    }
                }
                if (jchaguardiente.isChecked()){
                    valor_botellas=150000;
                }
                else{
                    if (jchwhisky.isChecked()){
                        valor_botellas=250000;
                    }
                    else{
                        valor_botellas=180000;
                    }

                }
                valor_neto=entrada*cantidad+valor_botellas*botellas;
                propina=valor_neto*10/100;
                jtvpropina.setText(String.valueOf(propina));
                jtvneto.setText(String.valueOf(valor_neto+propina));

            }


        }

    }
    public void Limpiar(View view){
        jchvip.setChecked(true);
        jchlaterales.setChecked(false);
        jchgeneral.setChecked(false);
        jchpalco.setChecked(false);
        jchaguardiente.setChecked(true);
        jchron.setChecked(false);
        jchwhisky.setChecked(false);
        jtvvalor.setText("50000");
        jtvneto.setText("Valor neto");
        jtvpropina.setText("Valor propina");
        jetpersonas.setText("Cantidad de personas");
        jetbotellas.setText("");

    }
}
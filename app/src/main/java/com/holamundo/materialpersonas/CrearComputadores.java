package com.holamundo.materialpersonas;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearComputadores extends AppCompatActivity {

    private Spinner cmbMarca;
    private Spinner cmbColor;
    private Spinner cmbTipo;
    private Spinner cmbSo;
    private EditText txtRam;
   // private Spinner Foto;
    private ArrayAdapter<String> adapter,adapter2,adapter3,adapter4;
    private String opcM[],opcCol[],opcT[],opcSo[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computadores);


        cmbMarca = findViewById(R.id.comboMarca);
        txtRam = findViewById(R.id.txtRam);
        cmbColor = findViewById(R.id.comboColor);
        cmbTipo = findViewById(R.id.comboTipo);
        cmbSo = findViewById(R.id.comboSo);

        opcM = this.getResources().getStringArray(R.array.marcas);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcM);
        cmbMarca.setAdapter(adapter);

        opcCol = this.getResources().getStringArray(R.array.colores);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcCol);
        cmbColor.setAdapter(adapter2);

        opcT = this.getResources().getStringArray(R.array.tipos);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcT);
        cmbTipo.setAdapter(adapter3);

        opcSo = this.getResources().getStringArray(R.array.sistemas);
        adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcSo);
        cmbSo.setAdapter(adapter4);

        fotos = new ArrayList<Integer>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

    }

    public void  guardar (View v){
        String id;
        int foto,mar,ra,col,tip,siste;
        id = Datos.getId();
        foto = Datos.fotoAleatoria(fotos);
        mar = cmbMarca.getSelectedItemPosition();
        ra = Integer.parseInt(txtRam.getText().toString());
        col = cmbColor.getSelectedItemPosition();
        tip = cmbTipo.getSelectedItemPosition();
        siste = cmbSo.getSelectedItemPosition();


        Computador c = new Computador (id,foto,mar,ra,col,tip,siste);
        c.guardar();

        Snackbar.make(v, getResources().getString(R.string.Mensaje_guardado_exitoso), Snackbar.LENGTH_LONG).setAction("Action", null).show();



    }

    public void limpiar (View v){
        limpiar();
    }


    public void limpiar(){
        txtRam.setText("");
        cmbMarca.setSelection(0);
        cmbColor.setSelection(0);
        cmbTipo.setSelection(0);
        cmbSo.setSelection(0);


    }

    public void onBackPressed(){
        finish();
        Intent i = new  Intent(CrearComputadores.this,Principal.class);
        startActivity(i);
    }


}

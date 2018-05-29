package com.holamundo.materialpersonas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputador extends AppCompatActivity {
    private TextView texMarca;
    private TextView texRam;
    private TextView texColor;
    private TextView texTipo;
    private TextView texSo;
    private String[] marcas,colores,tipos,sistemas;
    private ImageView fot;
    private String id;
    private int foto,marca,ram,color,tipo,so;
    private Intent i;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);
        texMarca = findViewById(R.id.texMarca);
        texRam = findViewById(R.id.texRam);
        texColor = findViewById(R.id.texTipo);
        texTipo = findViewById(R.id.texTipo);
        texSo = findViewById(R.id.texSo);
        fot = findViewById(R.id.fot);
        marcas = getResources().getStringArray(R.array.marcas);
        colores = getResources().getStringArray(R.array.colores);
        tipos = getResources().getStringArray(R.array.tipos);
        sistemas = getResources().getStringArray(R.array.sistemas);

        i = getIntent();
        bundle = i.getBundleExtra("datos");
        id = bundle.getString("id");
        foto = bundle.getInt("foto");
        marca = bundle.getInt("marca");
        ram = bundle.getInt("ram");
        color = bundle.getInt("color");
        tipo = bundle.getInt("tipo");
        so = bundle.getInt("so");


        texMarca.setText(marcas[marca]);
        texRam.setText(ram);
        texColor.setText(colores[color]);
        texTipo.setText(tipos[tipo]);
        texSo.setText(sistemas[so]);
        fot.setImageResource(foto);
    }

    public void eliminar (View v){
        String positivo,negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               Computador c = new Computador(id);
               c.eliminar();
               onBackPressed();
            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetalleComputador.this,Principal.class);
        startActivity(i);
    }
}

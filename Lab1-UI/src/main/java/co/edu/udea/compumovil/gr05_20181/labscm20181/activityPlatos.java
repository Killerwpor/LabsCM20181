package co.edu.udea.compumovil.gr05_20181.labscm20181;

import android.Manifest;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.w3c.dom.Text;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

public class activityPlatos extends AppCompatActivity {

    private Menu menu;
    /*private ListView mostrarPlatos;
    private ArrayList <String> platosRegistrados;*/
    private Button botonGaleria, botonRegistrar;
    private NumberPicker pickerHorario;
    private EditText campoPrecio,campoNombre,campoIngredientes;
    ArrayList<Uri> selectedUriList;
    Uri selectedUri;
    private ViewGroup mSelectedImagesContainer;
    private ImageView iv_image;
    private TextView cuadroDatos;
    private RadioGroup grupoRadios;
    private RadioButton botonPlatoFuerte,botonEntrada;

    CheckBox rbm,rbt,rbn;
    public RequestManager mGlideRequestManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);
        /*platosRegistrados = new ArrayList<String>();
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, platosRegistrados);
        mostrarPlatos.setAdapter(arrayAdapter);*/
        botonGaleria= (Button) findViewById(R.id.botonGaleriaPlato);
        iv_image= (ImageView) findViewById(R.id.imageViewPlato);
        campoPrecio= (EditText) findViewById(R.id.editTextPrecioPlato);
        campoIngredientes= (EditText) findViewById(R.id.editTextIngredientesPlato);
        campoNombre= (EditText) findViewById(R.id.editTextNombrePlato);
        grupoRadios= (RadioGroup) findViewById(R.id.grupoRadios);
        //mGlideRequestManager = Glide.with(this);
        botonRegistrar= (Button) findViewById(R.id.botonRegistrar);
        pickerHorario= (NumberPicker) findViewById(R.id.numberPicker);
        rbt= (CheckBox) findViewById(R.id.tardeRb);
        rbm= (CheckBox) findViewById(R.id.mañanaRb);
        rbn= (CheckBox) findViewById(R.id.nocheRb);
        //cuadroDatos= (TextView) findViewById(R.id.mostrarDatos);
        botonEntrada= (RadioButton) findViewById(R.id.radioButton);
        botonPlatoFuerte= (RadioButton) findViewById(R.id.radioButton2);
        pickerHorario.setWrapSelectorWheel(true);
        rbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbn.setChecked(false);
                rbt.setChecked(false);
            }
        });

        rbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbm.setChecked(false);
                rbt.setChecked(false);
            }
        });

        rbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbm.setChecked(false);
                rbn.setChecked(false);
            }
        });

        botonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSingleShowButton();


            }
        });

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /*cuadroDatos.setText(cuadroDatos.getText()+"Nombre: "+campoNombre.getText()+"\n");
            cuadroDatos.setText(cuadroDatos.getText()+"Precio: "+campoPrecio.getText()+"\n");
            cuadroDatos.setText(cuadroDatos.getText()+"Ingredientes: "+campoIngredientes.getText()+"\n");
            if(botonEntrada.isSelected())
                cuadroDatos.setText(cuadroDatos.getText()+"Entrada\n");
            else
                cuadroDatos.setText(cuadroDatos.getText()+"Plato Fuerte\n");
            if(rbm.isChecked())
                cuadroDatos.setText(cuadroDatos.getText()+"Horario: "+"mañana\n");
            else if(rbn.isChecked())
                cuadroDatos.setText(cuadroDatos.getText()+"Horario: "+"noche\n");
            else if(rbt.isChecked())
                cuadroDatos.setText(cuadroDatos.getText()+"Horario: "+"tarde\n");*/

            /*platosRegistrados.add(campoNombre.getText().toString());
            Log.d("Platos registrados:", platosRegistrados.get(0));*/
        }
        });

    }







    private void setSingleShowButton() {





                PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {


                        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(activityPlatos.this)
                                .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                                    @Override
                                    public void onImageSelected(Uri uri) {
                                        Glide.with(activityPlatos.this)
                                                .load(uri)
                                                //.placeholder(R.drawable.img_error)
                                                .into(iv_image);
                                    }
                                })
                                .create();

                        tedBottomPicker.show(getSupportFragmentManager());


                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        Toast.makeText(activityPlatos.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    }


                };

                 TedPermission.with(activityPlatos.this)
                        .setPermissionListener(permissionlistener)
                        .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.INTERNET)
                        .check();

            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        menu.getItem(0).setVisible(false);
        menu.getItem(1).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcionMenu){
        int id = opcionMenu.getItemId();
        if(id == R.id.limpiar){

        } else if(id == R.id.salir){
            System.exit(1);
        } else if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return true;
    }

}

package cr.ac.unadeca.galeria.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import cr.ac.unadeca.galeria.R;
import cr.ac.unadeca.galeria.database.models.Imagenes;

public class DetalleActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private ViewPager viewPager;
    private ImageView imagen;
    private Imagenes mostrar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalleimagen);
        coordinatorLayout = findViewById(R.id.coordinador);
        viewPager = findViewById(R.id.viewpager);
        imagen = findViewById(R.id.imagen);

        if(getIntent().hasExtra("imagen")){
            mostrar = SQLite.select().from(Imagenes.class).querySingle();
            Glide.with(this).load(mostrar.imagen).error( Glide.with(this)
                    .load(R.mipmap.ic_launcher)).centerCrop().into(imagen);
        }
    }
}

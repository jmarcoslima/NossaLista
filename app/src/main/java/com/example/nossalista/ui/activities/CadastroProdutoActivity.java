package com.example.nossalista.ui.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.nossalista.R;
import com.example.nossalista.entidades.Produto;
import com.example.nossalista.dados.systemofaDAO.ProdutoDAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class CadastroProdutoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText nome;
    private ProdutoDAO dao;
    private ImageView fotoGaleria;
    private Button btCamera, btGaleria;
    private String imageUri;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        nome = findViewById(R.id.editNome);
        fotoGaleria = findViewById(R.id.fotoGaleria);
        btCamera = findViewById(R.id.btCamera);
        btGaleria = findViewById(R.id.btGaleria);
        fotoGaleria = findViewById(R.id.fotoGaleria);



        dao = new ProdutoDAO(this);
        fotos();

       spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorias_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void salvarProduto(View view) {
        Produto p = new Produto();
        p.setNome(nome.getText().toString());
        p.setCategoria(spinner.getSelectedItem().toString());
        //Evita nullPointer ao cadastrar sem imagem da galeria/camera
        if (imageUri != null) {
            p.setUri(imageUri);
        } else {
            p.setUri("0");
        }
        long id = dao.inserirProduto(p);
        Toast.makeText(this, "Produto inserido com id:" + id, Toast.LENGTH_SHORT).show();
    }

    public void fotos() {
        btCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(CadastroProdutoActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CadastroProdutoActivity.this, new String[]{Manifest.permission.CAMERA}, 0);
                } else {
                    tirarFoto();
                }
            }
        });
        btGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(CadastroProdutoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CadastroProdutoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                } else {
                    abrirGaleria();
                }
            }
        });

    }

    public void tirarFoto() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);
    }

    public void abrirGaleria() {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 2);

    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            fotoGaleria.setImageBitmap(imagem);
            // Chame este método pra obter a URI da imagem
            Uri uri = getImageUri(getApplicationContext(), imagem);
            // Em seguida chame este método para obter o caminho do arquivo
            File file = new File(getRealPathFromURI(uri));
            imageUri = file.getPath();
        }

        if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap myBitmap = BitmapFactory.decodeFile(picturePath);

            //Metodo que trás a imagem na rotação certa

            ExifInterface exif = null;
            try {
                File pictureFile = new File(picturePath);
                exif = new ExifInterface(pictureFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            int orientation = ExifInterface.ORIENTATION_NORMAL;
            if (exif != null)
                orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    myBitmap = rotateBitmap(myBitmap, 90);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    myBitmap = rotateBitmap(myBitmap, 180);
                    break;

                case ExifInterface.ORIENTATION_ROTATE_270:
                    myBitmap = rotateBitmap(myBitmap, 270);
                    break;
            }
            fotoGaleria.setImageBitmap(myBitmap);
            Uri uri = getImageUri(getApplicationContext(), myBitmap);
            // Em seguida chame este método para obter o caminho do arquivo
            File file = new File(getRealPathFromURI(uri));
            imageUri = file.getPath();
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        Bitmap reduzido = Bitmap.createScaledBitmap(inImage, 400, 400, true);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), reduzido, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
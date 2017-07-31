package com.example.admin.mytourguide;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //public Button mSendData;
    //private StorageReference mStorageRef;
    // private DatabaseReference mDatabaseRef;
    //private ImageView imageView;
    // private EditText txtImageName;
    //private Uri imgUri;


    //public static final String FB_STORAGE_PATH = "image/*";
    //public static final String FB_DATABSE_PATH = "image/*";
    //public static final int REQUEST_CODE = 1234;

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private TextView textViewCategory;
    //public Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        editTextEmail = (EditText) findViewById(R.id.editTextMAil);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);

        progressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
        textViewCategory.setOnClickListener(this);

        //button1=(Button)findViewById(R.id.hotels);
        //button1.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //Intent i= new Intent(MainActivity.this,HotelsFragment.class);
                //startActivity(i);
            //}
        //});


        //mStorageRef = FirebaseStorage.getInstance().getReference();
        //mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABSE_PATH);

        //imageView = (ImageView) findViewById(R.id.imageView);
        //txtImageName = (EditText) findViewById(R.id.txtImageName);


        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");

        //mSendData = (Button)findViewById(R.id.sendData);
        //mSendData.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {

        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering please wait");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //checking if successful
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Could not register,please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        }
        if (view == textViewSignup) {
            startActivity(new Intent(this, LoginActivity.class));

        }

        if (view == textViewSignup) {
            startActivity(new Intent(this, Categories.class));
        }

        if (view == textViewCategory) {
            startActivity(new Intent(this, UploadImage.class));
        }

        //if (view == textViewSignup) {
          //  startActivity(new Intent(MainActivity.this, unionBuildingsFragment.class));
        //}
        //if (view == textViewSignup) {
          //  startActivity(new Intent(MainActivity.this, gameReservesFragment.class));
        //}
        //if (view == textViewSignup) {
          //  startActivity(new Intent(MainActivity.this, shoppingMallsFragment.class));
        //}
        //if (view == textViewSignup) {
          //  startActivity(new Intent(MainActivity.this, HotelsFragment.class));
        //}

        //public void btnBrowse_click(View v) {
        //Intent intent = new Intent();
        //intent.setType("image/*");
        //intent.setAction(Intent.ACTION_GET_CONTENT);
        //startActivityForResult(Intent.createChooser(intent, "Select image"), REQUEST_CODE);
        //}

        //@Override
        //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
        //imgUri = data.getData();

        //try {
        //Bitmap bm = MediaStore.Images.Media.getBitmap(getContentResolver(), imgUri);
        //imageView.setImageBitmap(bm);
        //} catch (FileNotFoundException e) {
        // e.printStackTrace();
        //} catch (IOException e) {
        // }
        //}

        //});
        //}
        //}
        //public String getImageExt (Uri uri){
        //ContentResolver contentResolver = getContentResolver();
        //MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        //return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
        //}
        //@SuppressWarnings("VisibleForTests")
        //public void btnupload_click (View v){
        //if (imgUri!=null) {
        //final ProgressDialog dialog = new ProgressDialog(this);
        //dialog.setTitle("Uploading image");
        //dialog.show();

        //Get the storage reference
        //StorageReference ref = mStorageRef.child(FB_STORAGE_PATH + System.currentTimeMillis() + "." + getImageExt(imgUri));

        //Add file to reference
        //ref.putFile(imgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        //@Override
        // public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

        //Dismiss dialog when successfull
        //dialog.dismiss();

        //Display success toast message
        //Toast.makeText(getApplicationContext(),"Image Uploaded",Toast.LENGTH_SHORT).show();
        //ImageUpload imageUpload = new ImageUpload(txtImageName.getText().toString(),taskSnapshot.getDownloadUrl().toString());

        //Save image infor into firebase database
        //String uploadId = mDatabaseRef.push().getKey();
        //mDatabaseRef.child(uploadId).setValue(imageUpload);

        //}
        //})

        //.addOnFailureListener(new OnFailureListener() {
        //@Override
        //public void onFailure(@NonNull Exception e) {

        //Dismiss dialog when error
        //dialog.dismiss();

        //Display error toast message
        //Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        //}
        //})

        //.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

        //@Override
        //public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

        //Show upload progress
        //double progress = (100 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
        //dialog.setMessage("Uploaded" + (int)progress+"&");

        //}
        //});
        // }

        //else {
        //Toast.makeText(getApplicationContext(),"Please select image",Toast.LENGTH_SHORT).show();

        //}
//}
    }
}

package com.example.govtpolyamravati;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.io.File;
import java.io.IOException;

public class UserInfo extends AppCompatActivity  {

    private static final int CHOOSE_IMAGE = 101;
    private EditText userName, userGender, userID, userAge, userDept, userSem, userPassword, userEmail;
    private Button regButton;
    Uri uriProfileImage;
    FirebaseAuth mAuth;
    private ImageView userProfilePic;
    String profileImageUri;
    private StorageReference firebaseStorage;
    String Email,Password,Name,Gender,Id,DOB,Department,Semester;
    private DatabaseReference mDatabaseRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userName = (EditText) findViewById(R.id.Name);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userEmail = (EditText) findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btn);
        userGender = (EditText) findViewById(R.id.Gender);
        userID = (EditText) findViewById(R.id.ID);
        userDept = (EditText) findViewById(R.id.Department);
        userSem = (EditText) findViewById(R.id.Semester);
        userAge = (EditText) findViewById(R.id.DOB);
        userProfilePic = (ImageView) findViewById(R.id.ivProfile);
        //setupUIViews();

        mAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance().getReference("profilepics");

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("profilepics");


        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageChooser();

            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInformation();

            }
        });
    }

    private void saveUserInformation() {
      String displayName = userName.getText().toString();
      if (displayName.isEmpty()){
          userName.setError("Name Require");
          userName.requestFocus();
          return;
      }
      FirebaseUser user = mAuth.getCurrentUser();
      if (user!=null && profileImageUri!=null){
          UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder().setDisplayName(displayName).setPhotoUri(Uri.parse(profileImageUri)).build();
          user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                  if (task.isSuccessful()){
                      Toast.makeText(UserInfo.this,"Profile Updated",Toast.LENGTH_SHORT).show();

                      finish();
                      Intent intent = new Intent(UserInfo.this, Home.class);
                      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      startActivity(intent);
                  }
              }
          });
      }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==CHOOSE_IMAGE && resultCode==RESULT_OK && data!=null && data.getData()!=null ){

            uriProfileImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uriProfileImage);
                userProfilePic.setImageBitmap(bitmap);
                uploadImageToFirebaseStorage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImageToFirebaseStorage() {

          Email = userEmail.getText().toString().trim();
          Password = userPassword.getText().toString().trim();
          Name = userName.getText().toString().trim();
          Gender = userGender.getText().toString().trim();
          Id = userID.getText().toString().trim();
          DOB = userAge.getText().toString().trim();
          Department = userDept.getText().toString().trim();
          Semester = userSem.getText().toString().trim();

        final StorageReference profileImageRef = FirebaseStorage.getInstance().getReference("profilepics/"+System.currentTimeMillis() + ".jpg");
        if(uriProfileImage!=null){
            profileImageRef.putFile(uriProfileImage)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    profileImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            UserUpload upload = new UserUpload(Email,Password,Name,Gender,Id,DOB,Department,Semester,uriProfileImage);
                            String uploadID = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadID).setValue(upload);
                            Toast.makeText(UserInfo.this, "Upload successfully", Toast.LENGTH_LONG).show();


                        }
                    });


                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

            }
        }


    private void showImageChooser(){
      Intent intent = new Intent();
      intent.setType("image/*");
      intent.setAction(Intent.ACTION_GET_CONTENT);
      startActivityForResult(intent.createChooser(intent,"Select Profile Image"), CHOOSE_IMAGE);

        }


}


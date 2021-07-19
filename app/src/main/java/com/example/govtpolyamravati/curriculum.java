package com.example.govtpolyamravati;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class curriculum extends AppCompatActivity {

    TextView dwME,dwCE,dwEE,dwEXTC,dwCM,dwIF,dwPP;
    FirebaseStorage firebaseStorage;
    StorageReference storageRef;
    StorageReference ref;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);
        //storageRef = firebaseStorage.getReferenceFromUrl("gs://govtpolyamravatinew.appspot.com/curriculums");
        storageRef=FirebaseStorage.getInstance().getReference();



        dwME=(TextView) findViewById(R.id.dwnldME);
        dwCE=(TextView) findViewById(R.id.dwnldCE);
        dwEE=(TextView) findViewById(R.id.dwnldEE);
        dwEXTC=(TextView) findViewById(R.id.dwnldExtc);
        dwCM=(TextView) findViewById(R.id.dwnldCM);
        dwIF=(TextView) findViewById(R.id.dwnldIF);
        dwPP=(TextView) findViewById(R.id.dwnldPP);


        //For downloading the curriculum
        dwME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("Mech");
            }


        });

        dwCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("CE");
            }


        });
        dwEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("Electrical");
            }


        });
        dwEXTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("Electronics");
            }


        });
        dwCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("Comp");
            }


        });
        dwIF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("IT");
            }


        });
        dwPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download("PP");
            }


        });

    }
    public void download(String a) {

        if(a=="Mech"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");
            ref=storageRef.child("CDC_Mech_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_Mech_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        if(a=="CE"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");
            ref=storageRef.child("CDC_Civil_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_Civil_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        if(a=="Electrical"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");            ref=storageRef.child("CDC_Electrical_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_Electrical_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        if(a=="Electronics"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");            ref=storageRef.child("CDC_Electronics_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_Electronics_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        if(a=="Comp"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");            ref=storageRef.child("CDC_Comp_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_Comp_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        if(a=="IT"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");            ref=storageRef.child("CDC_IT_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_IT_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        if(a=="PP"){
            storageRef = firebaseStorage.getInstance().getReferenceFromUrl("gs://govtpolyamravati-aac1a.appspot.com/curriculum");            ref=storageRef.child("CDC_Plastic_Polymer_Curriculum.pdf");

            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String url=uri.toString();
                    downloadFile(curriculum.this,"CDC_Plastic_Polymer_Curriculum",".pdf",DIRECTORY_DOWNLOADS,url);
                    Toast.makeText(curriculum.this, "Downloading...", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

    }

    public long downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {


        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        return downloadmanager.enqueue(request);
    }


}

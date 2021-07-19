package com.example.govtpolyamravati;

import android.net.Uri;

public class UserUpload {
    private String imgEmail;
    private String imgPassword;
    private String imgName;
    private String imgGender;
    private String imgId;
    private String imgDOB;
    private String imgDepartment;
    private String imgSemester;


    private String uriProfileImage;


    public UserUpload(String imgEmail, String imgPassword, String imgName, String imgGender, String imgId, String imgDOB, String imgDepartment, String imgSemester, Uri uriProfileImage) {
    }

    public UserUpload(String imgEmail, String imgPassword, String imgName, String imgGender, String imgId, String imgDOB,
                      String imgDepartment, String imgSemester, String uriProfileImage) {

        this.imgEmail = imgEmail;
        this.imgPassword = imgPassword;
        this.imgName = imgName;
        this.imgGender = imgGender;
        this.imgId = imgId;
        this.imgDOB = imgDOB;
        this.imgDepartment = imgDepartment;
        this.imgSemester = imgSemester;
        this.uriProfileImage = uriProfileImage;
    }

    public String getImgEmail() {
        return imgEmail;
    }

    public void setImgEmail(String imgEmail) {
        this.imgEmail = imgEmail;
    }

    public String getImgPassword() {
        return imgPassword;
    }

    public void setImgPassword(String imgPassword) {
        this.imgPassword = imgPassword;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgGender() {
        return imgGender;
    }

    public void setImgGender(String imgGender) {
        this.imgGender = imgGender;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgDOB() {
        return imgDOB;
    }

    public void setImgDOB(String imgDOB) {
        this.imgDOB = imgDOB;
    }

    public String getImgDepartment() {
        return imgDepartment;
    }

    public void setImgDepartment(String imgDepartment) {
        this.imgDepartment = imgDepartment;
    }

    public String getImgSemester() {
        return imgSemester;
    }

    public void setImgSemester(String imgSemester) {
        this.imgSemester = imgSemester;
    }

    public String getUriProfileImage() {
        return uriProfileImage;
    }

    public void setUriProfileImage(String uriProfileImage) {
        this.uriProfileImage = uriProfileImage;
    }
}
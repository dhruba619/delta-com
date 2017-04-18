package com.ionic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addresses")
public class Address {
    @NotNull
    @Size(min = 1)
    @Id
    private String mobile;
    private String addTag;
    private String addLine;
    private String appart;
    @NotNull
    @Size(min = 1)
    private String area;
    @NotNull
    @Size(min = 1)
    private String city;
    @NotNull
    @Size(min = 1)
    private String state;
    @NotNull
    @Size(min = 1)
    private String pincode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddTag() {
        return addTag;
    }

    public void setAddTag(String addTag) {
        this.addTag = addTag;
    }

    public String getAddLine() {
        return addLine;
    }

    public void setAddLine(String addLine) {
        this.addLine = addLine;
    }

    public String getAppart() {
        return appart;
    }

    public void setAppart(String appart) {
        this.appart = appart;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}

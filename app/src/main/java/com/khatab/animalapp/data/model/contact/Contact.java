
package com.khatab.animalapp.data.model.contact;

import com.google.gson.annotations.SerializedName;


public class Contact {

    @SerializedName("data")
    private String mData;
    @SerializedName("error")
    private String mError;
    @SerializedName("status")
    private Boolean mStatus;

    public String getData() {
        return mData;
    }

    public void setData(String data) {
        mData = data;
    }

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}

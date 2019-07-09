
package com.khatab.animalapp.data.model.orders;

import com.google.gson.annotations.SerializedName;


public class Orders {

    @SerializedName("data")
    private Object mData;
    @SerializedName("error")
    private Object mError;
    @SerializedName("status")
    private Boolean mStatus;

    public Object getData() {
        return mData;
    }

    public void setData(Object data) {
        mData = data;
    }

    public Object getError() {
        return mError;
    }

    public void setError(Object error) {
        mError = error;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}

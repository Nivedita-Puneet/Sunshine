package com.nivedita.weatherutility.model.Network;

import com.google.gson.annotations.SerializedName;

public class JSONResponse {

    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public JSONResponse() {
    }

    public JSONResponse(String status) {
        this.status = status;
    }

}

package com.nivedita.sunshine.model.network;

import com.google.gson.annotations.SerializedName;

/**
 * Class defined to get JSON response.
 */

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

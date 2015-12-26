package com.pironix.document.model;

import java.io.Serializable;

/**
 * The Route class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * Route collection model
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class Route implements Serializable {
    /**
     * userId Linking for one to many relationships
     */
    private long userId;
    private long latitude;
    private long longitude;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    /**
     * override for create collection named route
     *
     * @return
     */
    @Override
    public String toString() {
        return "route";
    }
}

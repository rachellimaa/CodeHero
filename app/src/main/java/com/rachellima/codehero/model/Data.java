package com.rachellima.codehero.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("offset")
    private int mOffset;

    @SerializedName("limit")
    private int mLimit;

    @SerializedName("total")
    private int mTotal;

    @SerializedName("count")
    private int mCount;

    @SerializedName("results")
    private Result[] mResultList;

    public int getmOffset() {
        return mOffset;
    }

    public void setmOffset(int mOffset) {
        this.mOffset = mOffset;
    }

    public int getmLimit() {
        return mLimit;
    }

    public void setmLimit(int mLimit) {
        this.mLimit = mLimit;
    }

    public int getmTotal() {
        return mTotal;
    }

    public void setmTotal(int mTotal) {
        this.mTotal = mTotal;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public Result[] getResultList() {
        return mResultList;
    }

    public void setmResultList(Result[] mResultList) {
        this.mResultList = mResultList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "mOffset=" + mOffset +
                ", mLimit=" + mLimit +
                ", mTotal=" + mTotal +
                ", mCount=" + mCount +
                ", mResultList=" + mResultList +
                '}';
    }
}

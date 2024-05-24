package dev.n3shemmy3.kutamba.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
public class BaseModel implements Parcelable {
    public BaseModel(){}
    protected BaseModel(Parcel in) {
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    }
}

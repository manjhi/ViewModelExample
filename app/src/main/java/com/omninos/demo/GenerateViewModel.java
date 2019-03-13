package com.omninos.demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class GenerateViewModel extends ViewModel {

    private MutableLiveData<Integer> randomNumber = new MutableLiveData<>();

    public void SetNumber(int number) {
        randomNumber.setValue(number);
    }

    public LiveData<Integer> GetNumber() {
        return randomNumber;
    }
}

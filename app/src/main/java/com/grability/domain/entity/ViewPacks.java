package com.grability.domain.entity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rogerp91 on 19/01/17.
 */

public class ViewPacks {

    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    private View view;

    public ViewPacks(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View view) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        this.view = view;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public ViewGroup getContainer() {
        return container;
    }

    public void setContainer(ViewGroup container) {
        this.container = container;
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    public void setSavedInstanceState(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
package com.example.tsenaskolo_application.Models;

import com.example.tsenaskolo_application.Views.viewFactory;

public class Model {
    private static Model model;
    private final viewFactory viewFactory;

    private Model(){
        this.viewFactory = new viewFactory();
    }

    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public viewFactory getViewFactory() {
        return viewFactory;
    }
}

package com.webkype.happiroo.view;

public interface CommonListener {
    int CLICKED=100,CHECKED=101,EDIT=102,UPDATED=103,DELETED=104;
    int NOT_LOGGED = 500;
    int REPLACED = 600;
    int DELETE = 655;

    void onClicked(int position,int action);
}

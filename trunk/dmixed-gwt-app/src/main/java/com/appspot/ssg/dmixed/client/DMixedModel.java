package com.appspot.ssg.dmixed.client;

import com.appspot.ssg.dmixed.shared.ITermine;
import com.appspot.ssg.dmixed.shared.IUserData;

public class DMixedModel {

    private IUserData _user;
    private ITermine _termine;

    public void setUser(IUserData user) {
        _user = user;
    }

    public IUserData getUser() {
        return _user;
    }

    public void setTermine(ITermine termine) {
        _termine = termine;
    }

    public ITermine getTermine() {
        return _termine;
    }

}

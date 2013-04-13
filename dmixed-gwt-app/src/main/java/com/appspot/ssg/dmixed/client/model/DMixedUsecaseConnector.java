package com.appspot.ssg.dmixed.client.model;

import com.appspot.ssg.dmixed.shared.IAsync;
import com.appspot.ssg.dmixed.shared.IDMixedUsecase;
import com.appspot.ssg.dmixed.shared.ILoginData;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.appspot.ssg.dmixed.shared.IUserData;

public class DMixedUsecaseConnector implements IDMixedUsecase {

    @Override
    public void login(ILoginData data, IAsync<IUserData> answer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void termine(Long userId, IAsync<ITermine> answer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void termin(Long userId, Long terminId, IAsync<ITerminDetails> answer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void teilname(Long userId, Long terminId, Boolean teilnahme, IAsync<ITerminDetails> answer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mitringen(Long userId, Long terminId, Long mitbringId, Boolean mitbringen, IAsync<ITerminDetails> answer) {
        // TODO Auto-generated method stub

    }

}

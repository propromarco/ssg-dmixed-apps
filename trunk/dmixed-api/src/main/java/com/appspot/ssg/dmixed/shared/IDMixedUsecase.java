package com.appspot.ssg.dmixed.shared;

public interface IDMixedUsecase {
    void login(ILoginData data, IAsync<IUserData> answer);
}

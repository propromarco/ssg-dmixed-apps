package com.appspot.ssg.dmixed.shared;

public interface IDMixedUsecase {
    void login(ILoginData data, IAsync<IUserData> answer);

    void getTermine(Long userId, IAsync<ITermine> answer);

    void getTermin(Long userId, Long terminId, IAsync<ITerminDetails> answer);

    void onTeilnahme(ITeilnahmeData teilnahmeData, IAsync<Void> answer);

    void onMitringen(IMitbringData mitbringData, IAsync<Void> answer);
    
    void newUser(IUserData userData, IAsync<Void> answer);

    void deleteUser(IUserData userData, IAsync<Void> answer);
}

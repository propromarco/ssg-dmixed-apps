package com.appspot.ssg.dmixed.shared;

public interface IDMixedUsecase {
    void login(ILoginData data, IAsync<IUserData> answer);

    void getTermine(Long userId, IAsync<ITermine> answer);

    void getTermin(Long userId, Long terminId, IAsync<ITerminDetails> answer);

    void onTeilnahme(ITeilnahmeData teilnahmeData, IAsync<Void> answer);

    void onMitbringen(IMitbringData mitbringData, IAsync<Void> answer);

    void getUsers(Long userId, IAsync<IUsers> answer);

    void newUser(Long userId, IUserData userData, IAsync<Void> answer);

    void deleteUser(Long userId, IUserData userData, IAsync<Void> answer);

    void createTermin(Long userId, ITerminCreate termineCreate, IAsync<ITerminDetails> answer);

    void saveTermin(Long userId, ITerminDetails terminDetails, IAsync<Void> answer);

}

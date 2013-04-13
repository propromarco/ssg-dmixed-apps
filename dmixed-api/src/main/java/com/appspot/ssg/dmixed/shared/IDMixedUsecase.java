package com.appspot.ssg.dmixed.shared;

public interface IDMixedUsecase {
    void login(ILoginData data, IAsync<IUserData> answer);

    void termine(Long userId, IAsync<ITermine> answer);

    void termin(Long userId, Long terminId, IAsync<ITerminDetails> answer);

    void teilname(Long userId, Long terminId, Boolean teilnahme, IAsync<ITerminDetails> answer);

    void mitringen(Long userId, Long terminId, Long mitbringId, Boolean mitbringen, IAsync<ITerminDetails> answer);
}

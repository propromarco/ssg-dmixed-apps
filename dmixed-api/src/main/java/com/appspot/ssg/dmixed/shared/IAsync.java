package com.appspot.ssg.dmixed.shared;

public interface IAsync<T> {
    void onSuccess(T t);

    void onError(Throwable exception);
}

package com.appspot.ssg.dmixed.shared;

public final class DMixedUrlCreator {
    
    private final String _baseUrl;

    public DMixedUrlCreator(final String baseUrl) {
	this._baseUrl = baseUrl;
    }

    protected String getServiceUrl() {
	final String url = _baseUrl + "rest/dmixed";
	return url;
    }

    public String getLoginUrl() {
	final String url = getServiceUrl();
	return url;
    }

    public String getTermineUrl(final Long userId) {
	final String url = getServiceUrl() + "/termine/" + userId;
	return url;
    }

    public String getTerminUrl(final Long userId, final Long terminId) {
	final String url = getServiceUrl() + "/termin/" + userId + "/" + terminId;
	return url;
    }

    public String getOnTeilnahmeUrl() {
	final String url = getServiceUrl() + "/teilnahme";
	return url;
    }

    public String getOnMitringenUrl() {
	final String url = getServiceUrl() + "/mitbringen";
	return url;
    }

    public String getUsersUrl(final Long userId) {
	final String url = getServiceUrl() + "/users/" + userId;
	return url;
    }

    public String getNewUserUrl() {
	final String url = getServiceUrl() + "/user";
	return url;
    }

    public String getDeleteUserUrl() {
	final String url = getServiceUrl() + "/user";
	return url;
    }
}

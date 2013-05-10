package com.appspot.ssg.dmixed.shared;

public final class DMixedUrlCreator {

    public static final String SERVICE_URL = "rest";
    public static final String NORMAL_CLIENT_URL = "dmixed";
    public static final String TERMINE_URL = "termine";
    public static final String TERMIN_URL = "termin";
    public static final String TEILNAHME_URL = "teilnahme";
    public static final String MITBRINGEN_URL = "mitbringen";
    public static final String USERS_URL = "users";
    public static final String USER_URL = "user";
    public static final String TERMINADMIN_URL = "terminadmin";
    public static final String LIGEN_URL = "ligen";

    private final String _baseUrl;

    public DMixedUrlCreator(final String baseUrl) {
	this._baseUrl = baseUrl;
    }

    protected String getServiceUrl() {
	final String url = _baseUrl + SERVICE_URL + "/" + NORMAL_CLIENT_URL;
	return url;
    }

    public String getLoginUrl() {
	final String url = getServiceUrl();
	return url;
    }

    public String getTermineUrl(final Long userId) {
	final String url = getServiceUrl() + "/" + TERMINE_URL + "/" + userId;
	return url;
    }

    public String getTerminUrl(final Long userId, final Long terminId) {
	final String url = getServiceUrl() + "/" + TERMIN_URL + "/" + userId + "/" + terminId;
	return url;
    }

    public String getOnTeilnahmeUrl() {
	final String url = getServiceUrl() + "/" + TEILNAHME_URL;
	return url;
    }

    public String getOnMitringenUrl() {
	final String url = getServiceUrl() + "/" + MITBRINGEN_URL;
	return url;
    }

    public String getUsersUrl(final Long userId) {
	final String url = getServiceUrl() + "/" + USERS_URL + "/" + userId;
	return url;
    }

    public String getNewUserUrl() {
	final String url = getServiceUrl() + "/" + USER_URL;
	return url;
    }

    public String getDeleteUserUrl() {
	final String url = getServiceUrl() + "/" + USER_URL;
	return url;
    }

    public String getCreateTerminUrl(final long userid) {
	final String url = getServiceUrl() + "/" + TERMINADMIN_URL + "/" + userid;
	return url;
    }

    public String getSaveTerminUrl(final Long userId) {
	final String url = getServiceUrl() + "/" + TERMINADMIN_URL + "/" + userId;
	return url;
    }

    public String getLiegenUrl(final Long userId) {
	final String url = getServiceUrl() + "/" + LIGEN_URL + "/" + userId;
	return url;
    }

}

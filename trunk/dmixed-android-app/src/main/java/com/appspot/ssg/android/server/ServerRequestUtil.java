package com.appspot.ssg.android.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import com.appspot.ssg.android.data.LoginData;
import com.appspot.ssg.android.data.MitbringData;
import com.appspot.ssg.android.data.TeilnahmeData;
import com.appspot.ssg.android.data.TerminDetails;
import com.appspot.ssg.android.data.Termine;
import com.appspot.ssg.android.data.UserData;
import com.appspot.ssg.dmixed.shared.DMixedUrlCreator;
import com.appspot.ssg.dmixed.shared.ETeilnahmeStatus;
import com.appspot.ssg.dmixed.shared.ITermin;
import com.appspot.ssg.dmixed.shared.ITerminDetails;
import com.appspot.ssg.dmixed.shared.ITermine;
import com.appspot.ssg.dmixed.shared.IUserData;
import com.google.gson.Gson;

public class ServerRequestUtil {

	private final DMixedUrlCreator urlCreator = new DMixedUrlCreator(
			"http://ssg-hockey.appspot.com/");

	public ServerRequestUtil() {
	}

	private enum HTTP_TYPE {
		POST, PUT, GET
	}

	public IUserData login(final String username, final String mail)
			throws ServerRequestException {
		final LoginData loginData = new LoginData();
		loginData.setEmail(mail.trim());
		loginData.setVorname(username.trim());
		final String loginUrl = urlCreator.getLoginUrl();
		final String json = call(loginData, loginUrl, HTTP_TYPE.POST);
		final IUserData fromJson = createObject(json, UserData.class);
		return fromJson;
	}

	public List<ITermin> getTermine(final long userId) throws ServerRequestException {
		final String termineUrl = urlCreator.getTermineUrl(userId);
		final String json = call(null, termineUrl, HTTP_TYPE.GET);
		final ITermine fromJson = createObject(json, Termine.class);
		return fromJson.getAll();
	}

	public ITerminDetails getTerminDetails(final long userId, final long terminId)
			throws ServerRequestException {
		final String terminUrl = urlCreator.getTerminUrl(userId, terminId);
		final String json = call(null, terminUrl, HTTP_TYPE.GET);
		final ITerminDetails fromJson = createObject(json, TerminDetails.class);
		return fromJson;
	}

	private <T> T createObject(final String json, final Class<T> clazz)
			throws ServerRequestException {
		try {
			final T fromJson = new Gson().fromJson(json, clazz);
			return fromJson;
		} catch (final Throwable e) {
			throw new ServerRequestException(
					"Fehler beim Konvertieren der Daten vom Server\n" + json
							+ "\n" + e.getMessage());
		}
	}

	public ITerminDetails createTermin(final long userId, final boolean heimspiel)
			throws ServerRequestException {
		final String createTerminUrl = urlCreator.getCreateTerminUrl(userId,
				heimspiel);
		final String json = call(null, createTerminUrl, HTTP_TYPE.GET);
		final TerminDetails details = createObject(json, TerminDetails.class);
		return details;
	}

	public long createUser(final boolean admin, final String name, final String vorname,
			final String mail, final Long birthday) throws ServerRequestException {
		final String newUserUrl = urlCreator.getNewUserUrl();
		final UserData data = new UserData();
		data.setAdmin(admin);
		data.setName(name);
//		data.setVorname(vorname);
		data.setEmail(mail);
//		data.setBirthday(birthday);
		final String result = call(data, newUserUrl, HTTP_TYPE.POST);
		try {
			return Long.getLong(result);
		} catch (final Exception e) {
			throw new ServerRequestException(result);
		}
	}

	public void setTeilnahme(final ETeilnahmeStatus teilnahme, final long terminId,
			final long userId) throws ServerRequestException {
		final TeilnahmeData teilnahmeData = new TeilnahmeData();
		teilnahmeData.setTeilnahme(teilnahme);
		teilnahmeData.setTerminId(terminId);
		teilnahmeData.setId(userId);
		final String onTeilnahmeUrl = urlCreator.getOnTeilnahmeUrl();
		call(teilnahmeData, onTeilnahmeUrl, HTTP_TYPE.PUT);
	}

	public void addMitbringsel(final long userId, final long terminId, final boolean teilnahme,
			final long mitbringselId, final boolean mitbringen)
			throws ServerRequestException {
		final MitbringData mitbringData = new MitbringData();
		mitbringData.setMitbringen(mitbringen);
		mitbringData.setMitbringselId(mitbringselId);
		mitbringData.setTerminId(terminId);
		mitbringData.setId(userId);
		final String onMitringenUrl = urlCreator.getOnMitringenUrl();
		call(mitbringData, onMitringenUrl, HTTP_TYPE.PUT);
	}

	public void deleteUser(final long userId) throws ServerRequestException {
		final String deleteUserUrl = urlCreator.getDeleteUserUrl();
		call(userId, deleteUserUrl, HTTP_TYPE.PUT);
	}

	public void updateTermin(final long userId, final ITerminDetails terminDetails) throws ServerRequestException {
		final String saveTerminUrl = urlCreator.getSaveTerminUrl(userId);
		call(terminDetails, saveTerminUrl, HTTP_TYPE.PUT);
	}

	private String call(final Object postObject, final String url, final HTTP_TYPE type)
			throws ServerRequestException {
		final HttpParams p = new BasicHttpParams();
		// p.setParameter("name", pvo.getName());

		// Instantiate an HttpClient
		final HttpClient client = new DefaultHttpClient(p);

		final ObjectInputStream ois = null;
		// Instantiate a GET HTTP method
		try {
			HttpResponse response;
			switch (type) {
			case GET:
				final HttpGet get = new HttpGet(url);
				response = client.execute(get);
				break;
			case POST: {
				final HttpPost post = new HttpPost(url);
				post.setHeader("Content-Type", "application/json");
				final String json = new Gson().toJson(postObject);
				final StringEntity stringEntity = new StringEntity(json);
				post.setEntity(stringEntity);
				response = client.execute(post);
				break;
			}
			case PUT: {
				final HttpPut put = new HttpPut(url);
				put.setHeader("Content-Type", "application/json");
				final String json = new Gson().toJson(postObject);
				final StringEntity stringEntity = new StringEntity(json);
				put.setEntity(stringEntity);
				response = client.execute(put);
				return "OK";
			}
			default:
				return null;
			}
			if (response.getStatusLine().getStatusCode() != 200)
				throw new ServerRequestException(response.getStatusLine()
						.getReasonPhrase());
			final InputStream is = response.getEntity().getContent();
			final InputStreamReader isr = new InputStreamReader(is);
			final StringBuilder result = new StringBuilder();
			int read;
			final char[] buff = new char[1024];
			while ((read = isr.read(buff)) != -1) {
				result.append(buff, 0, read);
			}
			isr.close();
			return result.toString();
			// You can convert inputstream to a string with:
			// http://senior.ceng.metu.edu.tr/2009/praeda/2009/01/11/a-simple-restful-client-at-android/
		} catch (final Exception e) {
			throw new ServerRequestException(e.getMessage());
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
		}
	}

}

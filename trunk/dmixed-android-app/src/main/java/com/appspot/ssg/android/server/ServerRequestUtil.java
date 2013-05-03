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
			"http://ssg-dmixed.appspot.com/");

	public ServerRequestUtil() {
	}

	private enum HTTP_TYPE {
		POST, PUT, GET
	}

	public IUserData login(String username, String mail)
			throws ServerRequestException {
		final LoginData loginData = new LoginData();
		loginData.setEmail(mail.trim());
		loginData.setVorname(username.trim());
		final String loginUrl = urlCreator.getLoginUrl();
		final String json = call(loginData, loginUrl, HTTP_TYPE.POST);
		final IUserData fromJson = createObject(json, UserData.class);
		return fromJson;
	}

	public List<ITermin> getTermine(long userId) throws ServerRequestException {
		final String termineUrl = urlCreator.getTermineUrl(userId);
		final String json = call(null, termineUrl, HTTP_TYPE.GET);
		final ITermine fromJson = createObject(json, Termine.class);
		return fromJson.getAll();
	}

	public ITerminDetails getTerminDetails(long userId, long terminId)
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
		} catch (Throwable e) {
			throw new ServerRequestException(
					"Fehler beim Konvertieren der Daten vom Server\n" + json
							+ "\n" + e.getMessage());
		}
	}

	public void setTeilnahme(ETeilnahmeStatus teilnahme, long terminId,
			long userId) throws ServerRequestException {
		final TeilnahmeData teilnahmeData = new TeilnahmeData();
		teilnahmeData.setTeilnahme(teilnahme);
		teilnahmeData.setTerminId(terminId);
		teilnahmeData.setUserId(userId);
		final String onTeilnahmeUrl = urlCreator.getOnTeilnahmeUrl();
		call(teilnahmeData, onTeilnahmeUrl, HTTP_TYPE.PUT);
	}

	public void addMitbringsel(long userId, long terminId, boolean teilnahme,
			long mitbringselId, boolean mitbringen)
			throws ServerRequestException {
		final MitbringData mitbringData = new MitbringData();
		mitbringData.setMitbringen(mitbringen);
		mitbringData.setMitbringselId(mitbringselId);
		mitbringData.setTerminId(terminId);
		mitbringData.setUserId(userId);
		final String onMitringenUrl = urlCreator.getOnMitringenUrl();
		call(mitbringData, onMitringenUrl, HTTP_TYPE.PUT);
	}

	private String call(Object postObject, String url, HTTP_TYPE type)
			throws ServerRequestException {
		HttpParams p = new BasicHttpParams();
		// p.setParameter("name", pvo.getName());

		// Instantiate an HttpClient
		HttpClient client = new DefaultHttpClient(p);

		ObjectInputStream ois = null;
		// Instantiate a GET HTTP method
		try {
			HttpResponse response;
			switch (type) {
			case GET:
				HttpGet get = new HttpGet(url);
				response = client.execute(get);
				break;
			case POST: {
				HttpPost post = new HttpPost(url);
				post.setHeader("Content-Type", "application/json");
				final String json = new Gson().toJson(postObject);
				final StringEntity stringEntity = new StringEntity(json);
				post.setEntity(stringEntity);
				response = client.execute(post);
				break;
			}
			case PUT: {
				HttpPut put = new HttpPut(url);
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
			InputStream is = response.getEntity().getContent();
			final InputStreamReader isr = new InputStreamReader(is);
			final StringBuilder result = new StringBuilder();
			int read;
			char[] buff = new char[1024];
			while ((read = isr.read(buff)) != -1) {
				result.append(buff, 0, read);
			}
			isr.close();
			return result.toString();
			// You can convert inputstream to a string with:
			// http://senior.ceng.metu.edu.tr/2009/praeda/2009/01/11/a-simple-restful-client-at-android/
		} catch (Exception e) {
			throw new ServerRequestException(e.getMessage());
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}

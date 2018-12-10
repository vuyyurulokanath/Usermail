package com.prpl.login.Example2;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;

public class OAuthTwoCallBackServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

private static String client_id = "895498929378-4uohdps8sb5v6jp8saf0rea73c0h87nr.apps.googleusercontent.com";
private static String client_secret = "LsIy_r4-S22jGwGJkbNeYQ1H";
private static String redirectURL = "http://localhost:8080/TestProject/callback";
private String auth_code = null;

public void doGet(HttpServletRequest req, HttpServletResponse resp)
throws IOException {

System.out.println("Callback to URI that is configured in Google API Console");
resp.setContentType("text/html");
resp.getWriter().println("");
resp.getWriter().println("");
resp.getWriter().println("Top of Form");

//Bottom of Form

if (req.getParameter("code") == null) {

if (req.getParameter("error") != null) {
resp.getWriter().println("Hello, " + req.getParameter("error"));
} else {

resp.getWriter().println("");
resp.getWriter().println("");
resp.getWriter().println("");
resp.getWriter().println("");
resp.getWriter().println("Hello");
resp.getWriter().println("To login with Google Account click here ");
resp.getWriter().println("");
resp.getWriter().println(" alt='Powered by Google App Engine' />");
resp.getWriter().println(""); 
resp.getWriter().println("");
}
} else {
resp.getWriter().println("Code");
resp.getWriter().println("Authentication Code = " + req.getParameter("code"));
this.auth_code = req.getParameter("code");

// Exchange the code for token
HttpClient httpclient = new HttpClient();
BufferedReader bufferedreader = null;
PostMethod postmethod = new PostMethod(
"https://accounts.google.com/o/oauth2/token");
postmethod.addParameter("code", auth_code);
postmethod.addParameter("client_id", client_id);
postmethod.addParameter("client_secret", client_secret);
postmethod.addParameter("redirect_uri", redirectURL);
postmethod.addParameter("grant_type", "authorization_code");
String access_token = null;
String token_type = null;
int expires_in = 0;
String id_token = null;
try {

int rCode = httpclient.executeMethod(postmethod);
System.out.println("HTTP POST for Token rCode is" + rCode);

if (rCode == HttpStatus.SC_NOT_IMPLEMENTED) {
System.err.println("The Post postmethod is not implemented by this URI");
postmethod.getResponseBodyAsString();
} else if (rCode == HttpStatus.SC_NOT_ACCEPTABLE) {
System.out.println(postmethod.getResponseBodyAsString());
} else {

String jsonTxt = IOUtils.toString(postmethod
.getResponseBodyAsStream());

JSONObject json = (JSONObject) JSONSerializer
.toJSON(jsonTxt);

access_token = json.getString("access_token");
token_type = json.getString("token_type");
expires_in = json.getInt("expires_in");
id_token = json.getString("id_token");
System.out.println("======== TOKEN INFO ========");
System.out.println("access_token: " + access_token);
System.out.println("token_type: " + token_type);
System.out.println("expires_in: " + expires_in);
System.out.println("id_token: " + id_token);
System.out.println("=========================");
resp.getWriter().println("Token & Refresh");
resp.getWriter().println("Access Token = " + access_token);
resp.getWriter().println("Refresh Token = " + id_token);
resp.getWriter().println("Expire Time (Seconds) = " + expires_in);
resp.getWriter().println("Token Type = " + token_type);
}
} catch (Exception e) {
System.err.println(e);
} finally {
postmethod.releaseConnection();
if (bufferedreader != null)
try {
bufferedreader.close();
} catch (Exception fe) {
fe.printStackTrace();
}
}

//Calling Google account info API
User user = null;
httpclient = new HttpClient();
bufferedreader = null;
GetMethod getmethod = new GetMethod("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + access_token);
try {
int rCode = httpclient.executeMethod(getmethod);
System.out.println("HTTP GET for User rCode is" + rCode);

if (rCode == HttpStatus.SC_NOT_IMPLEMENTED) {
System.err
.println("The Get method is not implemented by this URI");
getmethod.getResponseBodyAsString();
} else if (rCode == HttpStatus.SC_NOT_ACCEPTABLE) {
System.out.println(getmethod.getResponseBodyAsString());
} else {

String jsonTxt = IOUtils.toString(getmethod
.getResponseBodyAsStream());
JSONObject json = (JSONObject) JSONSerializer
.toJSON(jsonTxt);

user = new User();
user.id = json.getString("id");
user.name = json.getString("name");
user.email = json.getString("email");
user.picture = json.getString("picture");
user.gender = json.getString("gender");
user.locale = json.getString("locale");

System.out.println("============ TOKEN INFO ===============");
System.out.println("id: " + user.id);
System.out.println("name: " + user.name);
System.out.println("Gender: " + user.gender);
System.out.println("email: " + user.email);
System.out.println("pictureURL: " + user.picture);
System.out.println("Locale: " + user.locale);
System.out.println("====================================");
}
} catch (Exception e) {
System.err.println(e);
} finally {
postmethod.releaseConnection();
if (bufferedreader != null)
try {
bufferedreader.close();
} catch (Exception fe) {
fe.printStackTrace();
}
}

// Get User Information
//resp.setContentType("text/html");
resp.getWriter().println("User Information");
resp.getWriter().println("");

//Property	Data
resp.getWriter().println("Id" + user.getId()+ "");
resp.getWriter().println("Name" + user.getName()+ "");
resp.getWriter().println("Email" + user.getEmail()+ "");
resp.getWriter().println("Gender" + user.getGender()+ "");
resp.getWriter().println("Image");
resp.getWriter().println("Locale" + user.getLocale()+ "");
resp.getWriter().println("");
}
}
}

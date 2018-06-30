package utils;

import beans.UserAccount;

import javax.servlet.ServletRequest;
import javax.servlet.http.*;
import java.sql.Connection;

public class MyUtils {

    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    public static final String ATT_NAME_USERNAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    //Store connection in request attribute
    //(information store only exist during requests)
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }

    //Get the connetion objet hase been in attribute of the request
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);

        return conn;
    }

    //store user info in Session
    public static void storeLoginedUser(HttpSession session, UserAccount loginedUser){
        //on the JSP can access via ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    //get the user informaion stored in the session.
    public static UserAccount getLoginedUser(HttpSession session) {
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        return loginedUser;
    }

    //Store info in coockie
    public static void storeUserCoockie(HttpServletResponse response, UserAccount user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_CONNECTION, user.getUserName());
        //1 day(Converted to seconds
        cookieUserName.setMaxAge(24*60*60);
        response.addCookie(cookieUserName);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(ATT_NAME_USERNAME.equals(cookie.getName())) {
                    return  cookie.getValue();
                }
            }
        }
        return null;
    }

    //Delete cookie
    public static void deleteUserNameCookie(HttpServletResponse response){
        Cookie cookieUserName = new Cookie(ATT_NAME_USERNAME, null);
        //0 seconds(This cookie will expire immediately)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}

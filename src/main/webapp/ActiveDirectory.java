package main.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

@Controller
public class ActiveDirectory {

    static String LDAP_SERVER_URL = "ldap://ldap.forumsys.com:389";
    static String USER_CONTEXT = "dc=example,dc=com";

    @RequestMapping(value = "/commandStartGetAD", method = RequestMethod.POST)
    @ResponseBody
    public static String getUsers(@RequestParam(value = "ajaxcommand", required = false) String commandtext) {
        System.out.println(commandtext);
        return verifyUser(commandtext, "password");
        //   verifyUser("gauss", "password");

    }

    public static String verifyUser(String userName, String password) {
        DirContext ctx = null;
        try {
            // creating environment for initial context
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, LDAP_SERVER_URL);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, "uid=" + userName + "," + USER_CONTEXT);
            env.put(Context.SECURITY_CREDENTIALS, password);

            // Create the initial context
            ctx = new InitialDirContext(env);
            System.out.println("Authenticated: " + (ctx != null));

            // get more attributes about this user
            SearchControls scs = new SearchControls();
            scs.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String[] attrNames = {"mail", "cn"};
            scs.setReturningAttributes(attrNames);

            NamingEnumeration nes = ctx.search(USER_CONTEXT, "uid=" + userName, scs);
            if (nes.hasMore()) {
                Attributes attrs = ((SearchResult) nes.next()).getAttributes();
                System.out.println("mail: " + attrs.get("mail").get());
                System.out.println("cn: " + attrs.get("cn").get());
                return attrs.get("cn").get() + ":" + ":" + ":" + attrs.get("mail").get();
            }
        } catch (NamingException e) {
            e.printStackTrace();
            return e.toString();

        } finally {
            if (ctx != null)
                try {
                    ctx.close();
                } catch (NamingException ex) {
                }


        }
        return "test AD";
    }

}

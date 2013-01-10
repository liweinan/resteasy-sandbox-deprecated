package net.bluedash.resteasy;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 01 10 2013
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Stateless
public class UserEndpointBean implements UserEndpoint {

    @EJB
    UserService userService;

    public List<User> list() {
        userService.sayHello();
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        return new ArrayList<User>(Arrays.asList(user));
    }


}

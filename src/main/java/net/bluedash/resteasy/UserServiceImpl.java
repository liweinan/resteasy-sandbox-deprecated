package net.bluedash.resteasy;

import javax.ejb.Stateless;

/**
 * 01 10 2013
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@Stateless
public class UserServiceImpl implements UserService {
    public void sayHello() {
        System.out.println("sayHello()");
    }
}

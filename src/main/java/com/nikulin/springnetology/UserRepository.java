package com.nikulin.springnetology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private Map <String, List<Authorities>> users = new HashMap<>();

    public UserRepository () {
        List<Authorities> admin = new ArrayList<>();
        admin.add(Authorities.WRITE);
        admin.add(Authorities.DELETE);
        admin.add(Authorities.READ);

        this.users.put("Admin_12345", admin);

        List<Authorities> readOnly = new ArrayList<>();
        readOnly.add(Authorities.READ);

        this.users.put("BanUser_111", readOnly);

        List<Authorities> user = new ArrayList<>();
        user.add(Authorities.WRITE);
        user.add(Authorities.READ);

        this.users.put("User123_123", user);

    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user + "_" + password)) {
            return users.get(user + "_" + password);
        }
        return null;
    }
}

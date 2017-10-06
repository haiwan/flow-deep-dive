package com.vaadin.flow.demo.helloworld.user;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class UserService {


	private static final Map<String, User> users = new LinkedHashMap<>();


	static {
		IntStream.range(0, 20).forEach(
				nbr -> {
					User user = new User("FirstName" + nbr, "LastName" + nbr, "Email" + nbr);
					users.put(user.getUuid(), user);
				}
		);
	}

	public static Collection<User> getAllUsers(){
		return users.values();
	}

	public static void save(User user){
		users.put(user.getUuid(), user);
	}
}

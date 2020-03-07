package com.thrillio.dao;

import java.util.List;

import com.thrillio.entities.User;
import com.thrillio.store.DataStore;

public class UserDao {

	public List<User> getUsers()
	{
		return DataStore.getUsers();
	}
}

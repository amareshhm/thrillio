package com.thrillio.store;

import java.util.List;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.services.BookmarkService;
import com.thrillio.services.UserService;

public class Launch {

	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;

	public static void main(String[] args) {
		loadData();
		start();
	}

	private static void loadData() {

		System.out.println("1.Loading data ...");
		DataStore.loadData();

		users = UserService.getInstance().getUsers();

		bookmarks = BookmarkService.getInstance().getBookmarks();
		System.out.println("Printing data ...");
		printUserData();
		printBookmarkData();
	}

	private static void printUserData() {

		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {

		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}

	}

	private static void start() {

		// System.out.println("\n 2.Bookmarking ...");
		for (User user : users) {
			View.browse(user, bookmarks);
		}

	}

}

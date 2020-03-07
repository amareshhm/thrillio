package com.thrillio.controllers;

import com.thrillio.constants.KidFriendlyStatus;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.services.BookmarkService;

public class BookmarkController {

	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		
		BookmarkService.getInstance().saveUserBookmark(user,bookmark);
		
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		BookmarkService.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);		
	}
}

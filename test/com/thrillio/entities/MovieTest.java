package com.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.thrillio.constants.MovieGenre;
import com.thrillio.services.BookmarkService;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// if a Movie is of the genre "Horror" or "Thriller", it should return false
		Movie movie;
		// Test 1: "horror" in genre -- false
		movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "-", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR, 8.5);
		assertFalse("\"horror\" in movie genre, should be false", movie.isKidFriendlyEligible());
		// Test 2: "thriller" in genre
		movie = BookmarkService.getInstance().createMovie(3000, "Citizen Kane", "-", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS, 8.5);
		assertFalse("\"thriller\" in movie genre, should be false", movie.isKidFriendlyEligible());

	}

}
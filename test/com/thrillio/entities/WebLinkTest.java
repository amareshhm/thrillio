package com.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.thrillio.services.BookmarkService;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		//test 1 - adult in host -- false
		WebLink webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
		
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For adult in host - isKidFriendlyEligible must return false",isKidFriendlyEligible);
		
		//test 2 - adult in url but not in host -- true
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in url but not in host - isKidFriendlyEligible must return true",isKidFriendlyEligible);
		
		//test 3 - adult in title only -- true
		webLink = BookmarkService.getInstance().createWebLink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in title only - isKidFriendlyEligible must return true",isKidFriendlyEligible);
	}

}

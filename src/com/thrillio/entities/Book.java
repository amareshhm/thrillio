package com.thrillio.entities;

import java.util.Arrays;

import com.thrillio.constants.BookGenre;

public class Book extends Bookmark {

	private int publicationYear;
	private String publisher;
	private String[] authors;
	private BookGenre genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(this.getTitle().toLowerCase().contains("porn")) return false;
		if(publisher.toLowerCase().contains("porn")) return false;
		if(genre.toString().toLowerCase().contains("porn")) return false;
		if(genre.toString().toLowerCase().contains("adult")) return false;
		if(genre.toString().toLowerCase().contains("philosophy")) return false;
		if(genre.toString().toLowerCase().contains("self help")) return false;
		return true;
	}
}

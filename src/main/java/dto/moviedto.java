package dto;

import java.util.Arrays;

public class moviedto {
	
	private int movieid;
	private String moviename;
	private double rating;
	private String genre;
	private String language;
	private byte[] image;
	
	@Override
	public String toString() {
		return "moviedto [movieid=" + movieid + ", moviename=" + moviename + ", rating=" + rating + ", genre=" + genre
				+ ", language=" + language + ", image=" + Arrays.toString(image) + "]";
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}

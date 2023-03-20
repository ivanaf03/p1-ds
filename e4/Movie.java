package e4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

enum MovieRating{
    NOT_RATED(-1),
    AWFUL(0),
    BAD(2),
    MEDIOCRE(4),
    GOOD(6),
    EXCELLENT(8),
    MASTERPIECE(10);

    private final int value;

    MovieRating(int value){
        this.value=value;
    }

    public int getNumericRating(){
        return value;
    }

    boolean isBetterThan(MovieRating m){
        return (this.getNumericRating()>m.value);
    }

}

public class Movie {

    private final String title;
    List<MovieRating> RatingList;

    public Movie(String title) {
        this.title = title;
        this.RatingList = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public void insertRating(MovieRating movieRating) {
        this.RatingList.add(movieRating);
    }

    private boolean isRated() {
        if (this.RatingList.isEmpty()) {
            return false;
        } else return !this.RatingList.contains(MovieRating.NOT_RATED);
    }

    public MovieRating maximumRating() {
        int max = -1;
        int cnt = -1, i = 0;
        for (; i < this.RatingList.size(); i++) {
            if (max < this.RatingList.get(i).getNumericRating()) {
                max = this.RatingList.get(i).getNumericRating();
                cnt = i;
            }
        }
        if (cnt == -1) {
            return MovieRating.NOT_RATED;
        } else {
            return this.RatingList.get(cnt);
        }
    }

    public double averageRating() {
        double media, valoracion = 0., cntRated = 0.;
        for (int i = 0; i < this.RatingList.size(); i++) {
            if (this.RatingList.get(i).getNumericRating() != (-1)) {
                valoracion += this.RatingList.get(i).getNumericRating();
                cntRated++;
            }
        }
        if (cntRated == 0) {
            throw new NoSuchElementException("There are no valid ratings");
        }
        media = valoracion / cntRated;
        return media;
    }
}

package EX3_MovieList;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<String> movieList = new ArrayList<>();

    public void addMovieItem(String item){
        movieList.add(item);
    }

    public void printMovieList(){
        System.out.println("You have " + movieList.size() + " item in your movie list");
        for (int i = 0; i<movieList.size(); i++){
            System.out.println((i+1) + ". " + movieList.get(i));
        }
    }

    public void modifyMovieItem(int position, String newItem){
        movieList.set(position, newItem);
        System.out.println("Movie item " + (position+1) + " has been modified.");
    }

    public void removeMovieItem(int position){
        String theItem = movieList.get(position);
        movieList.remove(position);
        System.out.println("Remove item " + theItem);
    }

    public String findItem(String searchItem){
        boolean exists = movieList.contains(searchItem);
        int position = movieList.indexOf(searchItem);
        if (position >= 0){
            return movieList.get(position);
        }
        return null;
    }

    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addMovieItem("Prison break");
        list.addMovieItem("Step up");
        list.addMovieItem("Train to busan");
        list.addMovieItem("Lord of the rings");
        list.printMovieList();

        String search = list.findItem("Step up");
        System.out.println(search);

        list.modifyMovieItem(1, "Step up 3d");
        list.printMovieList();
    }
}

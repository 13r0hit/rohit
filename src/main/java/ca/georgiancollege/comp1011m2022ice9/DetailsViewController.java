package ca.georgiancollege.comp1011m2022ice9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DetailsViewController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label year;
    @FXML
    private Label rated;
    @FXML
    private Label released;
    @FXML
    private Label runtime;
    @FXML
    private Label genre;
    @FXML
    private Label director;
    @FXML
    private Label writers;
    @FXML
    private Label actors;
    @FXML
    private Label plot;
    @FXML
    private Label type;
    @FXML
    ImageView poster;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Stage stage = (Stage) Stage.getWindows().stream().filter(Window::isShowing).toList().get(0);

        Movie movie = APIManager.Instance().getMovieFromOMDBByID(((SceneData) stage.getUserData()).getMovieId());

        title.setText(movie.getTitle());
        year.setText(movie.getYear());
        rated.setText(movie.getRated());
        released.setText(movie.getReleased());
        runtime.setText(movie.getRuntime());
        genre.setText(movie.getGenre());
        director.setText(movie.getDirector());
        writers.setText(movie.getWriters());
        actors.setText(movie.getActors());
        plot.setText(movie.getPlot());
        type.setText(movie.getType());

        if(movie.getPoster() != null && !movie.getPoster().equalsIgnoreCase("n/a")) {
            poster.setImage(new Image(movie.getPoster()));
        }
        else {
            poster.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("poster-not-found.png"))));
        }

    }
    public void back(ActionEvent actionEvent) {
        Stage stage = (Stage) Stage.getWindows().stream().filter(Window::isShowing).toList().get(0);
        stage.setScene(((SceneData) stage.getUserData()).getPreviousScene());
        stage.show();
    }

}

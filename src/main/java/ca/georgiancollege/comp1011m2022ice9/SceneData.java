package ca.georgiancollege.comp1011m2022ice9;

import javafx.scene.Scene;

public class SceneData {
    private Scene previousScene;
    private String movieId;

    public SceneData(Scene previousScene, String movieId) {
        this.previousScene = previousScene;
        this.movieId = movieId;
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}

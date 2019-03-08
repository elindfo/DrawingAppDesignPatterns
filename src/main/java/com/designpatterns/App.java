package com.designpatterns;

import com.designpatterns.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/** TODO
 * Intuitivt gränssnitt
 * Rita olika typer av former (linje, oval, flerhörning, ...)
 * Markera objekt i vyn för att ändra egenskaper
 * Minimum egenskaper: färg, linjebredd, fyllning
 * Spara / läsa in rit-filer (objektserialisering är OK)
 *
 * [.] MVC (Olika paket för olika delar)
 * [.] Subject-Observer, uppdatera vyer när modell ändras
 * [.] Command, för undo/redo funktion
 * [.] Composite, för att gruppera objekt, hantera gemensamma egenskaper
 * [.] Template-metod där det kan behövas
 * [.] Facade, dölj komplexa modeller
 * [.] Skapelsemönster Ex. Prototype, för att skapa de ritbara objekten
 * [.] Automatisk uppdatering av knappar/menyalternativ från de ritbara typer som finns i modellen
 */
public class App extends Application {
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        new Controller(stage);
    }
}

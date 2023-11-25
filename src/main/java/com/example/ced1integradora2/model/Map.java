package com.example.ced1integradora2.model;

import com.example.ced1integradora2.Implementation;
import com.example.ced1integradora2.model.structure.graph.AdjacencyListGraph;
import com.example.ced1integradora2.model.structure.graph.AdjacencyMatrixGraph;
import com.example.ced1integradora2.model.template.IGraph;
import javafx.scene.Cursor;
import javafx.scene.control.RadioButton;

import java.util.HashMap;

public class Map {

    private IGraph<State> map;
    private HashMap<String, RadioButton> radioButtons;

    public Map(Implementation implementation) {
        switch (implementation) {
            case ADJACENCY_LIST:
                this.map = new AdjacencyListGraph<>(true, true);
                break;
            case ADJACENCY_MATRIX:
                this.map = new AdjacencyMatrixGraph<>(50, true, true);
                break;
        }

        radioButtons = new HashMap<>();
        fillUpGraph();
    }

    public void fillUpGraph() {
        State alabama = new State("Alabama", new Position(713, 538));
        map.addVertex(alabama);
        RadioButton radioButton = new RadioButton();
        radioButton.setLayoutX(alabama.getPosition().getX());
        radioButton.setLayoutY(alabama.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(alabama.getName(), radioButton);

        State arizona = new State("Arizona", new Position(213, 442));
        map.addVertex(arizona);
        radioButton = new RadioButton();
        radioButton.setLayoutX(arizona.getPosition().getX());
        radioButton.setLayoutY(arizona.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(arizona.getName(), radioButton);

        State arkansas = new State("Arkansas", new Position(574, 434));
        map.addVertex(arkansas);
        radioButton = new RadioButton();
        radioButton.setLayoutX(arkansas.getPosition().getX());
        radioButton.setLayoutY(arkansas.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(arkansas.getName(), radioButton);

        State california = new State("California", new Position(78, 361));
        map.addVertex(california);
        radioButton = new RadioButton();
        radioButton.setLayoutX(california.getPosition().getX());
        radioButton.setLayoutY(california.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(california.getName(), radioButton);

        State carolinaDelNorte = new State("Carolina del Norte", new Position(832, 367));
        map.addVertex(carolinaDelNorte);
        radioButton = new RadioButton();
        radioButton.setLayoutX(carolinaDelNorte.getPosition().getX());
        radioButton.setLayoutY(carolinaDelNorte.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(carolinaDelNorte.getName(), radioButton);

        State carolinaDelSur = new State("Carolina del Sur", new Position(819, 819));
        map.addVertex(carolinaDelSur);
        radioButton = new RadioButton();
        radioButton.setLayoutX(carolinaDelSur.getPosition().getX());
        radioButton.setLayoutY(carolinaDelSur.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(carolinaDelSur.getName(), radioButton);

        State colorado = new State("Colorado", new Position(339, 310));
        map.addVertex(colorado);
        radioButton = new RadioButton();
        radioButton.setLayoutX(colorado.getPosition().getX());
        radioButton.setLayoutY(colorado.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(colorado.getName(), radioButton);

        State connecticut = new State("Connecticut", new Position(100, 100));
        map.addVertex(connecticut);
        radioButton = new RadioButton();
        radioButton.setLayoutX(connecticut.getPosition().getX());
        radioButton.setLayoutY(connecticut.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(connecticut.getName(), radioButton);

        State dakotaDelNorte = new State("Dakota del Norte", new Position(427, 427));
        map.addVertex(dakotaDelNorte);
        radioButton = new RadioButton();
        radioButton.setLayoutX(dakotaDelNorte.getPosition().getX());
        radioButton.setLayoutY(dakotaDelNorte.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(dakotaDelNorte.getName(), radioButton);

        State dakotaDelSur = new State("Dakota del Sur", new Position(440, 187));
        map.addVertex(dakotaDelSur);
        radioButton = new RadioButton();
        radioButton.setLayoutX(dakotaDelSur.getPosition().getX());
        radioButton.setLayoutY(dakotaDelSur.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(dakotaDelSur.getName(), radioButton);

        State delaware = new State("Delaware", new Position(878, 273));
        map.addVertex(delaware);
        radioButton = new RadioButton();
        radioButton.setLayoutX(delaware.getPosition().getX());
        radioButton.setLayoutY(delaware.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(delaware.getName(), radioButton);

        State florida = new State("Florida", new Position(815, 568));
        map.addVertex(florida);
        radioButton = new RadioButton();
        radioButton.setLayoutX(florida.getPosition().getX());
        radioButton.setLayoutY(florida.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(florida.getName(), radioButton);

        State georgia = new State("Georgia", new Position(748, 441));
        map.addVertex(georgia);
        radioButton = new RadioButton();
        radioButton.setLayoutX(georgia.getPosition().getX());
        radioButton.setLayoutY(georgia.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(georgia.getName(), radioButton);

        State idaho = new State("Idaho", new Position(213, 213));
        map.addVertex(idaho);
        radioButton = new RadioButton();
        radioButton.setLayoutX(idaho.getPosition().getX());
        radioButton.setLayoutY(idaho.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(idaho.getName(), radioButton);

        State illinois = new State("Illinois", new Position(625, 316));
        map.addVertex(illinois);
        radioButton = new RadioButton();
        radioButton.setLayoutX(illinois.getPosition().getX());
        radioButton.setLayoutY(illinois.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(illinois.getName(), radioButton);

        State indiana = new State("Indiana", new Position(679, 679));
        map.addVertex(indiana);
        radioButton = new RadioButton();
        radioButton.setLayoutX(indiana.getPosition().getX());
        radioButton.setLayoutY(indiana.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(indiana.getName(), radioButton);

        State iowa = new State("Iowa", new Position(548, 242));
        map.addVertex(iowa);
        radioButton = new RadioButton();
        radioButton.setLayoutX(iowa.getPosition().getX());
        radioButton.setLayoutY(iowa.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(iowa.getName(), radioButton);

        State kansas = new State("Kansas", new Position(474, 327));
        map.addVertex(kansas);
        radioButton = new RadioButton();
        radioButton.setLayoutX(kansas.getPosition().getX());
        radioButton.setLayoutY(kansas.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(kansas.getName(), radioButton);

        State kentucky = new State("Kentucky", new Position(710, 327));
        map.addVertex(kentucky);
        radioButton = new RadioButton();
        radioButton.setLayoutX(kentucky.getPosition().getX());
        radioButton.setLayoutY(kentucky.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(kentucky.getName(), radioButton);

        State luisiana = new State("Luisiana", new Position(579, 496));
        map.addVertex(luisiana);
        radioButton = new RadioButton();
        radioButton.setLayoutX(luisiana.getPosition().getX());
        radioButton.setLayoutY(luisiana.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(luisiana.getName(), radioButton);

        State maine = new State("Maine", new Position(914, 67));
        map.addVertex(maine);
        radioButton = new RadioButton();
        radioButton.setLayoutX(maine.getPosition().getX());
        radioButton.setLayoutY(maine.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(maine.getName(), radioButton);

        State maryland = new State("Maryland", new Position(876, 291));
        map.addVertex(maryland);
        radioButton = new RadioButton();
        radioButton.setLayoutX(maryland.getPosition().getX());
        radioButton.setLayoutY(maryland.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(maryland.getName(), radioButton);

        State massachusetts = new State("Massachusetts", new Position(903, 169));
        map.addVertex(massachusetts);
        radioButton = new RadioButton();
        radioButton.setLayoutX(massachusetts.getPosition().getX());
        radioButton.setLayoutY(massachusetts.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(massachusetts.getName(), radioButton);

        State michigan = new State("Míchigan", new Position(684, 188));
        map.addVertex(michigan);
        radioButton = new RadioButton();
        radioButton.setLayoutX(michigan.getPosition().getX());
        radioButton.setLayoutY(michigan.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(michigan.getName(), radioButton);

        State minnesota = new State("Minnesota", new Position(527, 185));
        map.addVertex(minnesota);
        radioButton = new RadioButton();
        radioButton.setLayoutX(minnesota.getPosition().getX());
        radioButton.setLayoutY(minnesota.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(minnesota.getName(), radioButton);

        State misisipi = new State("Misisipi", new Position(641, 465));
        map.addVertex(misisipi);
        radioButton = new RadioButton();
        radioButton.setLayoutX(misisipi.getPosition().getX());
        radioButton.setLayoutY(misisipi.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(misisipi.getName(), radioButton);

        State misuri = new State("Misuri", new Position(582, 326));
        map.addVertex(misuri);
        radioButton = new RadioButton();
        radioButton.setLayoutX(misuri.getPosition().getX());
        radioButton.setLayoutY(misuri.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(misuri.getName(), radioButton);

        State montana = new State("Montana", new Position(213, 213));
        map.addVertex(montana);
        radioButton = new RadioButton();
        radioButton.setLayoutX(montana.getPosition().getX());
        radioButton.setLayoutY(montana.getPosition().getY());

        State nebraska = new State("Nebraska", new Position(474, 327));
        map.addVertex(nebraska);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nebraska.getPosition().getX());
        radioButton.setLayoutY(nebraska.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(nebraska.getName(), radioButton);

        State nevada = new State("Nevada", new Position(213, 213));
        map.addVertex(nevada);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nevada.getPosition().getX());
        radioButton.setLayoutY(nevada.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(nevada.getName(), radioButton);

        State nuevaHampshire = new State("Nueva Hampshire", new Position(213, 213));
        map.addVertex(nuevaHampshire);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevaHampshire.getPosition().getX());
        radioButton.setLayoutY(nuevaHampshire.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(nuevaHampshire.getName(), radioButton);

        State nuevaJersey = new State("Nueva Jersey", new Position(213, 213));
        map.addVertex(nuevaJersey);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevaJersey.getPosition().getX());
        radioButton.setLayoutY(nuevaJersey.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(nuevaJersey.getName(), radioButton);

        State nuevoMexico = new State("Nuevo México", new Position(213, 213));
        map.addVertex(nuevoMexico);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevoMexico.getPosition().getX());
        radioButton.setLayoutY(nuevoMexico.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(nuevoMexico.getName(), radioButton);

        State nuevaYork = new State("Nueva York", new Position(213, 213));
        map.addVertex(nuevaYork);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevaYork.getPosition().getX());
        radioButton.setLayoutY(nuevaYork.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(nuevaYork.getName(), radioButton);

        State ohio = new State("Ohio", new Position(213, 213));
        map.addVertex(ohio);
        radioButton = new RadioButton();
        radioButton.setLayoutX(ohio.getPosition().getX());
        radioButton.setLayoutY(ohio.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(ohio.getName(), radioButton);

        State oklahoma = new State("Oklahoma", new Position(213, 213));
        map.addVertex(oklahoma);
        radioButton = new RadioButton();
        radioButton.setLayoutX(oklahoma.getPosition().getX());
        radioButton.setLayoutY(oklahoma.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(oklahoma.getName(), radioButton);

        State oregon = new State("Oregón", new Position(213, 213));
        map.addVertex(oregon);
        radioButton = new RadioButton();
        radioButton.setLayoutX(oregon.getPosition().getX());
        radioButton.setLayoutY(oregon.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(oregon.getName(), radioButton);

        State pensilvania = new State("Pensilvania", new Position(213, 213));
        map.addVertex(pensilvania);
        radioButton = new RadioButton();
        radioButton.setLayoutX(pensilvania.getPosition().getX());
        radioButton.setLayoutY(pensilvania.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(pensilvania.getName(), radioButton);

        State rhodeIsland = new State("Rhode Island", new Position(213, 213));
        map.addVertex(rhodeIsland);
        radioButton = new RadioButton();
        radioButton.setLayoutX(rhodeIsland.getPosition().getX());
        radioButton.setLayoutY(rhodeIsland.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(rhodeIsland.getName(), radioButton);

        State tennessee = new State("Tennessee", new Position(213, 213));
        map.addVertex(tennessee);
        radioButton = new RadioButton();
        radioButton.setLayoutX(tennessee.getPosition().getX());
        radioButton.setLayoutY(tennessee.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(tennessee.getName(), radioButton);

        State texas = new State("Texas", new Position(213, 213));
        map.addVertex(texas);
        radioButton = new RadioButton();
        radioButton.setLayoutX(texas.getPosition().getX());
        radioButton.setLayoutY(texas.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(texas.getName(), radioButton);

        State utah = new State("Utah", new Position(213, 213));
        map.addVertex(utah);
        radioButton = new RadioButton();
        radioButton.setLayoutX(utah.getPosition().getX());
        radioButton.setLayoutY(utah.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(utah.getName(), radioButton);

        State vermont = new State("Vermont", new Position(213, 213));
        map.addVertex(vermont);
        radioButton = new RadioButton();
        radioButton.setLayoutX(vermont.getPosition().getX());
        radioButton.setLayoutY(vermont.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(vermont.getName(), radioButton);

        State virginia = new State("Virginia", new Position(213, 213));
        map.addVertex(virginia);
        radioButton = new RadioButton();
        radioButton.setLayoutX(virginia.getPosition().getX());
        radioButton.setLayoutY(virginia.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(virginia.getName(), radioButton);

        State virginiaOccidental = new State("Virginia Occidental", new Position(213, 213));
        map.addVertex(virginiaOccidental);
        radioButton = new RadioButton();
        radioButton.setLayoutX(virginiaOccidental.getPosition().getX());
        radioButton.setLayoutY(virginiaOccidental.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(virginiaOccidental.getName(), radioButton);

        State washington = new State("Washington", new Position(213, 213));
        map.addVertex(washington);
        radioButton = new RadioButton();
        radioButton.setLayoutX(washington.getPosition().getX());
        radioButton.setLayoutY(washington.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(washington.getName(), radioButton);

        State wisconsin = new State("Wisconsin", new Position(213, 213));
        map.addVertex(wisconsin);
        radioButton = new RadioButton();
        radioButton.setLayoutX(wisconsin.getPosition().getX());
        radioButton.setLayoutY(wisconsin.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(wisconsin.getName(), radioButton);

        State wyoming = new State("Wyoming", new Position(213, 213));
        map.addVertex(wyoming);
        radioButton = new RadioButton();
        radioButton.setLayoutX(wyoming.getPosition().getX());
        radioButton.setLayoutY(wyoming.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButtons.put(wyoming.getName(), radioButton);

        map.addEdge(washington, oregon, 5.0);
        map.addEdge(washington, idaho, 7.0);
        map.addEdge(washington, montana, 6.0);
        map.addEdge(oregon, california, 8.0);
        map.addEdge(oregon, nevada, 7.0);
        map.addEdge(california, nevada, 4.0);
        map.addEdge(california, arizona, 6.0);
        map.addEdge(nevada, idaho, 5.0);
        map.addEdge(nevada, utah, 4.0);
        map.addEdge(nevada, arizona, 8.0);
        map.addEdge(arizona, utah, 6.0);
        map.addEdge(arizona, nuevoMexico, 3.0);
        map.addEdge(utah, wyoming, 5.0);
        map.addEdge(wyoming, montana, 5.0);
        map.addEdge(wyoming, dakotaDelSur, 5.0);
        map.addEdge(wyoming, colorado, 5.0);
        map.addEdge(montana, dakotaDelNorte, 6.0);
        map.addEdge(nuevoMexico, colorado, 7.0);
        map.addEdge(nuevoMexico, texas, 8.0);
        map.addEdge(texas, oklahoma, 6.0);
        map.addEdge(oklahoma, kansas, 3.0);
        map.addEdge(kansas, nebraska, 4.0);
        map.addEdge(kansas, misuri, 5.0);
        map.addEdge(kansas, arkansas, 6.0);
        map.addEdge(dakotaDelNorte, minnesota, 2.0);
        map.addEdge(dakotaDelSur, iowa, 5.0);
        map.addEdge(iowa, misuri, 4.0);
        map.addEdge(iowa, wisconsin, 4.0);
        map.addEdge(minnesota, wisconsin, 4.0);
        map.addEdge(wisconsin, illinois, 6.0);
        map.addEdge(misuri, kentucky, 5.0);
        map.addEdge(misuri, arkansas, 5.0);
        map.addEdge(arkansas, misisipi, 5.0);
        map.addEdge(arkansas, tennessee, 4.0);
        map.addEdge(arkansas, luisiana, 6.0);
        map.addEdge(misisipi, alabama, 1.0);
        map.addEdge(alabama, tennessee, 3.0);
        map.addEdge(tennessee, carolinaDelSur, 4.0);
        map.addEdge(carolinaDelSur, georgia, 3.0);
        map.addEdge(georgia, florida, 5.0);
        map.addEdge(kentucky, indiana, 3.0);
        map.addEdge(indiana, michigan, 5.0);
        map.addEdge(kentucky, virginiaOccidental, 4.0);
        map.addEdge(carolinaDelSur, virginia, 6.0);
        map.addEdge(virginiaOccidental, pensilvania, 4.0);
        map.addEdge(virginia, pensilvania, 5.0);
        map.addEdge(pensilvania, nuevaYork, 3.0);
        map.addEdge(nuevaYork, nuevaJersey, 5.0);
        map.addEdge(nuevaYork, connecticut, 3.0);
        map.addEdge(nuevaYork, massachusetts, 3.0);
        map.addEdge(nuevaYork, vermont, 4.0);
        map.addEdge(vermont, nuevaHampshire, 3.0);
        map.addEdge(nuevaHampshire, maine, 3.0);
        map.addEdge(nuevaHampshire, rhodeIsland, 3.0);
    }

    public HashMap<String, RadioButton> getRadioButtons() {
        return radioButtons;
    }
}

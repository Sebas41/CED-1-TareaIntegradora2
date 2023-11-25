package com.example.ced1integradora2.model;

import com.example.ced1integradora2.Implementation;
import com.example.ced1integradora2.model.structure.graph.AdjacencyListGraph;
import com.example.ced1integradora2.model.structure.graph.AdjacencyMatrixGraph;
import com.example.ced1integradora2.model.template.IGraph;
import javafx.scene.Cursor;
import javafx.scene.control.RadioButton;

import java.util.HashMap;

public class GameMap {

    private IGraph<State> map;
    private HashMap<String, RadioButton> radioButtons;
    private HashMap<String, State> states;

    public GameMap(Implementation implementation) {
        switch (implementation) {
            case ADJACENCY_LIST:
                this.map = new AdjacencyListGraph<>(true, true);
                break;
            case ADJACENCY_MATRIX:
                this.map = new AdjacencyMatrixGraph<>(50, true, true);
                break;
        }

        radioButtons = new HashMap<>();
        states = new HashMap<>();
        fillUpGraph();
    }

    public void fillUpGraph() {
        State alabama = new State("Alabama", new Position(713, 538));
        map.addVertex(alabama);
        RadioButton radioButton = new RadioButton();
        radioButton.setLayoutX(alabama.getPosition().getX());
        radioButton.setLayoutY(alabama.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(alabama.getName());
        states.put(alabama.getName(), alabama);
        radioButtons.put(alabama.getName(), radioButton);

        State arizona = new State("Arizona", new Position(213, 442));
        map.addVertex(arizona);
        radioButton = new RadioButton();
        radioButton.setLayoutX(arizona.getPosition().getX());
        radioButton.setLayoutY(arizona.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(arizona.getName());
        states.put(arizona.getName(), arizona);
        radioButtons.put(arizona.getName(), radioButton);

        State arkansas = new State("Arkansas", new Position(574, 434));
        map.addVertex(arkansas);
        radioButton = new RadioButton();
        radioButton.setLayoutX(arkansas.getPosition().getX());
        radioButton.setLayoutY(arkansas.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(arkansas.getName());
        states.put(arkansas.getName(), arkansas);
        radioButtons.put(arkansas.getName(), radioButton);

        State california = new State("California", new Position(78, 361));
        map.addVertex(california);
        radioButton = new RadioButton();
        radioButton.setLayoutX(california.getPosition().getX());
        radioButton.setLayoutY(california.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(california.getName());
        states.put(california.getName(), california);
        radioButtons.put(california.getName(), radioButton);

        State carolinaDelNorte = new State("Carolina del Norte", new Position(832, 367));
        map.addVertex(carolinaDelNorte);
        radioButton = new RadioButton();
        radioButton.setLayoutX(carolinaDelNorte.getPosition().getX());
        radioButton.setLayoutY(carolinaDelNorte.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(carolinaDelNorte.getName());
        states.put(carolinaDelNorte.getName(), carolinaDelNorte);
        radioButtons.put(carolinaDelNorte.getName(), radioButton);

        State carolinaDelSur = new State("Carolina del Sur", new Position(819, 819));
        map.addVertex(carolinaDelSur);
        radioButton = new RadioButton();
        radioButton.setLayoutX(carolinaDelSur.getPosition().getX());
        radioButton.setLayoutY(carolinaDelSur.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(carolinaDelSur.getName());
        states.put(carolinaDelSur.getName(), carolinaDelSur);
        radioButtons.put(carolinaDelSur.getName(), radioButton);

        State colorado = new State("Colorado", new Position(339, 310));
        map.addVertex(colorado);
        radioButton = new RadioButton();
        radioButton.setLayoutX(colorado.getPosition().getX());
        radioButton.setLayoutY(colorado.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(colorado.getName());
        states.put(colorado.getName(), colorado);
        radioButtons.put(colorado.getName(), radioButton);

        State connecticut = new State("Connecticut", new Position(902, 192));
        map.addVertex(connecticut);
        radioButton = new RadioButton();
        radioButton.setLayoutX(connecticut.getPosition().getX());
        radioButton.setLayoutY(connecticut.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(connecticut.getName());
        states.put(connecticut.getName(), connecticut);
        radioButtons.put(connecticut.getName(), radioButton);

        State dakotaDelNorte = new State("Dakota del Norte", new Position(427, 427));
        map.addVertex(dakotaDelNorte);
        radioButton = new RadioButton();
        radioButton.setLayoutX(dakotaDelNorte.getPosition().getX());
        radioButton.setLayoutY(dakotaDelNorte.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(dakotaDelNorte.getName());
        states.put(dakotaDelNorte.getName(), dakotaDelNorte);
        radioButtons.put(dakotaDelNorte.getName(), radioButton);

        State dakotaDelSur = new State("Dakota del Sur", new Position(440, 187));
        map.addVertex(dakotaDelSur);
        radioButton = new RadioButton();
        radioButton.setLayoutX(dakotaDelSur.getPosition().getX());
        radioButton.setLayoutY(dakotaDelSur.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(dakotaDelSur.getName());
        states.put(dakotaDelSur.getName(), dakotaDelSur);
        radioButtons.put(dakotaDelSur.getName(), radioButton);

        State delaware = new State("Delaware", new Position(878, 273));
        map.addVertex(delaware);
        radioButton = new RadioButton();
        radioButton.setLayoutX(delaware.getPosition().getX());
        radioButton.setLayoutY(delaware.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(delaware.getName());
        states.put(delaware.getName(), delaware);
        radioButtons.put(delaware.getName(), radioButton);

        State florida = new State("Florida", new Position(815, 568));
        map.addVertex(florida);
        radioButton = new RadioButton();
        radioButton.setLayoutX(florida.getPosition().getX());
        radioButton.setLayoutY(florida.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(florida.getName());
        states.put(florida.getName(), florida);
        radioButtons.put(florida.getName(), radioButton);

        State georgia = new State("Georgia", new Position(748, 441));
        map.addVertex(georgia);
        radioButton = new RadioButton();
        radioButton.setLayoutX(georgia.getPosition().getX());
        radioButton.setLayoutY(georgia.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(georgia.getName());
        states.put(georgia.getName(), georgia);
        radioButtons.put(georgia.getName(), radioButton);

        State idaho = new State("Idaho", new Position(213, 213));
        map.addVertex(idaho);
        radioButton = new RadioButton();
        radioButton.setLayoutX(idaho.getPosition().getX());
        radioButton.setLayoutY(idaho.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(idaho.getName());
        states.put(idaho.getName(), idaho);
        radioButtons.put(idaho.getName(), radioButton);

        State illinois = new State("Illinois", new Position(625, 316));
        map.addVertex(illinois);
        radioButton = new RadioButton();
        radioButton.setLayoutX(illinois.getPosition().getX());
        radioButton.setLayoutY(illinois.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(illinois.getName());
        states.put(illinois.getName(), illinois);
        radioButtons.put(illinois.getName(), radioButton);

        State indiana = new State("Indiana", new Position(679, 679));
        map.addVertex(indiana);
        radioButton = new RadioButton();
        radioButton.setLayoutX(indiana.getPosition().getX());
        radioButton.setLayoutY(indiana.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(indiana.getName());
        states.put(indiana.getName(), indiana);
        radioButtons.put(indiana.getName(), radioButton);

        State iowa = new State("Iowa", new Position(548, 242));
        map.addVertex(iowa);
        radioButton = new RadioButton();
        radioButton.setLayoutX(iowa.getPosition().getX());
        radioButton.setLayoutY(iowa.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(iowa.getName());
        states.put(iowa.getName(), iowa);
        radioButtons.put(iowa.getName(), radioButton);

        State kansas = new State("Kansas", new Position(474, 327));
        map.addVertex(kansas);
        radioButton = new RadioButton();
        radioButton.setLayoutX(kansas.getPosition().getX());
        radioButton.setLayoutY(kansas.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(kansas.getName());
        states.put(kansas.getName(), kansas);
        radioButtons.put(kansas.getName(), radioButton);

        State kentucky = new State("Kentucky", new Position(710, 327));
        map.addVertex(kentucky);
        radioButton = new RadioButton();
        radioButton.setLayoutX(kentucky.getPosition().getX());
        radioButton.setLayoutY(kentucky.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(kentucky.getName());
        states.put(kentucky.getName(), kentucky);
        radioButtons.put(kentucky.getName(), radioButton);

        State luisiana = new State("Luisiana", new Position(579, 496));
        map.addVertex(luisiana);
        radioButton = new RadioButton();
        radioButton.setLayoutX(luisiana.getPosition().getX());
        radioButton.setLayoutY(luisiana.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(luisiana.getName());
        states.put(luisiana.getName(), luisiana);
        radioButtons.put(luisiana.getName(), radioButton);

        State maine = new State("Maine", new Position(914, 67));
        map.addVertex(maine);
        radioButton = new RadioButton();
        radioButton.setLayoutX(maine.getPosition().getX());
        radioButton.setLayoutY(maine.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(maine.getName());
        states.put(maine.getName(), maine);
        radioButtons.put(maine.getName(), radioButton);

        State maryland = new State("Maryland", new Position(876, 291));
        map.addVertex(maryland);
        radioButton = new RadioButton();
        radioButton.setLayoutX(maryland.getPosition().getX());
        radioButton.setLayoutY(maryland.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(maryland.getName());
        states.put(maryland.getName(), maryland);
        radioButtons.put(maryland.getName(), radioButton);

        State massachusetts = new State("Massachusetts", new Position(903, 169));
        map.addVertex(massachusetts);
        radioButton = new RadioButton();
        radioButton.setLayoutX(massachusetts.getPosition().getX());
        radioButton.setLayoutY(massachusetts.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(massachusetts.getName());
        states.put(massachusetts.getName(), massachusetts);
        radioButtons.put(massachusetts.getName(), radioButton);

        State michigan = new State("Míchigan", new Position(684, 188));
        map.addVertex(michigan);
        radioButton = new RadioButton();
        radioButton.setLayoutX(michigan.getPosition().getX());
        radioButton.setLayoutY(michigan.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(michigan.getName());
        states.put(michigan.getName(), michigan);
        radioButtons.put(michigan.getName(), radioButton);

        State minnesota = new State("Minnesota", new Position(527, 185));
        map.addVertex(minnesota);
        radioButton = new RadioButton();
        radioButton.setLayoutX(minnesota.getPosition().getX());
        radioButton.setLayoutY(minnesota.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(minnesota.getName());
        states.put(minnesota.getName(), minnesota);
        radioButtons.put(minnesota.getName(), radioButton);

        State misisipi = new State("Misisipi", new Position(641, 465));
        map.addVertex(misisipi);
        radioButton = new RadioButton();
        radioButton.setLayoutX(misisipi.getPosition().getX());
        radioButton.setLayoutY(misisipi.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(misisipi.getName());
        states.put(misisipi.getName(), misisipi);
        radioButtons.put(misisipi.getName(), radioButton);

        State misuri = new State("Misuri", new Position(582, 326));
        map.addVertex(misuri);
        radioButton = new RadioButton();
        radioButton.setLayoutX(misuri.getPosition().getX());
        radioButton.setLayoutY(misuri.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(misuri.getName());
        states.put(misuri.getName(), misuri);
        radioButtons.put(misuri.getName(), radioButton);

        State montana = new State("Montana", new Position(280, 114));
        map.addVertex(montana);
        radioButton = new RadioButton();
        radioButton.setLayoutX(montana.getPosition().getX());
        radioButton.setLayoutY(montana.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(montana.getName());
        states.put(montana.getName(), montana);
        radioButtons.put(montana.getName(), radioButton);

        State nebraska = new State("Nebraska", new Position(474, 327));
        map.addVertex(nebraska);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nebraska.getPosition().getX());
        radioButton.setLayoutY(nebraska.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(nebraska.getName());
        states.put(nebraska.getName(), nebraska);
        radioButtons.put(nebraska.getName(), radioButton);

        State nevada = new State("Nevada", new Position(144, 283));
        map.addVertex(nevada);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nevada.getPosition().getX());
        radioButton.setLayoutY(nevada.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(nevada.getName());
        states.put(nevada.getName(), nevada);
        radioButtons.put(nevada.getName(), radioButton);

        State nuevaHampshire = new State("Nueva Hampshire", new Position(897, 133));
        map.addVertex(nuevaHampshire);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevaHampshire.getPosition().getX());
        radioButton.setLayoutY(nuevaHampshire.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(nuevaHampshire.getName());
        states.put(nuevaHampshire.getName(), nuevaHampshire);
        radioButtons.put(nuevaHampshire.getName(), radioButton);

        State nuevaJersey = new State("Nueva Jersey", new Position(879, 244));
        map.addVertex(nuevaJersey);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevaJersey.getPosition().getX());
        radioButton.setLayoutY(nuevaJersey.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(nuevaJersey.getName());
        states.put(nuevaJersey.getName(), nuevaJersey);
        radioButtons.put(nuevaJersey.getName(), radioButton);

        State nuevoMexico = new State("Nuevo México", new Position(317, 455));
        map.addVertex(nuevoMexico);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevoMexico.getPosition().getX());
        radioButton.setLayoutY(nuevoMexico.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(nuevoMexico.getName());
        states.put(nuevoMexico.getName(), nuevoMexico);
        radioButtons.put(nuevoMexico.getName(), radioButton);

        State nuevaYork = new State("Nueva York", new Position(835, 172));
        map.addVertex(nuevaYork);
        radioButton = new RadioButton();
        radioButton.setLayoutX(nuevaYork.getPosition().getX());
        radioButton.setLayoutY(nuevaYork.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(nuevaYork.getName());
        states.put(nuevaYork.getName(), nuevaYork);
        radioButtons.put(nuevaYork.getName(), radioButton);

        State ohio = new State("Ohio", new Position(733, 259));
        map.addVertex(ohio);
        radioButton = new RadioButton();
        radioButton.setLayoutX(ohio.getPosition().getX());
        radioButton.setLayoutY(ohio.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(ohio.getName());
        states.put(ohio.getName(), ohio);
        radioButtons.put(ohio.getName(), radioButton);

        State oklahoma = new State("Oklahoma", new Position(550, 354));
        map.addVertex(oklahoma);
        radioButton = new RadioButton();
        radioButton.setLayoutX(oklahoma.getPosition().getX());
        radioButton.setLayoutY(oklahoma.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(oklahoma.getName());
        states.put(oklahoma.getName(), oklahoma);
        radioButtons.put(oklahoma.getName(), radioButton);

        State oregon = new State("Oregón", new Position(76, 168));
        map.addVertex(oregon);
        radioButton = new RadioButton();
        radioButton.setLayoutX(oregon.getPosition().getX());
        radioButton.setLayoutY(oregon.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(oregon.getName());
        states.put(oregon.getName(), oregon);
        radioButtons.put(oregon.getName(), radioButton);

        State pensilvania = new State("Pensilvania", new Position(812, 223));
        map.addVertex(pensilvania);
        radioButton = new RadioButton();
        radioButton.setLayoutX(pensilvania.getPosition().getX());
        radioButton.setLayoutY(pensilvania.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(pensilvania.getName());
        states.put(pensilvania.getName(), pensilvania);
        radioButtons.put(pensilvania.getName(), radioButton);

        State rhodeIsland = new State("Rhode Island", new Position(916, 186));
        map.addVertex(rhodeIsland);
        radioButton = new RadioButton();
        radioButton.setLayoutX(rhodeIsland.getPosition().getX());
        radioButton.setLayoutY(rhodeIsland.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(rhodeIsland.getName());
        states.put(rhodeIsland.getName(), rhodeIsland);
        radioButtons.put(rhodeIsland.getName(), radioButton);

        State tennessee = new State("Tennessee", new Position(692, 377));
        map.addVertex(tennessee);
        radioButton = new RadioButton();
        radioButton.setLayoutX(tennessee.getPosition().getX());
        radioButton.setLayoutY(tennessee.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(tennessee.getName());
        states.put(tennessee.getName(), tennessee);
        radioButtons.put(tennessee.getName(), radioButton);

        State texas = new State("Texas", new Position(467, 537));
        map.addVertex(texas);
        radioButton = new RadioButton();
        radioButton.setLayoutX(texas.getPosition().getX());
        radioButton.setLayoutY(texas.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(texas.getName());
        states.put(texas.getName(), texas);
        radioButtons.put(texas.getName(), radioButton);

        State utah = new State("Utah", new Position(228, 289));
        map.addVertex(utah);
        radioButton = new RadioButton();
        radioButton.setLayoutX(utah.getPosition().getX());
        radioButton.setLayoutY(utah.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(utah.getName());
        states.put(utah.getName(), utah);
        radioButtons.put(utah.getName(), radioButton);

        State vermont = new State("Vermont", new Position(879, 137));
        map.addVertex(vermont);
        radioButton = new RadioButton();
        radioButton.setLayoutX(vermont.getPosition().getX());
        radioButton.setLayoutY(vermont.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(vermont.getName());
        states.put(vermont.getName(), vermont);
        radioButtons.put(vermont.getName(), radioButton);

        State virginia = new State("Virginia", new Position(821, 307));
        map.addVertex(virginia);
        radioButton = new RadioButton();
        radioButton.setLayoutX(virginia.getPosition().getX());
        radioButton.setLayoutY(virginia.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(virginia.getName());
        states.put(virginia.getName(), virginia);
        radioButtons.put(virginia.getName(), radioButton);

        State virginiaOccidental = new State("Virginia Occidental", new Position(781, 287));
        map.addVertex(virginiaOccidental);
        radioButton = new RadioButton();
        radioButton.setLayoutX(virginiaOccidental.getPosition().getX());
        radioButton.setLayoutY(virginiaOccidental.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(virginiaOccidental.getName());
        states.put(virginiaOccidental.getName(), virginiaOccidental);
        radioButtons.put(virginiaOccidental.getName(), radioButton);

        State washington = new State("Washington", new Position(126, 81));
        map.addVertex(washington);
        radioButton = new RadioButton();
        radioButton.setLayoutX(washington.getPosition().getX());
        radioButton.setLayoutY(washington.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(washington.getName());
        states.put(washington.getName(), washington);
        radioButtons.put(washington.getName(), radioButton);

        State wisconsin = new State("Wisconsin", new Position(602, 172));
        map.addVertex(wisconsin);
        radioButton = new RadioButton();
        radioButton.setLayoutX(wisconsin.getPosition().getX());
        radioButton.setLayoutY(wisconsin.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(wisconsin.getName());
        states.put(wisconsin.getName(), wisconsin);
        radioButtons.put(wisconsin.getName(), radioButton);

        State wyoming = new State("Wyoming", new Position(303, 229));
        map.addVertex(wyoming);
        radioButton = new RadioButton();
        radioButton.setLayoutX(wyoming.getPosition().getX());
        radioButton.setLayoutY(wyoming.getPosition().getY());
        radioButton.setCursor(Cursor.HAND);
        radioButton.setText(wyoming.getName());
        states.put(wyoming.getName(), wyoming);
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

    public IGraph<State> getMap() {
        return map;
    }

    public HashMap<String, State> getStates() {
        return states;
    }
}

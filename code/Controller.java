// TODO: 15/06/2021 get floorID working for adding aisle 

package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Controller<F> {

    @FXML
    public ListView floorDetails;
    public TextField floorNum, sLevel, temper;
    public Scanner input;
    public GenericList<Floor> floors;

    @FXML
    public ListView aisleDetails;
    public TextField txtAisleID;
    public TextField txtAisleDimX;
    public TextField txtAisleDimY;
    public TextField txtFloorID;
    public GenericList<Aisle> aisles;

    @FXML
    public ListView shelfDetails;
    public TextField txtShelfNum;
    public TextField txtAisleShelfID;
    public GenericList<Shelf> shelves;

    @FXML
    public ListView palletDetails;
    public TextField txtGoods;
    public TextField txtQuantity;
    public TextField txtMinTemp;
    public TextField txtMaxTemp;
    public TextField txtPalletGoods; //for deleting specific pallets
    public GenericList<Pallet> pallets;

    @FXML
    public ListView allFloorDetails, allAisleDetails, allShelfDetails, allPalletDetails;

    public Controller(){
        input = new Scanner(System.in);
        floors = new GenericList<>();
        aisles = new GenericList<>();
        shelves = new GenericList<>();
        pallets = new GenericList<>();
    }

    //allows user to view all floors, aisles, etc
    public void viewAll(ActionEvent actionEvent) {
        GenericNode<Floor> floorList = floors.head;
        GenericNode<Aisle> aisleList = aisles.head;
        GenericNode<Shelf> shelfList = shelves.head;
        GenericNode<Pallet> palletList = pallets.head;
        allFloorDetails.getItems().add(floorList.getContents());
        allAisleDetails.getItems().add(aisleList.getContents());
        allShelfDetails.getItems().add(shelfList.getContents());
        allPalletDetails.getItems().add(palletList.getContents());
    }

    //Floor Methods

    //adds new floor
    public void addFloor(ActionEvent actionEvent){
        Floor f = new Floor(Integer.parseInt(floorNum.getText()), sLevel.getText(), Double.parseDouble(temper.getText()));
        floors.addElement(f);
        floorDetails.getItems().add("Floor added");
        System.out.println("floor added");
    }

    public void listFloors(ActionEvent actionEvent){
        //floorDetails.getItems().addAll(floors.listAll());
        GenericNode<Floor> floorList = (floors.head);
        while(floorList != null){
            floorDetails.getItems().add((Floor)floorList.getContents());
            floorList = floorList.next;
        }
        System.out.println("floors listed");
    }

    public void clearAllFloors(ActionEvent actionEvent){
        floors.clearAll();
        floorDetails.getItems().clear();
        System.out.println("floors cleared");
    }

    //Aisle Methods

    //adds new Aisle
    public void addAisle(ActionEvent actionEvent){
        Aisle a = new Aisle(txtAisleID.getText(), Integer.parseInt(txtAisleDimX.getText()), Integer.parseInt(txtAisleDimY.getText()), Integer.parseInt(txtFloorID.getText()));
        int id = Integer.parseInt(txtFloorID.getText());
        Floor f = floors.getFloorID(id);
        f.addAisle(a);
        aisles.addElement(a);
        aisleDetails.getItems().add("aisle added");
        System.out.println(f.aisles.listAll());
    }

    public void ListAisles(ActionEvent actionEvent) {
        //aisleDetails.getItems().addAll(aisles.listAll());
        GenericNode<Aisle> aisleList = (aisles.head);
        while(aisleList != null){
            aisleDetails.getItems().add((Aisle)aisleList.getContents());
            aisleList = aisleList.next;
        }
        System.out.println("aisles Listed");
    }

    public void clearAllAisles(ActionEvent actionEvent) {
        aisles.clearAll();
        aisleDetails.getItems().clear();
        System.out.println("aisles cleared");
    }

    //shelf methods//

    public void addShelf(ActionEvent actionEvent) {
        Shelf s = new Shelf(Integer.parseInt(txtShelfNum.getText()));
        String id = txtAisleShelfID.getText();
        Aisle a = aisles.getAisleID(id);
        a.addShelf(s);
        shelves.addElement(s);
        shelfDetails.getItems().add("shelf added");
        System.out.println(a.shelves.listAll());
    }

    public void ListShelves(ActionEvent actionEvent) {
        GenericNode<Shelf> shelfList = (shelves.head);
        while(shelfList != null){
            shelfDetails.getItems().add((Shelf)shelfList.getContents());
            shelfList = shelfList.next;
        }
        System.out.println("shelves Listed");
    }

    public void clearAllShelves(ActionEvent actionEvent) {
        shelves.clearAll();
        shelfDetails.getItems().clear();
    }
    //pallet methods//

    public void addPallet(ActionEvent actionEvent) {
        Pallet p = new Pallet(txtGoods.getText(), Integer.parseInt(txtQuantity.getText()), Double.parseDouble(txtMinTemp.getText()), Double.parseDouble(txtMaxTemp.getText()));
        int id = Integer.parseInt(txtShelfNum.getText());
        Shelf s = shelves.getShelfID(id);
        s.addPallet(p);
        pallets.addElement(p);
    }

    public void ListPallets(ActionEvent actionEvent) {
        GenericNode<Pallet> palletList = (pallets.head);
        while(palletList != null){
            palletDetails.getItems().add((Pallet)palletList.getContents());
            palletList = palletList.next;
        }
        System.out.println("shelves Listed");
    }

    public void deletePallet(ActionEvent actionEvent){
        String pallet = txtPalletGoods.getText();
        if(pallet != null){
            Pallet p = pallets.getPalletGoods(pallet);
        }
    }

    public void clearAllPallets(ActionEvent actionEvent) {
        pallets.clearAll();
        palletDetails.getItems().clear();
    }

    //load & save methods//

    public void load(ActionEvent actionEvent)throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("floors.xml"));
        floors = (GenericList<Floor>) in.readObject();
        aisles = (GenericList<Aisle>) in.readObject();
        shelves =  (GenericList<Shelf>) in.readObject();
        pallets = (GenericList<Pallet>) in.readObject();
        in.close();
    }

    public void save(ActionEvent actionEvent) throws IOException {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("floors.xml"));
        out.writeObject(floors);
        out.writeObject(aisles);
        out.writeObject(shelves);
        out.writeObject(pallets);
        out.close();
        System.out.println("saved");
    }
}

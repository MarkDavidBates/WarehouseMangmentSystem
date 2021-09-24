// TODO: 11/06/2021 get floorID working

package sample;

public class GenericList<F> {

    //beginning of the node is set to null
    public GenericNode<F> head = null;

    //adds a new element to the head of the list
    public void addElement(F f){
        GenericNode<F> fl = new GenericNode<>();
        fl.setContents(f);
        fl.next = head;
        head = fl;
    }

    //makes the head null, clearing the list
    public void clearAll(){
        head = null;
    }

    //if head isn't null, we run through all elements and list off each one
    public String listAll(){
        if(head == null){
            return "Nothing Found";
        }
        else{
            String listOfElements = "";
            for(GenericNode<F> temp = head; temp != null; temp = temp.next){
                listOfElements = listOfElements + temp + temp.getContents() + ": " + "\n";
            }
            return listOfElements;
        }
    }

    //using the floor ID, we search through the list to find a match
    public Floor getFloorID(int id){
        GenericNode<Floor> temp = (GenericNode<Floor>)head;
        while(temp != null && temp.getContents().getFloorNum() != id){
            temp = temp.next;
        }
        if(temp == null)
            return null;
        return (Floor) temp.getContents();
    }

    public Aisle getAisleID(String id){
        GenericNode<Aisle> temp = (GenericNode<Aisle>) head;
        while(temp != null && temp.getContents().getAisleID() != id){
            temp = temp.next;
        }
        if(temp == null)
            return null;
        return (Aisle) temp.getContents();
    }

    public Shelf getShelfID(int id){
        GenericNode<Shelf> temp = (GenericNode<Shelf>) head;
        while(temp != null && temp.getContents().getShelfNum() != id){
            temp = temp.next;
        }
        if(temp == null)
            return null;
        return (Shelf) temp.getContents();
    }

    public Pallet getPalletGoods(String pallet){
        GenericNode<Pallet> temp = (GenericNode<Pallet>) head;
        while(temp != null && temp.getContents().getGoods() != pallet){
            temp = temp.next;
        }
        return null;
    }
}

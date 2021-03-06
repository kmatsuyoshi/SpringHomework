// Kayli Matsuyoshi
// APCS2 pd1
// HW 24 -- On the DLL
// 2018-03-26m

public class LList implements List{
     // inst vars
     private DLLNode _head;
     private int _size;

     // constructor
     public LList(){
          _head = new DLLNode();
          _size = 0;
     }

     //add node to list, containing input String as its data
     // this version adds to the front of the LList
     public boolean add( String x ){
          if (_size == 0){
               _head = new DLLNode(x);
          }
          else{
	      _head = new DLLNode(x, null, _head);
          }
          _size++;
          return true;
     }

     //insert a node containing newVal at position index
     public void add( int index, String newVal ){
          if (index < 0 || index > _size){
               throw new IndexOutOfBoundsException();
          }
          // if you want to add to front of LList
          if (index == 0){
               add(newVal);
               return;
          }
          DLLNode temp = _head;
          // iterate until you are one index away from inputted index
          for (int i = 0; i < index - 1; i++){
               temp = temp.getNext();
          }
          // insert DLLNode with cargo newVal at inputted index that points to
          // previous DLLNode at inputted index
          temp.setNext(new DLLNode(newVal, temp, temp.getNext()));
          _size++;

     }


     //remove node at pos index, return its cargo
     public String remove( int index ){
          if (index < 0 || index > _size){
               throw new IndexOutOfBoundsException();
          }
          String removed = _head.getCargo();
          DLLNode temp = _head;
	  if ( index == 0 ) {
	      removed = _head.getCargo();
	      _head.getNext().setPrev(null);
	      _head = _head.getNext();
	  }
	  else {
	      // iterate until you are one index away from inputted index
	      for (int i = 0; i < index - 1; i++){
		  temp = temp.getNext();
	      }
	      // skip DLLNode at inputted index - leave it for garbage
	      // point to DLLNode after inputted index
	      if ( temp.getNext() != null ) {
		  temp.getNext().setPrev(temp);
	      }
	  }
	  _size--;
	  return removed;
	  
     }

     //return data in element at position i
     public String get( int i ){
          if (_size == 0){
               throw new IndexOutOfBoundsException();
          }
          DLLNode old = _head;
          for (int j = 0; j < i; j++){
               old = old.getNext();
               if (old == null){
                    throw new IndexOutOfBoundsException();
               }
          }
          return old.getCargo();

     }

     //overwrite data in element at position i
     public String set( int i, String x ){
          if (_size == 0){
               throw new IndexOutOfBoundsException();
          }
          DLLNode old = _head;
          for (int j = 0; j < i; j++){
               old = old.getNext();
               if (old == null){
                    throw new IndexOutOfBoundsException();
               }
          }
          String prev = get(i);
          old.setCargo(x);
          return prev;
     }

     //return length of list
    public int size(){
	return _size;
    }

    // override inherited toString
    public String toString() {
	String retStr = "head--";
	DLLNode temp = _head; //init tr
	while( temp != null ) {
	    retStr += temp.getCargo() + "--";
	    temp = temp.getNext();
	}
	retStr += "NULL";
	return retStr;
        
    }

     public static void main(String[] args){
          LList wongton = new LList();
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add("moo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add("coo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.set(0, "bloo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add("blob");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.add(2, "boo");
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());

          wongton.remove(1);
          System.out.println(wongton);
          System.out.println("size: " + wongton.size());
     }
}

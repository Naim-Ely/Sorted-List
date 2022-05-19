//Naim El Youssoufi, ne4
//Section 010
public class SortedList<E extends Comparable<? super E>> extends List<E>
{
   private void insert(Node<E> previous, Node<E> curr, Node<E> node)
   {
      if (curr == null)
      {
         curr = node;
      }
      if (curr == node || node.data.compareTo(curr.data)<0)
      {
         if (previous == null)
         {
            node.next = head;
            head = node;
         }
         else
         {
            node.next = previous.next;
            previous.next = node;
         }
      }  
      else
      {
         insert(curr, curr.next, node);
      }
   }
   public void insert(E value)
   {
      Node<E> temp = new Node<E>(value);
      insert(null, head, temp);
   }
   private void remove(Node<E> previous, Node<E> curr, E temp)
   {
      if (curr == null)
      {
         return;
      }
      if (curr.data.compareTo(temp) == 0)
      {
         if(previous == null)
         {
            head=curr.next;
         }
         else
         {
            previous.next=curr.next;
         }
      }
      else if(curr.data.compareTo(temp) > 0)
      {
         return;
      }
      else
      {
         remove(curr, curr.next, temp);
      }
   }
   public void remove(E temp)
   {
      remove(null, head, temp);
   }
   private boolean search(Node<E> node, E temp)
   {
      if (node==null)
      {
         return false;
      }
      if(node.data.equals(temp))
      {
         return true;
      }
      else
      {
         return search(node.next, temp);
      }
   }
   public boolean search(E temp)
   {
      return search(head, temp);
   }
   /////////////////////////////////////////////////////////////////////////////////////
   private E retrieve(int index, int count, Node<E> curr)
   {
     if(head == null)
     {
       return null;
     }
     if (index == count)
     {
       return curr.data;
     }
     if (curr.next==null)
     {
      return null;
     }
     count=count+1;
     return retrieve(index, count, curr.next);
   }
   public E retrieve(int index) 
   {
     int count = 0;
     return retrieve(index, count, head);
   }
   /////////////////////////////////////////////////////////////////////////////////////
   public java.util.Iterator<E> iterator() 
   {
     return new Iterator();
   }
   class Iterator implements java.util.Iterator<E>
   {
      Node<E> curr = head; 
      public boolean hasNext() 
      {
        return curr != null;
      }
      public E next() 
      {
        E value = curr.data;
        curr = curr.next;
        return value;
      }
   }
}
      
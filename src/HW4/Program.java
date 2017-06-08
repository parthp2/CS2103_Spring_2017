package HW4;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program 
{
 public static void main(String[] args) throws IOException 
 {
  @SuppressWarnings("resource")
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter a file name: ");
  String fname = sc.nextLine();

  File file = new File(fname);
  
  if (!file.exists())
  {
   System.out.println("File " + fname + " does not exist");
   System.exit(1);
  }
  
  DataInputStream inFile = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
  int s = inFile.available();
  byte[] b = new byte[s];
  inFile.read(b);
  inFile.close();
  
  int[] cnts = getCharacterFrequency(new String(b));

  System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character","Frequency", "Code");

  Tree tree = getHuffmanTree(cnts); 
  String[] codes = getCode(tree.r); 
  
  for (int i = 0; i < codes.length; i++)
   if (cnts[i] != 0) 
    System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char) i + "",
      cnts[i], codes[i]);
 }


 public static String[] getCode(Tree.Node r) 
 {
  if (r == null)
  {
   return null;
  }
  String[] codes = new String[2 * 128];
  assignCode(r, codes);
  return codes;
 }

 
 private static void assignCode(Tree.Node r, String[] code) {
  if (r.l!= null) {
   r.l.code = r.code + "0";
   assignCode(r.l, code);

   r.r.code = r.code + "1";
   assignCode(r.r, code);
  } else {
   code[(int) r.e] = r.code;
  }
 }

 /** Get a Huffman tree from the codes */
 public static Tree getHuffmanTree(int[] c) {
 
  Heap<Tree> heap = new Heap<Tree>(); 
  for (int i = 0; i < c.length; i++) 
  {
   if (c[i] > 0)
   {
    heap.add(new Tree(c[i], (char) i));
   }
  }

  while (heap.getSize() > 1)
  {
   Tree t1 = heap.remove(); 
   Tree t2 = heap.remove(); 
   heap.add(new Tree(t1, t2)); 
  }

  return heap.remove();
 }


 public static int[] getCharacterFrequency(String txt)
 {
  int[] count = new int[256];

  for (int i = 0; i < txt.length(); i++)
  {
   count[(int) txt.charAt(i)]++; 
  }
  return count;
 }


 public static class Tree implements Comparable<Tree>
 {
  Node r; 

 
  public Tree(Tree t1, Tree t2) 
  {
   r = new Node();
   r.l = t1.r;
   r.r = t2.r;
   r.w = t1.r.w + t2.r.w;
  }

  
  public Tree(int w, char e) {
   r = new Node(w, e);
  }

  @Override
 
  public int compareTo(Tree t) 
  {
   if (r.w < t.r.w) 
   {
    return 1;
   }
   else if (r.w == t.r.w)
   {
    return 0;
   }
   else
   {
    return -1;
   }
  }

  public class Node {
   char e; 
   int w; 
   Node l; 
   Node r; 
   String code = ""; 

  
   public Node()
   {
   }

  
   public Node(int weight, char element) {
    this.w = weight;
    this.e = element;
   }
  }
 }

 static class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();


  public Heap()
  {
  }

 
  public Heap(E[] objects)
  {
   for (int i = 0; i < objects.length; i++)
   {
    add(objects[i]);
   }
  }

  
  public void add(E newObj)
  {
   list.add(newObj);
   int cIndex = list.size() - 1; 

   while (cIndex > 0) 
   {
    int pIndex = (cIndex - 1) / 2;
   
    if (list.get(cIndex).compareTo(list.get(pIndex)) > 0)
    {
     E temp = list.get(cIndex);
     list.set(cIndex, list.get(pIndex));
     list.set(pIndex, temp);
    } 
    else
    {
     break;
    }

    cIndex = pIndex;
   }
  }

  
  public E remove() {
   if (list.size() == 0)
    return null;

   E removedObject = list.get(0);
   list.set(0, list.get(list.size() - 1));
   list.remove(list.size() - 1);

   int currentIndex = 0;
   while (currentIndex < list.size()) {
    int leftChildIndex = 2 * currentIndex + 1;
    int rightChildIndex = 2 * currentIndex + 2;

    
    if (leftChildIndex >= list.size())
    {
     break; 
    }
    int maxIndex = leftChildIndex;
    if (rightChildIndex < list.size()) {
     if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
      maxIndex = rightChildIndex;
     }
    }

  
    if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0)
    {
     E temp = list.get(maxIndex);
     list.set(maxIndex, list.get(currentIndex));
     list.set(currentIndex, temp);
     currentIndex = maxIndex;
    } 
    else
    {
     break; 
    }
   }

   return removedObject;
  }

 
  public int getSize() {
   return list.size();
  }
 }
}
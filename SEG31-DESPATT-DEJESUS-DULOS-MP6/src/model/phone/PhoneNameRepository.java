package model.phone;
import utility.SingletonDB;
import java.util.Iterator; 

public class PhoneNameRepository implements Container {
	
	private static String names[] = {};
	
		public PhoneNameRepository() {
			// TODO Auto-generated constructor stub
			setName();
		}
	   public static void setName() {
		   
		   System.out.println("PhoneNameRepository");
		   int count = 0;
		   count = SingletonDB.getPhoneRow();
		   String PhoneNames[] = new String[count];
		   System.out.println("Phone Name Rep Count: "+count);
		   for(int i = 1; i<= count; i++){
			   System.out.println("i Rep Count: "+i);
			   String phoneName = SingletonDB.getPhoneName(i);
			   PhoneNames[i-1] = phoneName;
			   System.out.println("Phone name inside the name repository: " + phoneName);
		   }
		   names = PhoneNames;
		   for(int i =0; i< PhoneNames.length;i++) {
			   System.out.println("STATIC NAMES PHONE REP: " + names[i]);
		   }
	   }
	   
	  
	  
	   public static class CollectionofNamesIterate implements Iterator<String> {
		   
		   private int currentElement = 0;
		   private PhoneNameRepository namesRepository;

		   public CollectionofNamesIterate(PhoneNameRepository namesRepository) {
		   super();
		   this.namesRepository = namesRepository;
		           }
		           @Override
		           public boolean hasNext() {

		               if (currentElement < namesRepository.names.length) {
	                   return true;
		               }

		               return false;

		           }

		          @Override
		          public String next() {
		               if (this.hasNext()) {
		                   return namesRepository.names[currentElement++];
		               }
		               return null;
		           }
		 }

	@Override
	public Iterator<String> getIterator() {
		// TODO Auto-generated method stub
		return new CollectionofNamesIterate(this);
	}
	}
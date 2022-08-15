// Ref: https://www.digitalocean.com/community/tutorials/java-8-features-with-examples

package com.journaldev.java8.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEachExample {

	public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
	}

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}
}


default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }
}




package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile-time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}
	
}



package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}




package com.journaldev.java8.defaultmethod;

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
	}
	
}






Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("My Runnable");
			}};
Copy
Since functional interfaces have only one method, lambda expressions can easily provide the method implementation. We just need to provide method arguments and business logic. For example, we can write above implementation using lambda expression as:

Runnable r1 = () -> {
			System.out.println("My Runnable");
		};


Interface1 i1 = (s) -> System.out.println(s);		
i1.method1("abc");



package com.journaldev.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		//using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		//using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel="+p));
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

	}

}






-> Concurrency API improvements  (FutureCompletableFuture)

Some important concurrent API enhancements are:

ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search() methods.
CompletableFuture that may be explicitly completed (setting its value and status).
Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its target parallelism level.


-> Java IO improvements

Some IO improvements known to me are:

Files.list(Path dir) that returns a lazily populated Stream, the elements of which are the entries in the directory.
Files.lines(Path path) that reads all lines from a file as a Stream.
Files.find() that returns a Stream that is lazily populated with Path by searching for files in a file tree rooted at a given starting file.
BufferedReader.lines() that return a Stream, the elements of which are lines read from this BufferedReader.







Some miscellaneous API improvements that might come handy are:

ThreadLocal static method withInitial(Supplier supplier) to create instances easily.
The Comparator interface has been extended with a lot of default and static methods for natural ordering, reverse order, etc.
min(), max() and sum() methods in Integer, Long and Double wrapper classes.
logicalAnd(), logicalOr() and logicalXor() methods in Boolean class.
ZipFile.stream() method to get an ordered Stream over the ZIP file entries. Entries appear in the Stream in the order they appear in the central directory of the ZIP file.
Several utility methods in Math class.
jjs command is added to invoke Nashorn Engine.
jdeps command is added to analyze class files
JDBC-ODBC Bridge has been removed.
PermGen memory space has been removed

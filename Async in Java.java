// TODO: https://www.baeldung.com/java-asynchronous-programming

ExecutorService threadpool = Executors.newCachedThreadPool();
Future<Long> futureTask = threadpool.submit(() -> someFunction(number));

while (!futureTask.isDone()) {
    System.out.println("FutureTask is not finished yet..."); 
} 
long result = futureTask.get(); 

threadpool.shutdown();



// Completable Future We don't need to use the ExecutorService explicitly. The CompletableFuture internally uses ForkJoinPool 
//to handle the task asynchronously. Thus, it makes our code a lot cleaner.

CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> someFunction(number));
while (!completableFuture.isDone()) {
    System.out.println("CompletableFuture is not finished yet...");
}
long result = completableFuture.get();

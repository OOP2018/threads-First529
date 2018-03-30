## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  | 10000000           | 0.011338        |
| Using ReentrantLock     | 10000000           | 0.888428        |
| Synchronized method     | 10000000           | 0.791209        |
| AtomicLong for total    | 10000000           | 0.245051        |

## 1. Using unsynchronized counter object

Unfortunately, the total isn't zero, the value varies between negative and positive integer.
Because sometimes these threads are calling the Counter class at the same time and return value of each methods at a different rate, so that the total value would be override. 

## 2. Implications for Multi-threaded Applications

In the banking system, if there are 2 or more financial transaction occur then there would be a glitch in the system. For instance, if you have 0 baht in your bank account and you some how manage to withdraw and deposit at the same time let say 2000 baht. In the end you would have -2000 baht in your bank and 2000 baht in your purse. 

## 3. Counter with ReentrantLock

The total is always zero. The results are different from problem 1 because it never calls total from the Counter class at the same time. For instance, if there are 3 threads, if thread1 is computing thread2 and thread3 need to wait for thread1 to finish first then it will select the slowest thread to compute next. 
"finally { lock.unlock(); }" in the code means that it will unlock when everything is done.

## 4. Counter with synchronized method

The total is zero. The result is different from problem 1 but similar to problem 3 as it execute only one thread at a time. However, if the first thread is finish computing thread2 and thread3 will be randomized to select which one is going to be compute next. 
Synchronized means cause or occur at the same rate and time.

## 5. Counter with AtomicLong

It's comparing the value from the total and value from the memory whether it's the same or not, if it's then it either add or subtract base on the thread, if not then it will skip until it's the same.
It's the fastest way to compute a numerical value.

## 6. Analysis of Results

Rank from slowest to fastest: ReentrantLock --> Synchronized --> AtomicLong

ReentrantLock might be the slowest among these three to compute numerical value. However, it would be the most efficient in my opinion to applied to the broadest range of problems, it's computing one thread at a time and also compute the slowest one first, but in AtomicLong if we have a every complex method or object to compute I would say that it will be the slowest of all.

## 7. Using Many Threads (optional)


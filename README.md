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
Because sometimes these threads are calling the Counter class at the same time and return value of each methods at a different rate, so that the total value wouldn't be zero. 

## 2. Implications for Multi-threaded Applications

How might this affect real applications?  

## 3. Counter with ReentrantLock

The total is always zero. The results are different from problem 1 because it never calls the Counter class at the same time. For instance, if thread1 is computing thread2 need to wait for thread1 to finish first then the lock will unlock itself then thread2 can calls the Counter class.   

## 4. Counter with synchronized method

The total is zero. The result is different from problem 1 because it runs only one thread at a time, so that the total counter is compute from each of the threads which will eventually negate each others.
Synchronized means cause or occur at the same rate and time.

## 5. Counter with AtomicLong

answer question 5

## 6. Analysis of Results

answer question 6

## 7. Using Many Threads (optional)


#!/bin/sh
ITER=10000

ADD=1
REMOVE=1
CONTAINS=2
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=3
REMOVE=2
CONTAINS=3
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=3
REMOVE=3
CONTAINS=4
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=5
REMOVE=5
CONTAINS=6
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=10
REMOVE=10
CONTAINS=13
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=9
REMOVE=8
CONTAINS=11
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=10
REMOVE=10
CONTAINS=14
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=12
REMOVE=12
CONTAINS=16
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

#!/bin/sh
ITER=10000

ADD=2
REMOVE=1
CONTAINS=1
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=3
REMOVE=3
CONTAINS=2
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=4
REMOVE=4
CONTAINS=2
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=7
REMOVE=6
CONTAINS=3
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=13
REMOVE=13
CONTAINS=7
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=11
REMOVE=11
CONTAINS=6
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=14
REMOVE=13
CONTAINS=7
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

ADD=16
REMOVE=16
CONTAINS=8
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER

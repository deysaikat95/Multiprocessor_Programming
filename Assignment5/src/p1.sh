#!/bin/sh
ITER=10000

rm -rf p1
mkdir p1

ADD=2
REMOVE=1
CONTAINS=1
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=3
REMOVE=3
CONTAINS=2
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=4
REMOVE=4
CONTAINS=2
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=7
REMOVE=6
CONTAINS=3
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=13
REMOVE=13
CONTAINS=7
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=11
REMOVE=11
CONTAINS=6
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=14
REMOVE=13
CONTAINS=7
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

ADD=16
REMOVE=16
CONTAINS=8
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p1/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p1/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p1/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p1/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p1/LockFreeList

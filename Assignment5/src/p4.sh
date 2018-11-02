#!/bin/sh
ITER=10000

rm -rf p4
mkdir p4

ADD=1
REMOVE=0
CONTAINS=3
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=1
REMOVE=1
CONTAINS=6
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=1
REMOVE=1
CONTAINS=8
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=2
REMOVE=1
CONTAINS=13
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=4
REMOVE=3
CONTAINS=26
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=3
REMOVE=3
CONTAINS=22
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=4
REMOVE=3
CONTAINS=27
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

ADD=4
REMOVE=4
CONTAINS=32
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p4/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p4/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p4/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p4/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p4/LockFreeList

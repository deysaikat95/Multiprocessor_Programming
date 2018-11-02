#!/bin/sh
ITER=10000

rm -rf p5
mkdir p5

ADD=8
REMOVE=8
CONTAINS=4
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p5/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p5/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p5/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p5/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p5/LockFreeList

ADD=6
REMOVE=6
CONTAINS=8
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p5/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p5/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p5/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p5/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p5/LockFreeList

ADD=4
REMOVE=4
CONTAINS=12
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p5/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p5/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p5/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p5/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p5/LockFreeList

ADD=2
REMOVE=2
CONTAINS=16
echo "ADD:$ADD REMOVE:$REMOVE CONTAINS:$CONTAINS"
java -cp ".:/usr/share/java/junit4.jar" lists.Main CoarseList $ADD $REMOVE $CONTAINS $ITER >> p5/CoarseList
java -cp ".:/usr/share/java/junit4.jar" lists.Main FineList $ADD $REMOVE $CONTAINS $ITER >> p5/FineList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LazyList $ADD $REMOVE $CONTAINS $ITER >> p5/LazyList
java -cp ".:/usr/share/java/junit4.jar" lists.Main OptimisticList $ADD $REMOVE $CONTAINS $ITER >> p5/OptimisticList
java -cp ".:/usr/share/java/junit4.jar" lists.Main LockFreeList $ADD $REMOVE $CONTAINS $ITER >> p5/LockFreeList


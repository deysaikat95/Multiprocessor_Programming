set terminal postscript eps enhanced color dashed lw 3 "Helvetica" 24

set style data linespoints
set style line 1 pointtype 10 linecolor rgbcolor 'blue'
set style line 2 pointtype 8 linecolor rgbcolor 'red'
set style line 3 pointtype 6 linecolor rgbcolor 'black'
set style line 4 pointtype 4 linecolor rgbcolor 'orange'
set style line 5 pointtype 2 linecolor rgbcolor 'green'
set output 'plots/p5_results.pdf'

set grid
set pointsize 2

set key top right inside
list = 'p5/CoarseList p5/FineList p5/LazyList p5/OptimisticList p5/LockFreeList'

set xlabel 'Contains (%)'
set ylabel 'Throughput (M Ops/s)'
set xtics 20,20,80
set xrange [20:80]
set yrange [0:500]
plot for [i=1:words(list)] word(list,i) using ($1):($2) \
title word('CoarseList FineList LazyList OptimisticList LockFreeList', i) linestyle i

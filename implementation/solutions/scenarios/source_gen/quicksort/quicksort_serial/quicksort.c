#include "quicksort.h"


#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

typedef struct quicksort_Item quicksort_Item_t;
struct quicksort_Item {
  int32_t value;
};

static void quicksort_doHeavyWork(void);

static bool quicksort_biggerThan(quicksort_Item_t item1, quicksort_Item_t item2);

static void quicksort_printItems(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t start, int32_t end);

static void quicksort_initItems(quicksort_Item_t items[QUICKSORT_numberOfItems]);

static void quicksort_quickSort(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t left, int32_t right);

static void quicksort_swap(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t i, int32_t j);

static int32_t quicksort_partition(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t left, int32_t right);

int32_t main(int32_t argc, char* argv[]) 
{
  struct timeval begin;
  gettimeofday(&begin, 0);
  quicksort_Item_t items[QUICKSORT_numberOfItems];
  quicksort_initItems(items);
  
  
  quicksort_quickSort(items, 0, QUICKSORT_numberOfItems - 1);
  
  struct timeval end;
  gettimeofday(&end, 0);
  double timeSpent = ((double)((end.tv_usec - begin.tv_usec))) / 1000000 + ((double)((end.tv_sec - begin.tv_sec)));
  printf("\n#### duration %f\n\n", timeSpent);
  
  
  return 0;
}

static void quicksort_doHeavyWork(void) 
{
  for ( int8_t __i = 0; __i < QUICKSORT_heavyWorkSize; __i++ )
  {
    for ( int8_t __j = 0; __j < QUICKSORT_heavyWorkSize; __j++ )
    {
      __j * __j * __j;
    }
  }
}

static bool quicksort_biggerThan(quicksort_Item_t item1, quicksort_Item_t item2) 
{
  quicksort_doHeavyWork();
  return item1.value > item2.value;
}

static void quicksort_printItems(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t start, int32_t end) 
{
  for ( int32_t __i = start; __i < end; __i++ )
  {
    printf("%d |  %d\n", __i, items[__i].value);
  }
}

static void quicksort_initItems(quicksort_Item_t items[QUICKSORT_numberOfItems]) 
{
  for ( int16_t __i = 0; __i < QUICKSORT_numberOfItems; __i++ )
  {
    items[__i].value = rand();
  }
}

static void quicksort_quickSort(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t left, int32_t right) 
{
  if ( left < right ) 
  {
    int32_t middle = quicksort_partition(items, left, right);
    
    quicksort_quickSort(items, left, middle - 1);
    quicksort_quickSort(items, middle + 1, right);
  }
}

static void quicksort_swap(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t i, int32_t j) 
{
  quicksort_Item_t temp = items[i];
  items[i] = items[j];
  items[j] = temp;
}

static int32_t quicksort_partition(quicksort_Item_t items[QUICKSORT_numberOfItems], int32_t left, int32_t right) 
{
  quicksort_Item_t pivot = items[left];
  int32_t i = left;
  int32_t j = right + 1;
  
  while (true)
  {
    do{
      ++i;
    } while (!(quicksort_biggerThan(items[i], pivot)) && i < right);
    do{
      --j;
    } while (quicksort_biggerThan(items[j], pivot));
    if ( i >= j ) 
    {
      break;
    }
    quicksort_swap(items, i, j);
  }
  
  if ( left != j ) 
  {
    quicksort_swap(items, left, j);
  }
  return j;
}


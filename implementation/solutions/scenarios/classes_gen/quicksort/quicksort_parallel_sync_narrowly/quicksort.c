#include "quicksort.h"


#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include "GenericTaskDeclarations.h"
#include "GenericSharedDeclarations.h"
#include "GenericSyncDeclarations.h"
#include "quicksort_SharedTypes_0.h"
#include <stdlib.h>

typedef struct quicksort_Args_a0a0c0a0h quicksort_Args_a0a0c0a0h_t;
struct quicksort_Args_a0a0c0a0h {
  quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items;
  int32_t left;
  int32_t middle;
};

typedef struct quicksort_Args_a0b0c0a0h quicksort_Args_a0b0c0a0h_t;
struct quicksort_Args_a0b0c0a0h {
  quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items;
  int32_t middle;
  int32_t right;
};

static void quicksort_initItems(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items);

static void quicksort_printItems(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t start, int32_t end);

static void quicksort_quickSort(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t left, int32_t right);

static int32_t quicksort_partition(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t left, int32_t right);

static bool quicksort_biggerThan(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t index1, int32_t index2);

static void quicksort_swap(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t i, int32_t j);

static void quicksort_doHeavyWork(void);

static void* quicksort_parFun_a0a0c0a0h(void* voidArgs);

static void* quicksort_parFun_a0b0c0a0h(void* voidArgs);

static GenericTaskDeclarations_VoidFuture_t quicksort_futureInit_a0a2a0a7(int32_t middle, int32_t left, quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items);

static GenericTaskDeclarations_VoidFuture_t quicksort_futureInit_a1a2a0a7(int32_t middle, int32_t right, quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items);

int32_t main(int32_t argc, char* argv[]) 
{
  pthread_mutexattr_init(&GenericSharedDeclarations_mutexAttribute_0);
  pthread_mutexattr_settype(&GenericSharedDeclarations_mutexAttribute_0,PTHREAD_MUTEX_RECURSIVE);
  struct timeval begin;
  gettimeofday(&begin, 0);
  
  quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t items;
  quicksort_SharedTypes_0_mutexInit_1(&items);
  /* 
   * Two perfomance issues exist: multiple syncs are basically unnecessary:
   *   1. the synchronization of the items variable which is only used in read mode
   *      => causes unnecessary serialization (crucial)
   *   2. the synchronization of each value although every one is accessed by exactly one thread
   *      => causes unnecessary work (minor here, since dominated by doHeavyWork())
   */

  quicksort_initItems(&items);
  
  
  quicksort_quickSort(&items, 0, QUICKSORT_numberOfItems - 1);
  
  struct timeval end;
  gettimeofday(&end, 0);
  double timeSpent = ((double)((end.tv_usec - begin.tv_usec))) / 1000000 + ((double)((end.tv_sec - begin.tv_sec)));
  printf("\n#### duration %f\n\n", timeSpent);
  
  
  return 0;
}

static void quicksort_initItems(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items) 
{
  for ( int16_t __i = 0; __i < QUICKSORT_numberOfItems; __i++ )
  {
    {
      quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* myItems = items;
      {
        {
          quicksort_SharedTypes_0_SharedOf_Item_0_t* itemI = &myItems->value[__i];
          GenericSyncDeclarations_startSyncFor1Mutex(&(itemI)->mutex);
          {
            itemI->value.value = rand();
          }
          GenericSyncDeclarations_stopSyncFor1Mutex(&(itemI)->mutex);
        }
      }
    }
  }
}

static void quicksort_printItems(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t start, int32_t end) 
{
  /* 
   * As long as printItems is not actually called, the compiler cannot decide whether the synchronization resource myItems is actually read-only. This results from the fact that the alias-set for myItems stays empty.
   * => No optimization here!
   */

  {
    quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* myItems = items;
    GenericSyncDeclarations_startSyncFor1Mutex(&(myItems)->mutex);
    {
      for ( int32_t __i = start; __i < end; __i++ )
      {
        {
          quicksort_SharedTypes_0_SharedOf_Item_0_t* itemI = &myItems->value[__i];
          GenericSyncDeclarations_startSyncFor1Mutex(&(itemI)->mutex);
          {
            printf("%d |  %d\n", __i, itemI->value.value);
          }
          GenericSyncDeclarations_stopSyncFor1Mutex(&(itemI)->mutex);
        }
      }
    }
    GenericSyncDeclarations_stopSyncFor1Mutex(&(myItems)->mutex);
  }
}

static void quicksort_quickSort(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t left, int32_t right) 
{
  if ( left < right ) 
  {
    int32_t middle = quicksort_partition(items, left, right);
    
    if ( middle - left > QUICKSORT_threshold && right - middle > QUICKSORT_threshold ) 
    {
      GenericTaskDeclarations_VoidFuture_t sorter1 = quicksort_futureInit_a0a2a0a7(middle, left, items);
      GenericTaskDeclarations_VoidFuture_t sorter2 = quicksort_futureInit_a1a2a0a7(middle, right, items);
      GenericTaskDeclarations_joinVoidFuture(&sorter1);
      GenericTaskDeclarations_joinVoidFuture(&sorter2);
    }    else 
    {
      quicksort_quickSort(items, left, middle - 1);
      quicksort_quickSort(items, middle + 1, right);
    }
  }
}

static int32_t quicksort_partition(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t left, int32_t right) 
{
  quicksort_SharedTypes_0_SharedOf_Item_0_t* pivot;
  {
    quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* myItems = items;
    quicksort_SharedTypes_0_SharedOf_Item_0_t* itemLeft = &myItems->value[left];
    GenericSyncDeclarations_startSyncFor1Mutex(&(itemLeft)->mutex);
    {
      pivot = itemLeft;
    }
    GenericSyncDeclarations_stopSyncFor1Mutex(&(itemLeft)->mutex);
  }
  int32_t i = left;
  int32_t j = right + 1;
  
  while (true)
  {
    do{
      ++i;
    } while (!(quicksort_biggerThan(items, i, left)) && i < right);
    do{
      --j;
    } while (quicksort_biggerThan(items, j, left));
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

static bool quicksort_biggerThan(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t index1, int32_t index2) 
{
  /* 
   * Although the non-synced doHeavyWork() should dominate everything else time-wise, the 
   * synchronization overhead adds so much time that the program is almost as slow as the 
   * serial one.
   */

  {
    quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* myItems = items;
    {
      quicksort_doHeavyWork();
      {
        quicksort_SharedTypes_0_SharedOf_Item_0_t* item1 = &myItems->value[index1];
        quicksort_SharedTypes_0_SharedOf_Item_0_t* item2 = &myItems->value[index2];
        GenericSyncDeclarations_startSyncFor2Mutexes(&(item1)->mutex, &(item2)->mutex);
        {
          GenericSyncDeclarations_stopSyncFor2Mutexes(&(item1)->mutex, &(item2)->mutex);
          return item1->value.value > item2->value.value;
        }
        GenericSyncDeclarations_stopSyncFor2Mutexes(&(item1)->mutex, &(item2)->mutex);
      }
    }
  }
  return false;
}

static void quicksort_swap(quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items, int32_t i, int32_t j) 
{
  {
    quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* myItems = items;
    {
      {
        quicksort_SharedTypes_0_SharedOf_Item_0_t* itemI = &myItems->value[i];
        quicksort_SharedTypes_0_SharedOf_Item_0_t* itemJ = &myItems->value[j];
        GenericSyncDeclarations_startSyncFor2Mutexes(&(itemI)->mutex, &(itemJ)->mutex);
        {
          quicksort_SharedTypes_0_Item_t temp = itemI->value;
          temp = itemI->value;
          itemI->value = itemJ->value;
          itemJ->value = itemI->value;
        }
        GenericSyncDeclarations_stopSyncFor2Mutexes(&(itemI)->mutex, &(itemJ)->mutex);
      }
    }
  }
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

static void* quicksort_parFun_a0a0c0a0h(void* voidArgs) 
{
  quicksort_Args_a0a0c0a0h_t* args = ((quicksort_Args_a0a0c0a0h_t*)(voidArgs));
  quicksort_quickSort((args)->items, (args)->left, (args)->middle - 1);
  free(voidArgs);
  return 0;
}

static void* quicksort_parFun_a0b0c0a0h(void* voidArgs) 
{
  quicksort_Args_a0b0c0a0h_t* args = ((quicksort_Args_a0b0c0a0h_t*)(voidArgs));
  quicksort_quickSort((args)->items, (args)->middle + 1, (args)->right);
  free(voidArgs);
  return 0;
}

static GenericTaskDeclarations_VoidFuture_t quicksort_futureInit_a0a2a0a7(int32_t middle, int32_t left, quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items) 
{
  quicksort_Args_a0a0c0a0h_t* args_a0a2a0a7 = malloc(sizeof(quicksort_Args_a0a0c0a0h_t));
  args_a0a2a0a7->middle = middle;
  args_a0a2a0a7->items = items;
  args_a0a2a0a7->left = left;
  pthread_t pth;
  pthread_create(&pth,0,&quicksort_parFun_a0a0c0a0h,args_a0a2a0a7);
  return (GenericTaskDeclarations_VoidFuture_t){ .pth =pth};
}

static GenericTaskDeclarations_VoidFuture_t quicksort_futureInit_a1a2a0a7(int32_t middle, int32_t right, quicksort_SharedTypes_0_SharedOf_ArrayOf_SharedOf_Item_0_0_t* items) 
{
  quicksort_Args_a0b0c0a0h_t* args_a1a2a0a7 = malloc(sizeof(quicksort_Args_a0b0c0a0h_t));
  args_a1a2a0a7->middle = middle;
  args_a1a2a0a7->items = items;
  args_a1a2a0a7->right = right;
  pthread_t pth;
  pthread_create(&pth,0,&quicksort_parFun_a0b0c0a0h,args_a1a2a0a7);
  return (GenericTaskDeclarations_VoidFuture_t){ .pth =pth};
}


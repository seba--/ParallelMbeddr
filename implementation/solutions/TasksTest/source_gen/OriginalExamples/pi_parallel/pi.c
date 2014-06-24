#include "pi.h"


#include "queue.h"
#include "GenericTaskDeclarations.h"
#include "GenericSharedDeclarations.h"
#include "GenericSyncDeclarations.h"
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

struct pi_Args_a0a0k0f {
  struct GenericSharedDeclarations_SharedOf_uint32_0* counterPointer;
  struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer;
};

struct pi_Args_a61a5 {
  struct GenericSharedDeclarations_SharedOf_long_double_0* resultPointer;
  struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer;
};

static char* pi_calcError(long double correctValue,long double approxedValue);

static void pi_map(uint32_t threshold,struct GenericSharedDeclarations_SharedOf_uint32_0* counter,struct queue_SharedTypes_0_SharedOf_Queue_0* resultQueue);

static char* pi_reduce(uint32_t numberOfItems,struct GenericSharedDeclarations_SharedOf_long_double_0* result,struct queue_SharedTypes_0_SharedOf_Queue_0* resultQueue);

static void pi_calcPiBlock(long double* result,uint32_t start,uint32_t end);

static void pi_calcPiItem(long double* piItem,uint32_t index);

static void* pi_parFun_a61a5(void* voidArgs);

static void* pi_parFun_a0a0k0f(void* voidArgs);

static inline void pi_init_queue_0(struct queue_SharedTypes_0_SharedOf_Queue_0* queue);

static inline void pi_destroy_queue_0(struct queue_SharedTypes_0_SharedOf_Queue_0* queue);

static inline void pi_init_counter_0(struct GenericSharedDeclarations_SharedOf_uint32_0* counter);

static inline void pi_destroy_counter_0(struct GenericSharedDeclarations_SharedOf_uint32_0* counter);

static inline void pi_init_result_0(struct GenericSharedDeclarations_SharedOf_long_double_0* result);

static inline void pi_destroy_result_0(struct GenericSharedDeclarations_SharedOf_long_double_0* result);

static inline struct GenericTaskDeclarations_Task pi_taskInit_a0a0k0f(struct GenericSharedDeclarations_SharedOf_uint32_0* counterPointer,struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer);

static inline struct GenericTaskDeclarations_Task pi_taskInit_a61a5(struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer,struct GenericSharedDeclarations_SharedOf_long_double_0* resultPointer);

int32_t main(int32_t argc, char* argv[]) 
{
  struct queue_SharedTypes_0_SharedOf_Queue_0 queue;
  pi_init_queue_0(&queue);
  queue_queueInit(&queue);
  struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer = &queue;
  
  struct GenericSharedDeclarations_SharedOf_uint32_0 counter;
  pi_init_counter_0(&counter);
  struct GenericSharedDeclarations_SharedOf_uint32_0* counterPointer = &counter;
  GenericSyncDeclarations_startSyncFor1Mutex(&counter.mutex);
  {
    counter.value = 0;
  }

  GenericSyncDeclarations_stopSyncFor1Mutex(&counter.mutex);
  
  struct GenericTaskDeclarations_Task mapperTasks[PI_MAPPERCOUNT];
  struct GenericTaskDeclarations_VoidFuture mappers[PI_MAPPERCOUNT];
  for ( int32_t i = 0; i < PI_MAPPERCOUNT; ++i )
  {
    mapperTasks[i] = pi_taskInit_a0a0k0f(counterPointer, queuePointer);
    mappers[i] = GenericTaskDeclarations_runTaskAndGetVoidFuture(mapperTasks[i]);
    free(mapperTasks[i].args);
  }

  
  struct GenericSharedDeclarations_SharedOf_long_double_0 result;
  pi_init_result_0(&result);
  GenericSyncDeclarations_startSyncFor1Mutex(&result.mutex);
  {
    result.value = 0;
  }

  GenericSyncDeclarations_stopSyncFor1Mutex(&result.mutex);
  struct GenericSharedDeclarations_SharedOf_long_double_0* resultPointer = &result;
  
  struct GenericTaskDeclarations_Task reducerTask = pi_taskInit_a61a5(queuePointer, resultPointer);
  struct GenericTaskDeclarations_Future reducer = GenericTaskDeclarations_runTaskAndGetFuture(reducerTask);
  free(reducerTask.args);
  
  for ( int32_t i = 0; i < PI_MAPPERCOUNT; ++i )
  {
    GenericTaskDeclarations_joinVoidFuture(&mappers[i]);
  }

  int8_t** pointerToErrorString = ((int8_t**)(GenericTaskDeclarations_getFutureResult(&reducer)));
  printf("total error: %s\n",*pointerToErrorString);
  
  free(*pointerToErrorString);
  free(pointerToErrorString);
  
  queue_queueClear(&queue);
  
  pi_destroy_queue_0(&queue);
  pi_destroy_counter_0(&counter);
  pi_destroy_result_0(&result);
  return 0;
}


static char* pi_calcError(long double correctValue, long double approxedValue) 
{
  long double error = correctValue - approxedValue;
  char* result = malloc(52 * sizeof(char));
  snprintf(result,50,"%.50Lf",error);
  return result;
}


static void pi_map(uint32_t threshold, struct GenericSharedDeclarations_SharedOf_uint32_0* counter, struct queue_SharedTypes_0_SharedOf_Queue_0* resultQueue) 
{
  long double result = 0;
  
  while (1)
  {
    uint32_t start;
    uint32_t end;
    
    GenericSyncDeclarations_startSyncFor1Mutex(&counter->mutex);
    {
      start = counter->value;
      if ( start == threshold ) 
      {
        GenericSyncDeclarations_stopSyncFor1Mutex(&counter->mutex);
        break;
      }

      uint32_t possibleEnd = start + PI_BLOCKSIZE;
      end = (possibleEnd <= threshold) ? (possibleEnd) : (threshold);
      counter->value = end;
    }

    GenericSyncDeclarations_stopSyncFor1Mutex(&counter->mutex);
    
    result = 0;
    pi_calcPiBlock(&result, start, end);
    queue_queueSafeAdd(resultQueue, result);
  }

}


static char* pi_reduce(uint32_t numberOfItems, struct GenericSharedDeclarations_SharedOf_long_double_0* result, struct queue_SharedTypes_0_SharedOf_Queue_0* resultQueue) 
{
  long double item;
  char* error;
  
  GenericSyncDeclarations_startSyncFor1Mutex(&result->mutex);
  {
    for ( uint32_t i = 0; i < numberOfItems; ++i )
    {
      queue_queueSafeGet(resultQueue, &item);
      result->value = item + result->value;
    }

    
    printf("result: %.50Lf\n\n",result->value);
    
    error = pi_calcError(PI_PI162, result->value);
  }

  GenericSyncDeclarations_stopSyncFor1Mutex(&result->mutex);
  
  return error;
}


static void pi_calcPiBlock(long double* result, uint32_t start, uint32_t end) 
{
  long double piItem;
  for ( uint32_t i = start; i < end; ++i )
  {
    pi_calcPiItem(&piItem, i);
    *result += piItem;
  }

}


static void pi_calcPiItem(long double* piItem, uint32_t index) 
{
  *piItem = 4.0 * (pow(-1.0,index) / (2.0 * index + 1.0));
}


static void* pi_parFun_a61a5(void* voidArgs) 
{
  int8_t** result = malloc(sizeof(int8_t*));
  struct pi_Args_a61a5* args = ((struct pi_Args_a61a5*)(voidArgs));
  *result = pi_reduce(PI_BLOCKCOUNT, (args)->resultPointer, (args)->queuePointer);
  free(voidArgs);
  return result;
}


static void* pi_parFun_a0a0k0f(void* voidArgs) 
{
  struct pi_Args_a0a0k0f* args = ((struct pi_Args_a0a0k0f*)(voidArgs));
  pi_map(PI_THRESHOLD, (args)->counterPointer, (args)->queuePointer);
  return 0;
}


static  void pi_init_queue_0(struct queue_SharedTypes_0_SharedOf_Queue_0* queue) 
{
  GenericSharedDeclarations_initMutex_0(&queue->mutexAttribute, &queue->mutex);
  for ( int8_t __i_0 = 0; __i_0 < QUEUE_QUEUESIZE; __i_0++ )
  {
    GenericSharedDeclarations_initMutex_0(&queue->value.data[__i_0].mutexAttribute, &queue->value.data[__i_0].mutex);
  }

}


static  void pi_destroy_queue_0(struct queue_SharedTypes_0_SharedOf_Queue_0* queue) 
{
  GenericSharedDeclarations_destroyMutex_0(&queue->mutex);
  for ( int8_t __i_0 = 0; __i_0 < QUEUE_QUEUESIZE; __i_0++ )
  {
    GenericSharedDeclarations_destroyMutex_0(&queue->value.data[__i_0].mutex);
  }

}


static  void pi_init_counter_0(struct GenericSharedDeclarations_SharedOf_uint32_0* counter) 
{
  GenericSharedDeclarations_initMutex_0(&counter->mutexAttribute, &counter->mutex);
}


static  void pi_destroy_counter_0(struct GenericSharedDeclarations_SharedOf_uint32_0* counter) 
{
  GenericSharedDeclarations_destroyMutex_0(&counter->mutex);
}


static  void pi_init_result_0(struct GenericSharedDeclarations_SharedOf_long_double_0* result) 
{
  GenericSharedDeclarations_initMutex_0(&result->mutexAttribute, &result->mutex);
}


static  void pi_destroy_result_0(struct GenericSharedDeclarations_SharedOf_long_double_0* result) 
{
  GenericSharedDeclarations_destroyMutex_0(&result->mutex);
}


static inline struct GenericTaskDeclarations_Task pi_taskInit_a0a0k0f(struct GenericSharedDeclarations_SharedOf_uint32_0* counterPointer, struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer) 
{
  struct pi_Args_a0a0k0f* args_a0a0k0f = malloc(sizeof(struct pi_Args_a0a0k0f));
  args_a0a0k0f->counterPointer = counterPointer;
  args_a0a0k0f->queuePointer = queuePointer;
  return (struct GenericTaskDeclarations_Task){args_a0a0k0f,&pi_parFun_a0a0k0f,sizeof(struct pi_Args_a0a0k0f)};
}


static inline struct GenericTaskDeclarations_Task pi_taskInit_a61a5(struct queue_SharedTypes_0_SharedOf_Queue_0* queuePointer, struct GenericSharedDeclarations_SharedOf_long_double_0* resultPointer) 
{
  struct pi_Args_a61a5* args_a61a5 = malloc(sizeof(struct pi_Args_a61a5));
  args_a61a5->resultPointer = resultPointer;
  args_a61a5->queuePointer = queuePointer;
  return (struct GenericTaskDeclarations_Task){args_a61a5,&pi_parFun_a61a5,sizeof(struct pi_Args_a61a5)};
}



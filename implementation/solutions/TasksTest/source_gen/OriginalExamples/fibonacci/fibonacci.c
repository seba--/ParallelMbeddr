#include "fibonacci.h"


#include "GenericDeclarations.h"
#include <stdlib.h>
#include <pthread.h>

struct fibonacci_Args_a0a0a2a0 {
  int8_t i;
};

struct fibonacci_Args_a0a0a2a0_0 {
  int8_t i;
};

static int32_t fibonacci_calcNthFibo(int8_t n);

static void* fibonacci_parFun_a0a0a2a0(void* voidArgs);

static inline struct GenericDeclarations_Task fibonacci_taskInit_a0a0a2a0(int8_t i);

static inline int32_t* fibonacci_futureResult(int8_t i,struct GenericDeclarations_Future fiboFutures[50]);

static inline struct GenericDeclarations_Future fibonacci_futureJoin(int8_t i,struct GenericDeclarations_Future fiboFutures[50]);

int32_t main(int32_t argc, char* argv[]) 
{
  
  struct GenericDeclarations_Future fiboFutures[50];
  for ( int8_t i = 0; i < 50; ++i )
  {
    fiboFutures[i] = runTaskAndGetFuture(fibonacci_taskInit_a0a0a2a0(i));
  }

  
  int32_t* results[50];
  for ( int8_t i = 0; i < 50; ++i )
  {
    results[i] = fibonacci_futureResult(i, fiboFutures);
  }

  
  return 0;
}


static int32_t fibonacci_calcNthFibo(int8_t n) 
{
  if ( n == 1 || n == 2 ) 
  {
    return 1;
  }

  return fibonacci_calcNthFibo(n - 1) + fibonacci_calcNthFibo(n - 2);
}


static void* fibonacci_parFun_a0a0a2a0(void* voidArgs) 
{
  struct fibonacci_Args_a0a0a2a0_0* args = ((struct fibonacci_Args_a0a0a2a0_0*)(voidArgs));
  int32_t* result = malloc(sizeof(int32_t));
  *result = fibonacci_calcNthFibo((*args).i + 1);
  return result;
}


static inline struct GenericDeclarations_Task fibonacci_taskInit_a0a0a2a0(int8_t i) 
{
  struct fibonacci_Args_a0a0a2a0_0* args_a0a0a2a0 = malloc(sizeof(int32_t));
  args_a0a0a2a0->i = i;
  struct GenericDeclarations_Task task1 = {args_a0a0a2a0,&fibonacci_parFun_a0a0a2a0};
  return task1;
}


static inline int32_t* fibonacci_futureResult(int8_t i, struct GenericDeclarations_Future fiboFutures[50]) 
{
  struct GenericDeclarations_Future future = fibonacci_futureJoin(i, fiboFutures);
  if ( !((future.finished)) ) 
  {
    pthread_join(&(future.pth),0);
  }

  return future.result;
}


static inline struct GenericDeclarations_Future fibonacci_futureJoin(int8_t i, struct GenericDeclarations_Future fiboFutures[50]) 
{
  struct GenericDeclarations_Future future = fiboFutures[i];
  if ( !((future.finished)) ) 
  {
    pthread_join(&(future.pth),0);
    future.finished = 1;
  }

  return future;
}



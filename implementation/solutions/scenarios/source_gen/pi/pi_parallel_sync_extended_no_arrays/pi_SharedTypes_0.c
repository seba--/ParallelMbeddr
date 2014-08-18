#include "pi_SharedTypes_0.h"


#include "GenericSharedDeclarations.h"
#include "queue_SharedTypes_0.h"

void pi_SharedTypes_0_mutexInit_4(pi_SharedTypes_0_SharedOf_FlaggedQueue_0_t* var) 
{
  pthread_mutex_init(&var->mutex,&GenericSharedDeclarations_mutexAttribute_0);
  pi_SharedTypes_0_mutexInit_3(&var->value);
}

void pi_SharedTypes_0_mutexDestroy_4(pi_SharedTypes_0_SharedOf_FlaggedQueue_0_t* var) 
{
  pthread_mutex_destroy(&var->mutex);
  pi_SharedTypes_0_mutexDestroy_3(&var->value);
}

void pi_SharedTypes_0_mutexInit_3(pi_SharedTypes_0_FlaggedQueue_t* var) 
{
  pthread_mutex_init(&var->itemCount.mutex,&GenericSharedDeclarations_mutexAttribute_0);
  queue_SharedTypes_0_mutexInit_2(&var->queue);
  pthread_mutex_init(&var->isFull.mutex,&GenericSharedDeclarations_mutexAttribute_0);
  pthread_mutex_init(&var->isFinished.mutex,&GenericSharedDeclarations_mutexAttribute_0);
}

void pi_SharedTypes_0_mutexDestroy_3(pi_SharedTypes_0_FlaggedQueue_t* var) 
{
  pthread_mutex_destroy(&var->itemCount.mutex);
  queue_SharedTypes_0_mutexDestroy_2(&var->queue);
  pthread_mutex_destroy(&var->isFull.mutex);
  pthread_mutex_destroy(&var->isFinished.mutex);
}


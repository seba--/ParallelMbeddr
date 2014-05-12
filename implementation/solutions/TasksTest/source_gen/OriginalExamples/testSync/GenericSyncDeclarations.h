#ifndef GENERICSYNCDECLARATIONS_H
#define GENERICSYNCDECLARATIONS_H


#include <stdint.h>

#include <stddef.h>

#include <pthread.h>



#ifdef __cplusplus
extern "C" {
#endif

struct GenericSyncDeclarations_SharedInt32_0 {
  pthread_mutexattr_t mutexAttribute;
  pthread_mutex_t mutex;
  int32_t value;
};

struct GenericSyncDeclarations_SharedInt16_0 {
  pthread_mutexattr_t mutexAttribute;
  pthread_mutex_t mutex;
  int16_t value;
};

struct GenericSyncDeclarations_SharedInt8_0 {
  pthread_mutexattr_t mutexAttribute;
  pthread_mutex_t mutex;
  int8_t value;
};

void GenericSyncDeclarations_initMutex_0(pthread_mutexattr_t* mutexAttribute,pthread_mutex_t* mutex);

void GenericSyncDeclarations_destroyMutex_0(pthread_mutex_t* mutex);


#ifdef __cplusplus
} /* extern "C" */
#endif

#endif

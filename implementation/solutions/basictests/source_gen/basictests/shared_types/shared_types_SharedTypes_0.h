#ifndef SHARED_TYPES_SHAREDTYPES_0_H
#define SHARED_TYPES_SHAREDTYPES_0_H


#include <stdint.h>

#include <stddef.h>

#include <stdbool.h>

#include "GenericSharedDeclarations.h"

#include <pthread.h>



#ifdef __cplusplus
extern "C" {
#endif

typedef struct shared_types_SharedTypes_0_A shared_types_SharedTypes_0_A_t;
struct shared_types_SharedTypes_0_A {
  double val;
};

typedef struct shared_types_SharedTypes_0_SharedOf_ArrayOf_ArrayOf_A_0 shared_types_SharedTypes_0_SharedOf_ArrayOf_ArrayOf_A_0_t;
struct shared_types_SharedTypes_0_SharedOf_ArrayOf_ArrayOf_A_0 {
  pthread_mutex_t mutex;
  shared_types_SharedTypes_0_A_t value[5][10];
};

typedef struct shared_types_SharedTypes_0_SharedOf_ArrayOf_A_0 shared_types_SharedTypes_0_SharedOf_ArrayOf_A_0_t;
struct shared_types_SharedTypes_0_SharedOf_ArrayOf_A_0 {
  pthread_mutex_t mutex;
  shared_types_SharedTypes_0_A_t value[5];
};

typedef struct shared_types_SharedTypes_0_SharedOf_A_0 shared_types_SharedTypes_0_SharedOf_A_0_t;
struct shared_types_SharedTypes_0_SharedOf_A_0 {
  pthread_mutex_t mutex;
  shared_types_SharedTypes_0_A_t value;
};


#ifdef __cplusplus
} /* extern "C" */
#endif

#endif

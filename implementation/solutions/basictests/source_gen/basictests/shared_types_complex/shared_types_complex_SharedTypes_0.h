#ifndef SHARED_TYPES_COMPLEX_SHAREDTYPES_0_H
#define SHARED_TYPES_COMPLEX_SHAREDTYPES_0_H


#include <stdint.h>

#include <stddef.h>

#include <stdbool.h>

#include "GenericSharedDeclarations.h"

#include <pthread.h>



#ifdef __cplusplus
extern "C" {
#endif

typedef struct shared_types_complex_SharedTypes_0_A4 shared_types_complex_SharedTypes_0_A4_t;
struct shared_types_complex_SharedTypes_0_A4 {
  GenericSharedDeclarations_SharedOf_ArrayOf_int32_1_t s[6];
};

typedef struct shared_types_complex_SharedTypes_0_A3 shared_types_complex_SharedTypes_0_A3_t;
struct shared_types_complex_SharedTypes_0_A3 {
  GenericSharedDeclarations_SharedOf_ArrayOf_int32_0_t s1[6];
  GenericSharedDeclarations_SharedOf_ArrayOf_int32_0_t s2[6];
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_A3_0 shared_types_complex_SharedTypes_0_SharedOf_A3_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_A3_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_A3_t value;
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_SharedOf_A3_0_0 shared_types_complex_SharedTypes_0_SharedOf_SharedOf_A3_0_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_SharedOf_A3_0_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_SharedOf_A3_0_t value;
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_A4_0 shared_types_complex_SharedTypes_0_SharedOf_A4_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_A4_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_A4_t value;
};

typedef struct shared_types_complex_SharedTypes_0_B2 shared_types_complex_SharedTypes_0_B2_t;
struct shared_types_complex_SharedTypes_0_B2 {
  GenericSharedDeclarations_SharedOf_int32_0_t s[1][2][3];
};

typedef struct shared_types_complex_SharedTypes_0_B1 shared_types_complex_SharedTypes_0_B1_t;
struct shared_types_complex_SharedTypes_0_B1 {
  GenericSharedDeclarations_SharedOf_int32_0_t s;
};

typedef struct shared_types_complex_SharedTypes_0_A1 shared_types_complex_SharedTypes_0_A1_t;
struct shared_types_complex_SharedTypes_0_A1 {
  shared_types_complex_SharedTypes_0_B1_t b;
};

typedef struct shared_types_complex_SharedTypes_0_A2 shared_types_complex_SharedTypes_0_A2_t;
struct shared_types_complex_SharedTypes_0_A2 {
  shared_types_complex_SharedTypes_0_B1_t b1;
  shared_types_complex_SharedTypes_0_B2_t b2[4];
  GenericSharedDeclarations_SharedOf_int32_0_t* i;
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_A2_0 shared_types_complex_SharedTypes_0_SharedOf_A2_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_A2_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_A2_t value;
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_A1_0 shared_types_complex_SharedTypes_0_SharedOf_A1_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_A1_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_A1_t value;
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_PointerOf_SharedOf_A2_0_0 shared_types_complex_SharedTypes_0_SharedOf_PointerOf_SharedOf_A2_0_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_PointerOf_SharedOf_A2_0_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_SharedOf_A2_0_t* value;
};

typedef struct shared_types_complex_SharedTypes_0_SharedOf_PointerOf_SharedOf_A1_0_0 shared_types_complex_SharedTypes_0_SharedOf_PointerOf_SharedOf_A1_0_0_t;
struct shared_types_complex_SharedTypes_0_SharedOf_PointerOf_SharedOf_A1_0_0 {
  pthread_mutex_t mutex;
  shared_types_complex_SharedTypes_0_SharedOf_A1_0_t* value;
};

void shared_types_complex_SharedTypes_0_mutexInit_11(shared_types_complex_SharedTypes_0_SharedOf_SharedOf_A3_0_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_13(shared_types_complex_SharedTypes_0_A4_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_4(shared_types_complex_SharedTypes_0_B2_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_0(shared_types_complex_SharedTypes_0_B1_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_10(shared_types_complex_SharedTypes_0_SharedOf_A3_0_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_14(shared_types_complex_SharedTypes_0_SharedOf_A4_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_10(shared_types_complex_SharedTypes_0_SharedOf_A3_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_4(shared_types_complex_SharedTypes_0_B2_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_9(shared_types_complex_SharedTypes_0_A3_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_6(shared_types_complex_SharedTypes_0_A2_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_7(shared_types_complex_SharedTypes_0_SharedOf_A2_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_2(shared_types_complex_SharedTypes_0_SharedOf_A1_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_11(shared_types_complex_SharedTypes_0_SharedOf_SharedOf_A3_0_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_9(shared_types_complex_SharedTypes_0_A3_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_6(shared_types_complex_SharedTypes_0_A2_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_14(shared_types_complex_SharedTypes_0_SharedOf_A4_0_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_7(shared_types_complex_SharedTypes_0_SharedOf_A2_0_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_1(shared_types_complex_SharedTypes_0_A1_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_5(shared_types_complex_SharedTypes_0_B2_t* var, int32_t size_0);

void shared_types_complex_SharedTypes_0_mutexDestroy_1(shared_types_complex_SharedTypes_0_A1_t* var);

void shared_types_complex_SharedTypes_0_mutexDestroy_0(shared_types_complex_SharedTypes_0_B1_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_2(shared_types_complex_SharedTypes_0_SharedOf_A1_0_t* var);

void shared_types_complex_SharedTypes_0_mutexInit_5(shared_types_complex_SharedTypes_0_B2_t* var, int32_t size_0);

void shared_types_complex_SharedTypes_0_mutexInit_13(shared_types_complex_SharedTypes_0_A4_t* var);


#ifdef __cplusplus
} /* extern "C" */
#endif

#endif
